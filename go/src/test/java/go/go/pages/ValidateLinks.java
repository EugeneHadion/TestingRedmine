package go.go.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateLinks {
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
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[2]/h2[1]")
	WebElement header;
	


	public ValidateLinks (WebDriver driver){
		 this.driver=driver;
		 driver.get(url);
		 PageFactory.initElements(driver, this);
	}
	public void clickBatton(WebElement element) {
		element.click();
	}
	

	   
	 public boolean testResults(String expectedResult,String actualRes) {
		boolean result;
		  if(actualRes.equals(expectedResult)) {
			   result = true;
			
		  }else {
			  result=false;
			
		  }
		  driver.navigate().back();
		  System.out.println(result);
		  return result;
	  }
}