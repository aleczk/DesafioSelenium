package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static driver.driverFactory.getDriver;
import static org.junit.Assert.fail;

public class insurantDataPage {

    private WebDriver driver = getDriver();

    public void setFirstName(String firstName) {
        try {
            if (firstName.length() >= 2 && firstName.matches("[a-zA-Z]+")) {
                driver.findElement(By.id("firstname")).sendKeys(firstName);
            } else {
                throw new Exception("não é aceito o uso de caracteres especiais ou números.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher o campo de nome: " + e.getMessage());
        }
    }

    public void setLastName(String lastName) {
        try {
            if (lastName.length() >= 2 && lastName.matches("[a-zA-Z]+")) {
                driver.findElement(By.id("lastname")).sendKeys(lastName);
            } else {
                throw new Exception("não é aceito o uso de caracteres especiais ou números.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher o campo de sobrenome: " + e.getMessage());
        }
    }

    public void setDateOfBirth(String dateOfBirth) {
        // Checagem para ver se a data fornecida não está no futuro ou é inválida.
        try {
            if ((!LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("MM/dd/yyyy")).isAfter(LocalDate.now()))
                    || (LocalDate.parse(dateOfBirth) != null)) {
                driver.findElement(By.id("birthdate")).sendKeys(dateOfBirth);
            } else {
                throw new Exception("a data fornecida não pode estar no futuro.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Date of Birth: " + e.getMessage());
        }
    }

    public void setGender(String gender) {

        gender = gender.toUpperCase();

        try {
            if (gender.equals("MALE")) {
                driver.findElement(By.xpath("//label[normalize-space()='Male']//span[@class='ideal-radio']")).click();
            } else if (gender.equals("FEMALE")) {
                driver.findElement(By.xpath("//label[normalize-space()='Female']//span[@class='ideal-radio']")).click();
            } else {
                throw new Exception("gênero inválido.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Gender: " + e.getMessage());
        }
    }

    public void setStreetAddress(String streetAddress) {
        try {
            if (streetAddress.length() >= 3) {
                driver.findElement(By.id("streetaddress")).sendKeys(streetAddress);
            } else {
                throw new Exception("o endereço deve conter ao menos 3 caracteres.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Street Address: " + e.getMessage());
        }
    }

    public void setCountry(String country) {
        try {
            new Select(driver.findElement(By.id("country"))).selectByVisibleText(country);
        } catch (Exception e) {
            fail("Erro ao preencher campo Country: não foi possível encontrar o país desejado.");
        }
    }

    public void setZipCode(String zipCode) {
        try {
            if (zipCode.matches("\\d{4,8}")) {
                driver.findElement(By.id("zipcode")).sendKeys(zipCode);
            } else {
                throw new Exception("o Zip Code deve conter entre 4 e 8 dígitos.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Zip Code: " + e.getMessage());
        }
    }

    public void setCity(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void setOccupation(String occupation) {
        try {
            new Select(driver.findElement(By.id("occupation"))).selectByVisibleText(occupation);
        } catch (Exception e) {
            fail("Erro ao preencher campo Occupation: a profissão escolhida não existe.");
        }
    }

    public void setHobbies() {
        // Para não me alongar, escolhi 3 hobbies aleatórios como padrão.
        driver.findElement(By.xpath("//label[normalize-space()='Speeding']//span[@class='ideal-check']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Cliff Diving']//span[@class='ideal-check']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Other']//span[@class='ideal-check']")).click();
    }

    public void setWebsite(String website) {
        // A regra para o padrão de URL não está clara, por isso a deixei sem.
        driver.findElement(By.id("website")).sendKeys(website);
    }
}