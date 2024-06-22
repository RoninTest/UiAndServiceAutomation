package service.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.config.ConfigReader;

import java.time.Duration;
import java.util.Set;

public class Driver {

    public static WebDriver driver;
    public static ConfigReader configReader;
    public static Actions action;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;


    public static WebDriver getDriver() {
        if (driver == null) {
            configReader = new ConfigReader();
            WebDriverManager.chromedriver().clearDriverCache().setup();
            ChromeOptions options = new ChromeOptions();
            try {
                driver = new ChromeDriver(options);
            }catch (Exception e){
            }

            driver.get(configReader.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            action = new Actions(Driver.getDriver());
            wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            js = (JavascriptExecutor) Driver.getDriver();
        }
        return driver;

    }

    public static void closeAllWindowsAndCloseMain() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle).close();
            }
        }
        driver.switchTo().window(mainWindowHandle).close();
        driver = null;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
