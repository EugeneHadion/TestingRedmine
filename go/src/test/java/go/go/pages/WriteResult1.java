package go.go.pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;




public class WriteResult1 {

	public void fileWritter(boolean TestIsTrue,String filename, String testNum) {
		String filename1 = "..\\go\\driver\\"+filename+".xlsx";  
		String result = "";
		Workbook workbook = new XSSFWorkbook();
		Sheet newSheet = workbook.createSheet("results");
		Row row = newSheet.createRow(0);
		if(TestIsTrue==true) {
			result += "Test "+testNum+" finished without errors!";
			row.createCell(0).setCellValue(result);
		}else {
			result += "Test "+testNum+" finished with errors!";
			row.createCell(0).setCellValue(result);
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

	}}