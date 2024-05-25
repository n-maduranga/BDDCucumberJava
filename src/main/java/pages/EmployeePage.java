package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {

    private WebDriver driver;

    //Page elements
    private By pageHeader = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5");
    private By btnAdd = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    private By fname = By.name("firstName");
    private By mname = By.name("middleName");
    private By lname = By.name("lastName");
    private By empID = By.xpath(
            "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    private By btnSave = By.xpath("//button[@type='submit']");
    private By linkEmpList = By.xpath("//a[contains(text(),'Employee List')]");
    private By headerPIM = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    private By headerAddEmp = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6");
    private By recordCountmsg = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");

    //Constructor
    public EmployeePage(WebDriver driver){
        this.driver = driver;

    }
    public String getEmpPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

    public void clickAddEmployeeButton()  {
        driver.findElement(btnAdd).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAddEmpPageHeader(){
        return driver.findElement(headerAddEmp).getText();
    }

}
