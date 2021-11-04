package go.go.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import static org.testng.Assert.assertTrue;

public class Test2 {
	WebDriver driver;
	ValidateLinks tp1;
	CheckFields tp2;
	boolean[] result = new boolean[5];
	String[] inputNames = {"Пользователь","Пароль","Имя","Фамилия","Email"};

	@BeforeTest
	public void  setup() {
		System.setProperty("webdriver.chrome.driver","..\\go\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		tp2 = new CheckFields(driver);
		assertTrue(tp2.header.isDisplayed());
	} 
	
	
	@Test
	public void testM1(){
		tp2.setData(tp2.login, tp2.regData1.get(0));
		tp2.takeScreenShots("screen1");
		result[0] = tp2.Perevirka(inputNames[0]);
		assertTrue(result[0] );
	}

	@Test
	public void testM2()  {
	tp2.setData1(tp2.password, tp2.regData1.get(1));
		tp2.takeScreenShots("screen2");
		
	}
	
	@Test
	public void testM3()  {
		tp2.setData(tp2.confirmation, tp2.regData1.get(2));
		tp2.takeScreenShots("screen3");
		result[1] = tp2.Perevirka(inputNames[1]);
		assertTrue(result[1]);
	}
	
		@Test
	public void testM4() {
			tp2.setData(tp2.firstname, tp2.regData1.get(3));
		tp2.takeScreenShots("screen4");
		result[2] = tp2.Perevirka(inputNames[2]);
		assertTrue(result[2]);
	}
		
	@Test
	public void testM5()  {
		tp2.setData(tp2.lastname, tp2.regData1.get(4));
		tp2.takeScreenShots("screen5");
		result[3] = tp2.Perevirka(inputNames[3]);
		assertTrue(result[3]);
	}
	@Test
	public void testM6() {
		tp2.setData(tp2.mail, tp2.regData1.get(5));
		tp2.takeScreenShots("screen6");
		result[4] = tp2.Perevirka(inputNames[4]);
		assertTrue(result[4]);
	}
	@Test
	public void testM7()  {
		tp2.setData(tp2.custom, tp2.regData1.get(6));
		tp2.takeScreenShots("screen7");
		
	}
	@AfterTest
	public void writeRes()  {
		tp2.saveResults (result,inputNames);
		driver.close();
	}
	

}
