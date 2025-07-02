package testRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,
features = {"./featureFiles/AdminLogin.feature"},glue = {"stepDefination"}
,monochrome = true,tags = ("@Validdata,@MultipleData not,@AddEmp not")
,plugin = {"pretty","html:target/report/cucumber",
		"junit:target/report/cucumber.xml",
		"json:target/report/cucumber.json"})
public class AppTest extends AbstractTestNGCucumberTests{

}
