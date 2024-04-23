package ApplicationHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setup {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
