package go.go.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test3 {
	WebDriver driver;
	CheckFields tp2;
	ValidateLinks tp1;

	@BeforeTest
	public void  Setup() {
		System.setProperty("webdriver.chrome.driver","..\\go\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		tp2 = new CheckFields(driver);
		assertTrue(tp2.header.isDisplayed());
	} 
	
	
	@DataProvider(name = "TestData")
	public String [][] getData(){
		
		
		String data [][] = new String[3][8];
		for(int i = 0;i<7;i++) {
			data[0][i] = tp2.regData2.get(i);
			data[0][7] ="screen8";
		}
		for(int i = 0;i<7;i++) {
			data[1][i] = tp2.regData3.get(i);
			data[1][7] ="screen9";
		}
		for(int i = 0;i<7;i++) {
			data[2][i] = tp2.regData4.get(i);
			data[2][7] ="screen10";
		}
		
		return data;
	}
	
	@Test(dataProvider = "TestData")
	public void Test(String user,String password,String confpassword,String name,String lastname,String email,String nick,String screenname){
		tp2.login.clear();
		tp2.login.sendKeys(user);
		tp2.password.clear();
		tp2.password.sendKeys( password);
		tp2.confirmation.clear();
		tp2.confirmation.sendKeys(confpassword );
		tp2.firstname.clear();
		tp2.firstname.sendKeys( name);
		tp2.lastname.clear();
		tp2.lastname.sendKeys(lastname );
		tp2.mail.clear();
		tp2.mail.sendKeys( email );
		tp2.custom.clear();
		tp2.custom.sendKeys(nick ,Keys.ENTER);
		tp2.takeScreenShots(screenname);
		assertTrue(tp2.errorExplanation.isDisplayed());
		
		
	}
	

}
