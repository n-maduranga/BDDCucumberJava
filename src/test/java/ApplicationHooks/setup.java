package ApplicationHooks;

import Util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class setup {
    private static WebDriver driver;
    String browser = "firefox";
    public static WebDriver getDriver()
    {
        return driver;
    }

    @Before
    public void setupDriver() {

        Properties prop =  ConfigReader.readPropertiesFile();
        String browser = prop.getProperty("browser");

        System.out.println("browser value is:" + browser);
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("", "");
            driver = new EdgeDriver();

        } else {
            System.out.println("Invalid browser value:" + browser);
        }

    }
    @After
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
