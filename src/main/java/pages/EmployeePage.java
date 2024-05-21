package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {

    private WebDriver driver;

    //Page elements
    By pageHeader = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5");


    //Constructor
    public EmployeePage(WebDriver driver){
        this.driver = driver;

    }
    public String getEmpPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

}
