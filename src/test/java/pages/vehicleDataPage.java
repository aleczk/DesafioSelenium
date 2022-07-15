package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static driver.driverFactory.getDriver;
import static org.junit.Assert.fail;


public class vehicleDataPage {

    private WebDriver driver = getDriver();


    public void setMaker(String maker) {
        try {
            new Select(driver.findElement(By.id("make"))).selectByVisibleText(maker);
        } catch (Exception e) {
            fail("Erro ao preencher campo Make: não foi possível encontrar a montadora desejada.");
        }
    }

    public void setPerformance(String enginePerformance) {
        try {
            if (Integer.parseInt(enginePerformance) <= 2000 && (Integer.parseInt(enginePerformance) > 0)) {
                driver.findElement(By.id("engineperformance")).sendKeys(enginePerformance);
            } else {
                throw new Exception("o número deve estar entre 0 e 2000.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Engine Performance: " + e.getMessage());
        }
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        // Checagem para ver se a data fornecida não está no futuro ou é inválida.
        try {
            if ((!LocalDate.parse(dateOfManufacture, DateTimeFormatter.ofPattern("MM/dd/yyyy")).isAfter(LocalDate.now()))
                    || (LocalDate.parse(dateOfManufacture) != null)) {
                driver.findElement(By.id("dateofmanufacture")).sendKeys(dateOfManufacture);
            } else {
                throw new Exception("a data fornecida não pode estar no futuro.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Date of Manufacture: " + e.getMessage());
        }
    }

    public void setNumberOfSeats(String numberOfSeats) {
        try {
            new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText(numberOfSeats);
        } catch (Exception e) {
            fail("Erro ao preencher campo Number of Seats: o número de assentos é inválido.");
        }
    }

    public void setFuelType(String fuelType) {
        try {
            new Select(driver.findElement(By.id("fuel"))).selectByVisibleText(fuelType);
        } catch (Exception e) {
            fail("Erro ao preencher campo Fuel Type: o tipo de combustível é inválido.");
        }
    }

    public void setListPrice(String listPrice) {
        try {
            if (Integer.parseInt(listPrice) <= 100000 && Integer.parseInt(listPrice) >= 500) {
                driver.findElement(By.id("listprice")).sendKeys(listPrice);
            } else {
                throw new Exception("o valor deve estar entre 500 e 100 mil.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo List Price: " + e.getMessage());
        }
    }

    public void setLicensePlate(String licensePlate) {
        try {
            if (licensePlate.length() <= 10) {
                driver.findElement(By.id("licenseplatenumber")).sendKeys(licensePlate);
            } else {
                throw new Exception("a placa do carro deve conter 10 ou menos caracteres.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo License Plate Number: " + e.getMessage());
        }
    }

    public void setAnnualMileage(String annualMileage) {
        try {
            if (Integer.parseInt(annualMileage) <= 100000 && Integer.parseInt(annualMileage) >= 100) {
                driver.findElement(By.id("annualmileage")).sendKeys(annualMileage);
            } else {
                throw new Exception("a quantidade de milhas deve estar entre 100 e 100 mil.");
            }
        } catch (Exception e) {
            fail("Erro ao preencher campo Annual Mileage: " + e.getMessage());
        }
    }
}
