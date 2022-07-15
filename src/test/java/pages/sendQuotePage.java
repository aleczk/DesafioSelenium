package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static driver.driverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class sendQuotePage {

    private WebDriver driver = getDriver();


    public void setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            if (phoneNumber.matches("\\d{8,15}")) {
                driver.findElement(By.id("phone")).sendKeys(phoneNumber);
            } else {
                throw new Exception("o número de telefone deve conter entre 8 e 15 dígitos.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Phone: " + e.getMessage());
        }
    }

    public void setUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(By.id("confirmpassword")).sendKeys(confirmPassword);
    }

    public void validarEnvio(String respostaEsperada) {

        try {
            Thread.sleep(10000);
            assertEquals(respostaEsperada,
                    driver.findElement(By.xpath("//h2[normalize-space()='Sending e-mail success!']")).getText());

        } catch (Exception e) {
            fail("Não foi possível validar o envio do e-mail.");
        }


    }
}
