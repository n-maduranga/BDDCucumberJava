package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/employee.feature",
        glue = {"stepDefinition","ApplicationHooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true

)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    public Object[][] scenario(){
        return super.scenarios();
    }

}
