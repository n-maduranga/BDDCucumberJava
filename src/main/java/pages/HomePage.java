package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    By headerDashboard = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    By linkPIM = By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickPIMLink(){
        driver.findElement(linkPIM).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String printHeaderDashboard(){
        return driver.findElement(headerDashboard).getText();
    }



}
