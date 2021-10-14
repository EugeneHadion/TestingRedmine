package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	TestPage1 tp1;
	boolean result;
	boolean fullResult;
	
	@BeforeTest
	public void  setup() {
		System.setProperty("webdriver.chrome.driver","..\\redmine\\driver\\chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		tp1 = new TestPage1(driver);
		
	}
	
	 String expectedRes;
     boolean[] Result = new boolean[5];
     CheckResult cr = new CheckResult();
     
	@Test
	public void TestM1() throws InterruptedException,IllegalMonitorStateException {
	   	 
		 tp1.clickHome();
		 expectedRes = driver.getTitle();
		 Result[0] = tp1.testResults(expectedRes,"Overview - Redmine");
	}
	@Test
    public void TestM2() throws InterruptedException,IllegalMonitorStateException {
		 
		 tp1.clickProjects();
		 expectedRes = driver.getTitle();
		 Result[1] = tp1.testResults(expectedRes,"Проекты - Redmine");
		 }
	@Test
	public void TestM3() throws InterruptedException,IllegalMonitorStateException {
		 tp1.clickHelp();
		 expectedRes = driver.getTitle();
		 Result[2] = tp1.testResults(expectedRes,"Guide - Redmine");
		 }
	@Test
	public void TestM4() throws InterruptedException,IllegalMonitorStateException {
		 tp1.clickLogin();
		 expectedRes = driver.getTitle();
		 Result[3] = tp1.testResults(expectedRes,"Redmine");
		 }
	@Test
	public void TestM5() throws InterruptedException,IllegalMonitorStateException {
		 tp1.clickRegister();
		 expectedRes = driver.getTitle();
		 Result[4] = tp1.testResults(expectedRes,"Redmine");
		 }
	@AfterTest 
	public void CheckAndWritte() { 
		 for(int i=0;i< Result.length;i++) {
			 if( Result[i]==true) {
				 fullResult=true;
			 }
		 }
		 
		 
 	    cr.fileWritter(fullResult, "result_test1", "1");
 	   driver.close();
	
 	 
  }
	
		 

		
		
	}
	

