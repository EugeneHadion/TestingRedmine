package go.go.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	ValidateLinks tp1;
	CheckFields tp2;
	boolean result;
	boolean fullResult = true;
	String expectedRes;
    boolean[] result1 = new boolean[5];
    WriteResult1 cr = new WriteResult1();
	
	@BeforeTest
	public void  setup() {
		System.setProperty("webdriver.chrome.driver","..\\go\\driver\\chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		tp1 = new ValidateLinks(driver);
		assertTrue(tp1.header.isDisplayed());
		
	}
	
	 
     
	@Test
	public void testM1() throws InterruptedException,IllegalMonitorStateException {
	   	 
		 tp1.clickBatton(tp1.home);
		 expectedRes = driver.getTitle();
		 result1[0] = tp1.testResults(expectedRes,"Overview - Redmine");
          assertTrue(result1[0]);
	}
	@Test
    public void testM2() throws InterruptedException,IllegalMonitorStateException {
		 
		tp1.clickBatton(tp1.projects);
		 expectedRes = driver.getTitle();
		 result1[1] = tp1.testResults(expectedRes,"Проекты - Redmine");
		 assertTrue(result1[1]);
		 
		 }
	@Test
	public void testM3() throws InterruptedException,IllegalMonitorStateException {
		tp1.clickBatton(tp1.help);
		 expectedRes = driver.getTitle();
		 result1[2] = tp1.testResults(expectedRes,"Guide - Redmine");
		 assertTrue(result1[2]);
		 }
	@Test
	public void testM4() throws InterruptedException,IllegalMonitorStateException {
		tp1.clickBatton(tp1.login);
		 expectedRes = driver.getTitle();
		 result1[3] = tp1.testResults(expectedRes,"Redmine");
		 assertTrue(result1[3]);
		 }
	@Test
	public void testM5() throws InterruptedException,IllegalMonitorStateException {
		tp1.clickBatton(tp1.register);
		 expectedRes = driver.getTitle();
		 result1[4] = tp1.testResults(expectedRes,"Redmine");
		 assertTrue(result1[4]);
		 }
	@AfterTest 
	public void checkAndWritte() { 
		 for(int i=0;i< result1.length;i++) {
			 if( result1[i]==false) {
				 fullResult=false;
				 break;
			 }
		 }
		 
		 
 	    cr.fileWritter(fullResult, "result_test1", "1");
 	   driver.close();
	
 	 
  }
	
		 

		
		
	}
	

