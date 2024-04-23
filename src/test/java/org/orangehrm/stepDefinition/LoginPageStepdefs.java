package org.orangehrm.stepDefinition;

import ApplicationHooks.setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.orangehrm.pages.LoginPage;
import org.testng.Assert;

public class LoginPageStepdefs {
    private WebDriver driver;
    LoginPage loginPage;

    public LoginPageStepdefs() {
        this.driver = setup.getDriver();
        this.loginPage = new LoginPage(driver);
    }
    //These can include in Hooks
   // @Before
  //  public void setup(){
   //     System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
       // driver = new ChromeDriver();
    //}

    //@After
   // public void tearDown(){
   //     if(driver!=null) {
    //        driver.quit();
     //   }
   // }
    @Given("I am on the OrangeHRM system login Page")
    public void iAmOnTheOrangeHRMSystemLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //loginPage = new LoginPage(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("I have entered valid username and valid password")
    public void iHaveEnteredValidUsernameAndValidPassword() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("Admin123");
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be able to login succesfully")
    public void iShouldBeAbleToLoginSuccesfully() {
        String title=driver.getTitle();
        System.out.println(title);
        //need to check dashboard header
    }

    @Given("I have entered invalid {string} and invalid {string}")
    public void iHaveEnteredInvalidAndInvalid(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expError) {
        String actualE = loginPage.verifyErrorMessage();
        Assert.assertEquals(actualE,expError);

    }

    @When("I click on {string} link")
    public void iClickOnLink(String link) {
        loginPage.isForgotPwdLinkExist();
        loginPage.navigateForgotPasswordPage();
    }

    @Then("I should be redirected to the Password Reset Page")
    public void iShouldBeRedirectedToThePasswordResetPage() {
       String url =  loginPage.getForgotPasswordPageURL();
        System.out.println(url);
    }
}
