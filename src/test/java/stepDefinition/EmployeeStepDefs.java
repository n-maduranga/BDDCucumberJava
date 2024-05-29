package stepDefinition;

import ApplicationHooks.setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.EmployeePage;
import pages.HomePage;

public class EmployeeStepDefs {

    private WebDriver driver;
    HomePage homePage;
    EmployeePage empPage;


    //creating EmployeeStepDefs constructor
    public EmployeeStepDefs(){
        //need to get driver from setup class
        this.driver = setup.getDriver();
        this.homePage = new HomePage(driver);
        this.empPage = new EmployeePage(driver);
    }
    @When("I click PIM link")
    public void i_click_pim_link() {
        homePage.clickPIMLink();
    }
    @Then("I can see the Employee Information page")
    public void i_can_see_the_employee_information_page() {
        String ExpectedHeader = "Employee Information";
        String ActualHeader = empPage.getEmpPageHeader();
        Assert.assertEquals(ActualHeader,ExpectedHeader);
    }
    @When("I click +Add button")
    public void i_click_add_button() {
        empPage.clickAddEmployeeButton();
    }
    @Then("I can see Add Employee page")
    public void i_can_see_add_employee_page() {
        String ExpectedHeader = "Add Employee";
        String ActualHeader = empPage.getAddEmpPageHeader();
        Assert.assertEquals(ActualHeader,ExpectedHeader);

    }
    @When("I enter employee {string} and {string} and {string}")
    public void i_enter_employee(String FirstName, String MiddleName, String LastName) {
        empPage.addEmployee(FirstName,MiddleName,LastName);
    }
    @When("I click Save button")
    public void i_click_save_button() {
        empPage.clickEmployeeSaveButton();
    }
    @Then("I should be able to see successfully added employees")
    public void i_should_be_able_to_see_successfully_added_employees() {

    }

}
