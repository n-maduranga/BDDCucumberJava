package stepDefinition;

import ApplicationHooks.setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class EmployeeStepDefs {

    private WebDriver driver;
    HomePage homePage;


    //creating EmployeeStepDefs constructor
    public EmployeeStepDefs(){
        this.driver = setup.getDriver();//need to get driver from setup class
        this.homePage = new HomePage(driver);
    }
    @When("I click PIM link")
    public void i_click_pim_link() {
        homePage.clickPIMLink();
    }
    @Then("I can see the Employee Information page")
    public void i_can_see_the_employee_information_page() {

    }
    @When("I click +Add button")
    public void i_click_add_button() {

    }
    @Then("I can see Add Employee page")
    public void i_can_see_add_employee_page() {

    }
    @When("I enter employee {string} and {string} and {string}")
    public void i_enter_employee_and_and(String string, String string2, String string3) {

    }
    @When("I click Save button")
    public void i_click_save_button() {

    }
    @Then("I should be able to see successfully added employees")
    public void i_should_be_able_to_see_successfully_added_employees() {

    }

}
