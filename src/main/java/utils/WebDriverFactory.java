package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class WebDriverFactory {

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    /**
     * Generate the correct driver accordingly to what is passed in the parameters
     * the default browser is chrome
     * @param browser String with the browser that we want to open only suporting for the moment chrome and firefox
     * @param headless in case that you want to run the test in headless mode
     * @return ChromeDriver or FirefoxDriver
     */
    public static WebDriver initWebDriver(String browser, boolean headless) {
        WebDriver driver;
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "firefox":
                WebDriverManager.firefoxdriver().driverVersion("0.30.0").setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(headless);
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        driver.manage().window().maximize();
        threadLocalDriver.set(driver);
        return  getWebDriver();
    }

    public static synchronized WebDriver getWebDriver() {
        return threadLocalDriver.get();
    }
}
