package test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage1 {
	private WebDriver driver;
	String url = "https://www.redmine.org/account/register";
	@FindBy(css="[class=\"home\"]")
	WebElement home;
	
	@FindBy(css="[class=\"projects\"]")
	WebElement projects;
	
	@FindBy(css="[class=\"help\"]")
	WebElement help;
	
	@FindBy(css="[class=\"login\"]")
	WebElement login;
	
	@FindBy(css="[class=\"register\"]")
	WebElement register;
	
	


	public TestPage1 (WebDriver driver){
		 this.driver=driver;
		 driver.get(url);
		 PageFactory.initElements(driver, this);
	}
	public void clickHome() {
		home.click();
	}
	public void clickProjects() {
		projects.click();
	}
	public void clickHelp() {
		help.click();
	}
	public void clickLogin() {
		login.click();
	}
	public void clickRegister() {
		register.click();
	}

	   
	
	 public boolean testResults(String expectedResult,String actualRes) {
		boolean result;
		  if(actualRes.equals(expectedResult)) {
			   result = true;
			  System.out.println("Test finished successfully");
		  }else {
			  result=false;
			  System.out.println("Test finished unsuccessfully");
		  }
		  driver.navigate().back();
		  System.out.println(result);
		  return result;
	  }
}