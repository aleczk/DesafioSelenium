package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static driver.driverFactory.getDriver;
import static org.junit.Assert.fail;


public class productDataPage {

    private WebDriver driver = getDriver();

    public void setStartDate(String startDate) {
        driver.findElement(By.id("startdate")).sendKeys(startDate);
    }

    public void setInsuranceSum(String insuranceSum) {
        try {
            new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText(insuranceSum);
        } catch (Exception e) {
            fail("Erro ao preencher campo Insurance Sum: O valor do seguro é inválido.");
        }
    }

    public void setMeritRating(String meritRating) {
        try {
            new Select(driver.findElement(By.id("meritrating"))).selectByVisibleText(meritRating);
        } catch (Exception e) {
            fail("Erro ao preencher campo Merit Rating: Merit Rating inválido.");
        }
    }

    public void setDamageInsurance(String damageInsurace) {
        try {
            new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText(damageInsurace);
        } catch (Exception e) {
            fail("Erro ao preencher campo Damage Insurace: valor inválido.");
        }
    }

    public void setOptionProducts() {
        // Mais uma vez, selecionarei os dois campos.
        driver.findElement(By.xpath("//label[normalize-space()='Euro Protection']//span[@class='ideal-check']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Legal Defense Insurance']//span[@class='ideal-check']")).click();
    }

    public void setCourtesyCar(String courtesyCar) {
        new Select(driver.findElement(By.id("courtesycar"))).selectByVisibleText(courtesyCar);
    }

}
