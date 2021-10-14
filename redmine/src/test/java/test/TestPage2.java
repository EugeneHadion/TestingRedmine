package test;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.String;
import java.util.ArrayList;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
public class TestPage2  {
	
	private WebDriver driver;
	
	String url = "https://www.redmine.org/account/register";
	@FindBy(css="[name=\"user[login]\"]")
	WebElement login;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(id="user_password_confirmation")
	WebElement confirmation;
	
	@FindBy(id="user_firstname")
	WebElement firstname;
	
	@FindBy(css="[name*=last]")
	WebElement lastname;
	
	@FindBy(css="[name*=mail]")
	WebElement mail;
	
	@FindBy(css="[name*=custom]")
	WebElement custom;
	
	@FindBy(css="[name=\"commit\"]")
	WebElement send;
	
	@FindBy(id="errorExplanation")
	WebElement errorExplanation;
	
	public TestPage2 (WebDriver driver){
		 this.driver=driver;
		 driver.get(url);
		 PageFactory.initElements(driver, this);
	}
	
	ArrayList<String> regData1 = regData("1");
	ArrayList<String> regData2 = regData("2");
	ArrayList<String> regData3 = regData("3");
	ArrayList<String> regData4 = regData("4");
	

	
	public void setLogin() {
		login.sendKeys( regData1.get(0) ,Keys.ENTER);
		
	}
	
	public void setPassword() {
		password.sendKeys(  regData1.get(1));
	}
	
    public void setPasswordConf() {
		confirmation.sendKeys( regData1.get(2),Keys.ENTER);
	}
	
	public void setFirstname() {
		firstname.sendKeys(  regData1.get(3),Keys.ENTER);
	}
	
	public void setLastname() {
		lastname.sendKeys(  regData1.get(4),Keys.ENTER);
	}
	
	public void setMail() {
		mail.sendKeys(  regData1.get(5),Keys.ENTER);
	}
	
	public void setCustom() {
		custom.sendKeys( regData1.get(6),Keys.ENTER);
	}
	
	public void setAllData(ArrayList<String> regData1) {
		
		login.sendKeys( regData1.get(1));
		password.sendKeys(  regData1.get(2));
		confirmation.sendKeys( regData1.get(2));
		firstname.sendKeys(  regData1.get(3));
		lastname.sendKeys(  regData1.get(4));
		mail.sendKeys(  regData1.get(5));
		custom.sendKeys( regData1.get(6),Keys.ENTER);
	}
	
	
	

	public static ArrayList<String> regData (String ID)  {
		try {
		ArrayList<String> data = new ArrayList<String>();
		Fillo fillo = new Fillo();
		Connection con = fillo.getConnection("..\\redmine\\driver\\registr_data.xlsx");
		String query = "Select * from Sheet1 where ID="+ID;
		Recordset recordset = con.executeQuery(query);
		while(recordset.next()) {
			ArrayList<String> collect =recordset.getFieldNames();
			int size = collect.size();
		
			for(int i =1;i<=(size-1);i++) {
				String colname = collect.get(i);
				String value = recordset.getField(colname);
				data.add(value);
			}
		}
		
		recordset.close();
		con.close();
		return data;
	} catch (FilloException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
			}
	

	public void takeScreenShots(String screenName) {
          try {
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile, new File(".//screenshots/"+screenName+".png"));
          } catch (IOException e) {
      		System.out.println("e");
      	}
}
	public boolean Perevirka(String element) {
		
		boolean result;
		  if(errorExplanation.getText().contains(element)) {
			   result = false;
			  System.out.println("Test finished unsuccessfully");
		  }else {
			  result=true;
			  System.out.println("Test finished successfully");
		  }
		  driver.navigate().back();
		  System.out.println(result);
		  return result;
	  }
//	
	public void saveResults (boolean[] Result, String[] inputNames) {
		String filename1 = "..\\redmine\\driver\\registr_result.xlsx";  
		Workbook workbook = new XSSFWorkbook();
		Sheet newSheet = workbook.createSheet("results");
		for(int i = 0;i<Result.length;i++) {
			Row row = newSheet.createRow(i);
			String result;
			if (Result[i]=true) {
				 result ="pass";
				} else {
				 result ="fail";
				}

			row.createCell(0).setCellValue(inputNames[i]+" = result is "+result);
			}
	
		try {
			 FileOutputStream fileout = new FileOutputStream(new File(filename1));
			 workbook.write(fileout);
			 fileout.close();
			 workbook.close();
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();

		    
	}
		
	}
	 
	

}
