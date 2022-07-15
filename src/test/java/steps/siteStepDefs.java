package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;

import static driver.driverFactory.getDriver;


public class siteStepDefs {

    private WebDriver driver = getDriver();

    vehicleDataPage vdp = new vehicleDataPage();
    insurantDataPage idp = new insurantDataPage();
    productDataPage pdp = new productDataPage();
    priceOptionPage pop = new priceOptionPage();
    sendQuotePage sqp = new sendQuotePage();


    @Dado("que acesso o site do desafio")
    public void queAcessoOSiteDoDesafio() {
        driver.get("http://sampleapp.tricentis.com/101/app.php");
        driver.findElement(By.id("nav_automobile")).click();
    }

    @E("preencho os dados do veículo")
    public void preenchoOsDadosDoVeiculo() {
        vdp.setMaker("Volkswagen");
        vdp.setPerformance("1000");
        vdp.setDateOfManufacture("07/14/2022");
        vdp.setNumberOfSeats("5");
        vdp.setFuelType("Petrol");
        vdp.setListPrice("500");
        vdp.setLicensePlate("H1R3M3-PLS");
        vdp.setAnnualMileage("5000");
        driver.findElement(By.id("nextenterinsurantdata")).click();
    }

    @E("preencho os dados pessoais")
    public void preenchoOsDadosPessoais() {
        idp.setFirstName("John");
        idp.setLastName("Doe");
        idp.setDateOfBirth("03/29/1996");
        idp.setGender("male");
        idp.setStreetAddress("Baker Street");
        idp.setCountry("Viet Nam");
        idp.setCity("Hanoi");
        idp.setZipCode("58075");
        idp.setOccupation("Employee");
        idp.setHobbies();
        idp.setWebsite("hir3m3.com");
        driver.findElement(By.id("nextenterproductdata")).click();
    }

    @E("seleciono os dados do produto")
    public void selecionoOsDadosDoProduto() {
        pdp.setStartDate("02/28/2023");
        pdp.setInsuranceSum("15.000.000,00");
        pdp.setMeritRating("Malus 14");
        pdp.setDamageInsurance("Full Coverage");
        pdp.setOptionProducts();
        pdp.setCourtesyCar("Yes");
        driver.findElement(By.id("nextselectpriceoption")).click();
    }

    @E("seleciono um plano de seguro")
    public void selecionoUmPlanoDeSeguro() throws InterruptedException {
        pop.setPriceOption("Platinum");
        Thread.sleep(1000);    // Algumas vezes o navegador tentava clicar antes de carregar a página inteira.
        driver.findElement(By.id("nextsendquote")).click();
    }

    @E("preencho o orçamento")
    public void preenchoOOrcamento() {
        sqp.setEmail("h1r3m3@acc.com");
        sqp.setPhoneNumber("11335577");
        sqp.setUsername("h1r3m3");
        sqp.setPassword("!Acc3ntur3");
        sqp.setConfirmPassword("!Acc3ntur3");
    }


    @Então("quando enviado a resposta deverá ser {string}")
    public void quandoEnviadoARespostaDeveraSer(String respostaEsperada) {
        driver.findElement(By.id("sendemail")).click();
        sqp.validarEnvio(respostaEsperada);
    }
}
