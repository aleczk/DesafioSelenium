package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static driver.driverFactory.getDriver;
import static org.junit.Assert.fail;

public class priceOptionPage {

    private WebDriver driver = getDriver();

    public void setPriceOption(String priceOption) {

        try {
            switch (priceOption) {
                case "Silver":
                    driver.findElement(By.xpath("//section[@id='pricePlans']//label[1]//span[1]")).click();
                    break;
                case "Gold":
                    driver.findElement(By.xpath("//section[@id='pricePlans']//label[2]//span[1]")).click();
                    break;
                case "Platinum":
                    driver.findElement(By.xpath("//section[@id='pricePlans']//label[3]//span[1]")).click();
                    break;
                case "Ultimate":
                    driver.findElement(By.xpath("//section[@id='pricePlans']//label[4]//span[1]")).click();
                    break;
                default:
                    throw new Exception("o plano escolhido não existe.");
            }
        } catch (Exception e) {
            fail("Erro ao selecionar tipo de plano: " + e.getMessage());
        }
    }
}
