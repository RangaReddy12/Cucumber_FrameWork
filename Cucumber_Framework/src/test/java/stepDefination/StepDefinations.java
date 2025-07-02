package stepDefination;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	String Emp_id="";
	WebDriver driver;
	int count ;
	@BeforeTest
	@Given("i navigate url{string} in a browser")
	public void i_navigate_url_in_a_browser(String url) {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get(url);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	}

	@Then("i check login button displayed in home page")
	public void i_check_login_button_displayed_in_home_page() {
	    if(driver.findElement(By.name("Submit")).isDisplayed())
	    {
	    	System.out.println("Login Button Displayed In Home Page");
	    }
	}

	@When("user enter username as{string}")
	public void user_enter_username_as(String user) {
	    driver.findElement(By.name("txtUsername")).sendKeys(user);
	}

	@When("user enter password as {string}")
	public void user_enter_password_as(String pass) {
		 driver.findElement(By.name("txtPassword")).sendKeys(pass);  
	}

	@When("i click login button")
	public void i_click_login_button() throws Throwable {
	  driver.findElement(By.name("Submit")).click();
	  Thread.sleep(2000);
	}

	@Then("i verify url for login success")
	public void i_verify_url_for_login_success() {
	    String Expected="dashboard";
	    String Actual = driver.getCurrentUrl();
	    if(Actual.contains(Expected))
	    {
	    	System.out.println("Login Success");
	    }
	    else
	    {
	    	String errormess = driver.findElement(By.id("spanMessage")).getText();
	    	System.out.println(errormess+"    "+"Login Fail");
	    }
	}
@AfterTest
	@When("i close  browser")
	public void i_close_browser() {
	   driver.quit();
	}
@When("i navigate to add employee page")
public void i_navigate_to_add_employee_page() {
   driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
   driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		   }

@When("user enter fname as{string}")
public void user_enter_fname_as(String fname) {
  driver.findElement(By.name("firstName")).sendKeys(fname);  
}

@When("user enter mname as {string}")
public void user_enter_mname_as(String mname) {
    driver.findElement(By.name("middleName")).sendKeys(mname);
}

@When("user enter as lname {string}")
public void user_enter_as_lname(String lname) {
    driver.findElement(By.name("lastName")).sendKeys(lname);
}

@When("user capture emp id")
public void user_capture_emp_id() {
    Emp_id= driver.findElement(By.name("employeeId")).getAttribute("value");
}

@When("i click save button")
public void i_click_save_button() throws Throwable {
    driver.findElement(By.id("btnSave")).click();
    Thread.sleep(2000);
}

@Then("verify emp id in table")
public void verify_emp_id_in_table() throws Throwable {
	
    driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    driver.findElement(By.name("empsearch[id]")).sendKeys(Emp_id);
    driver.findElement(By.name("_search")).click();
    Thread.sleep(2000);
    WebElement webtable = driver.findElement(By.id("resultTable"));
    List<WebElement> rows = webtable.findElements(By.tagName("tr"));
    boolean flag = false;
    for(int i=1;i<=rows.size();i++)
    {
    	List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
    	if(cols.get(1).getText().equals(Emp_id))
    	{
    		flag=true;
    		break;
    	}
    }
    if(flag)
    {
    	System.out.println("Employee id found in table");
    }
    else
    {
    	System.out.println("Employee id not found in table");
    }
}
}