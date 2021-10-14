package test;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test2 {
	WebDriver driver;
	TestPage2 tp2;

	@BeforeTest
	public void  setup() {
		System.setProperty("webdriver.chrome.driver","..\\redmine\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		tp2 = new TestPage2(driver);
	} 
	
	boolean[] Result = new boolean[5];
	String[] inputNames = {"Пользователь","Пароль","Имя","Фамилия","Email"};
	
	
	
	
	@Test
	public void TestM1(){
		tp2.setLogin();
		tp2.takeScreenShots("screen1");
		Result[0] = tp2.Perevirka(inputNames[0]);
	}

	@Test
	public void TestM2()  {
		tp2.setPassword();
		tp2.takeScreenShots("screen2");
		
	}
	
	@Test
	public void TestM3()  {
		tp2.setPasswordConf();
		tp2.takeScreenShots("screen3");
		Result[1] = tp2.Perevirka(inputNames[1]);
	}
	
		@Test
	public void TestM4() {
		tp2.setFirstname();
		tp2.takeScreenShots("screen4");
		Result[2] = tp2.Perevirka(inputNames[2]);
	}
		
	@Test
	public void TestM5()  {
		tp2.setLastname();
		tp2.takeScreenShots("screen5");
		Result[3] = tp2.Perevirka(inputNames[3]);
	}
	@Test
	public void TestM6() {
		tp2.setMail();
		tp2.takeScreenShots("screen6");
		Result[4] = tp2.Perevirka(inputNames[4]);
		
	}
	@Test
	public void TestM7()  {
		tp2.setCustom();
		tp2.takeScreenShots("screen7");
		
	}
	@AfterTest
	public void writeRes()  {
		tp2.saveResults (Result,inputNames);
		
	}
	

}
