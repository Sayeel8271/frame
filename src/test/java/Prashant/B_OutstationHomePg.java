package Prashant;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.B_OutStationPage;
import Resources.Base;

public class B_OutstationHomePg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	
	@Test
	public void OutstationTab()  throws IOException, InterruptedException
	{
       Logger log = LogManager.getLogger(B_OutstationHomePg.class);
		
		PropertyConfigurator.configure("log4j.properties");
		

		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		B_OutStationPage l = new B_OutStationPage(driver);
		FileInputStream fileInput = null;
		File search = new File("excelsheet\\Book2.xlsx");
        log.info("Reading the data from the excel sheet");
		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String From = sheet.getRow(6).getCell(1).getStringCellValue();
		String To = sheet.getRow(7).getCell(1).getStringCellValue();
		
		l.roundtrip().click();
		log.info("click on the roundtrip radio button");
		l.from().sendKeys(From);
		log.info("sending FROM city detail from excel sheet");
		Thread.sleep(2000);
		l.from().sendKeys(Keys.ARROW_DOWN);
		l.from().sendKeys(Keys.ARROW_DOWN);
		log.info("selecting the city using Arrow Down key");
		l.from().sendKeys(Keys.ENTER);
		log.info("selecting the city to press enter");
		//l.click().click();
		l.Tocity().sendKeys(To);
		log.info("sending TO city detail from excel sheet");
		Thread.sleep(2000);
		l.Tocity().sendKeys(Keys.ARROW_DOWN);
		log.info("selecting the city using Arrow Down key");
		l.Tocity().sendKeys(Keys.ENTER);
		//l.clickTo().click();
		l.returnDate().click();
		log.info("Clicking on the return date tab");
		l.date().click();
		log.info("selecting the date");
		l.selectcar().click();
		log.info("clicking on the select car button ");
		
		
	}
		@AfterTest
		public void  teardown()
		{
			driver.quit();
			driver = null;
		}	
	}
