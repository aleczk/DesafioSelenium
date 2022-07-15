package steps.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import static driver.driverFactory.cleanupDriver;
import static driver.driverFactory.getDriver;


public class Hooks {

    @Before
    public void setup() {
        getDriver();
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
