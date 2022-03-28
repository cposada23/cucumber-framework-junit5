package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.WebDriverFactory;

import java.io.IOException;
import java.util.Properties;

public class Hooks {

    private static final Logger LOGGER = LogManager.getLogger(GoogleSearchSteps.class);
    private Properties properties;

    @Before(order = 0)
    public void initProperties() {
        ConfigReader configReader = new ConfigReader();
        try {
            properties =  configReader.init("src/test/resources/config/test.properties");
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Before(value = "@web", order = 1)
    public void initDriver() {
        String browser = properties.getProperty("browser");
        boolean headless = "true".equals(properties.getProperty("headless"));

        LOGGER.info("Executing test in Browser: " + browser);
        LOGGER.info("Headless Mode: " + headless);

        WebDriverFactory.initWebDriver(browser, headless);
    }

    @After(value = "@web", order = 0)
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte [] sourcePath = ((TakesScreenshot) WebDriverFactory.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
        WebDriverFactory.getWebDriver().quit();
    }

}
