package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver; //since this is private this cannot access outside of Login Page class
    //page locators
    private By txtUserName = By.name("username");
    private By txtPassword = By.name("password");
    private By BtnLogin = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    private By linkForgotPw = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //page methods/actions
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(linkForgotPw).isDisplayed();
    }

    public void enterUserName(String username) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(txtUserName).sendKeys(username);
    }
    public void enterPassword(String pwd) {

        driver.findElement(txtPassword).sendKeys(Keys.CONTROL + "a");
        driver.findElement(txtPassword).sendKeys(Keys.DELETE);
        driver.findElement(txtPassword).sendKeys(pwd);
        System.out.println(pwd);
    }

    public void clickLogin() {
        driver.findElement(BtnLogin).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doLogin(String uname,String pwd) {
        System.out.println("Login with:"+uname+pwd);
        driver.findElement(txtUserName).sendKeys(uname);
        driver.findElement(txtPassword).sendKeys(pwd);
        driver.findElement(BtnLogin).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public void navigateForgotPasswordPage(){
        driver.findElement(linkForgotPw).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String verifyErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public String getForgotPasswordPageURL(){
        String forgotPwURL = driver.getCurrentUrl();
        return forgotPwURL;
    }
}
