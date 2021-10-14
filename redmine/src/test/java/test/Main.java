package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","..\\redmine\\driver\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();  
		 driver.navigate().to("https://www.redmine.org/account/register"); 


	}

}
