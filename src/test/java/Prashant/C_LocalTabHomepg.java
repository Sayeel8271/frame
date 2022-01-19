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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.C_LocalTab;

import Resources.Base;


public class C_LocalTabHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void LocalTab()  throws IOException, InterruptedException
	{
		 Logger log = LogManager.getLogger(C_LocalTabHomepg.class);
			
			PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		C_LocalTab lt = new C_LocalTab(driver);
		
		FileInputStream fileinput=null;
		File search = new File("excelsheet\\Book2.xlsx");
		 log.info("Reading the data from the excel sheet");
		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		String city = sheet1.getRow(10).getCell(1).getStringCellValue();
		String NameForVerify = sheet1.getRow(11).getCell(1).getStringCellValue();
		
		lt.local().click();
		log.info("cliking on the local tab");
		lt.localcity().sendKeys(city);
		log.info("sending the city name using excel sheet");
		lt.ClickForcity().click();
		
		/*lt.ClickForDate().click();
		lt.Date().click();
		Thread.sleep(5000);*/
		
		lt.Time().click();
		log.info("selecting the timing for booking");
		lt.Time().sendKeys(Keys.ARROW_DOWN);
		lt.Time().sendKeys(Keys.ARROW_DOWN);
		lt.Time().sendKeys(Keys.ARROW_DOWN);
		lt.Time().sendKeys(Keys.ARROW_DOWN);
		lt.Time().sendKeys(Keys.ARROW_DOWN);
		log.info("selecting the timing for booking using Arrow Down key");
		lt.Time().sendKeys(Keys.ENTER);
		//lt.SelectTime().click();*/
		
		
		lt.SelectCar().click();
		log.info("selecting the car as per requirement");
		System.out.println(lt.CarNamedisplay().getText());
		log.info("Displaying the car name into console");
		lt.CarName().click();
		Assert.assertEquals(lt.CarVerify().getText(),NameForVerify);
		log.info("Verifying the name of the car");
		System.out.println(lt.CarVerify().getText());
	}
		@AfterTest
		public void  teardown()
		{
			driver.quit();
			driver = null;
		}	
	}
