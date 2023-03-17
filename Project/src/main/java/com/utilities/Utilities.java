package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	// Reading from excel sheet.
	public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
	String inputData = "C:\\Users\\LENOVO\\Documents\\Sheet1.xlsx";
	file = new FileInputStream(inputData );
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	try {
	book = WorkbookFactory.create(file);
	}catch (InvalidFormatException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	} 
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
	for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	}
	}
	return data;
	}

public String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
// after execution, you could see a folder "FailedTestsScreenshots"
// under src folder
String destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName
+ ".png";
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
return destination;
}
}

