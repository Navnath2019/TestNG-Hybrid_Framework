package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class CommonActions extends Base {

	// Linking Properties 
	//******************************************************************************************************************************************
	// Mouse Hover
	public void mouseHover(String locatorKey) {

		// Connect with locators.properties for mouse hover
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(locators.getProperty(locatorKey)))).build().perform();	
	}
	//******************************************************************************************************************************************

	// Click 
	public void click(String locatorKey) {

		driver.findElement(By.xpath(locators.getProperty(locatorKey))).click();
	}
	//******************************************************************************************************************************************

	//Enter testData 
	public void enterData(String locatorKey , String TestData) {

		driver.findElement(By.xpath(locators.getProperty(locatorKey))).sendKeys(testData.getProperty(TestData));
	}

	//******************************************************************************************************************************************
	//get Text 
	public void getText(String locatorKey) {

		String getText = driver.findElement(By.xpath(locators.getProperty(locatorKey))).getText();
		System.out.println(getText);

	}
	//******************************************************************************************************************************************

	// Click List of Web Elements
	public void clickListElement (String locatorKey, String testdata) {

		List<WebElement> listOfElements = driver.findElements(By.xpath(locators.getProperty(locatorKey)));

		for (int i = 0; i < listOfElements.size(); i++) {
			if (listOfElements.get(i).getText().equalsIgnoreCase (locators.getProperty(testdata))) 
			{ listOfElements.get(i).click();}
		}
	}
	//******************************************************************************************************************************************
	
	// Reading Excel Data	
	public void readExcelSheetData (String locatorKey, int row, int column) throws Exception {
		File src= new File(".\\src\\com.facebook.resources\\Excel Test Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Sheet1");
		System.out.println(sh.getSheetName());
		String abc = sh.getRow(row).getCell(column).getStringCellValue();
		driver.findElement(By.xpath(locators.getProperty(locatorKey))).sendKeys(abc);
	}

	public void takeScreenshot() throws IOException {

		File f=((TakesScreenshot)driver).getScreenshotAs (OutputType.FILE);
		Files.copy(f,new File("C:\\Users\\nkmin\\eclipse-workspace\\TestNG_HybridFramework\\screenShot"));
	}
	public void winHandle()  {

		
		
}
}
