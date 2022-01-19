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

import PageObjects.D_AirpotTab;

import Resources.Base;

public class D_AirpotTabHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void AirpotTab()  throws IOException, InterruptedException
	{
		 Logger log = LogManager.getLogger(D_AirpotTabHomepg.class);
			
			PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		D_AirpotTab At = new D_AirpotTab(driver);
		FileInputStream fileinput=null;
		File search = new File("excelsheet\\Book2.xlsx");
		log.info("Reading the data from the excel sheet");
		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		String city = sheet1.getRow(2).getCell(4).getStringCellValue();
		String Trip = sheet1.getRow(3).getCell(4).getStringCellValue();
		String Name = sheet1.getRow(4).getCell(4).getStringCellValue();
		String Email = sheet1.getRow(5).getCell(4).getStringCellValue();
		
		At.AirpotTab().click();
		log.info("clicking on the airpot tab");
		At.CityTab().sendKeys(city);
		log.info("sending the city name using excel sheet");
		Thread.sleep(2000);
		At.CityTab().sendKeys(Keys.ARROW_DOWN);
		At.CityTab().sendKeys(Keys.ARROW_DOWN);
		At.CityTab().sendKeys(Keys.ARROW_DOWN);
		log.info("selecting the city for booking using Arrow Down key");
		At.CityTab().sendKeys(Keys.ENTER);
		
		At.Trip().click();
		log.info("selecting the trip info for booking");
		At.Trip().sendKeys(Keys.ARROW_DOWN);
		At.Trip().sendKeys(Keys.ENTER);
		
		At.dropAddress().sendKeys(Trip);
		log.info("Reading the drop address details from the excel sheet");
		Thread.sleep(2000);
		At.dropAddress().sendKeys(Keys.ARROW_DOWN);
		At.dropAddress().sendKeys(Keys.ARROW_DOWN);
		At.dropAddress().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		At.Calender().click();
		log.info("clicking on the calender to select the date");
		Thread.sleep(2000);
		At.Time().click();
		log.info("clicking on the time tab to select the time");
		At.SelectCar().click();
		
		System.out.println(At.carText().getText());
		At.carSelect().click();
		Assert.assertEquals(At.carverify().getText(),"Toyota Etios or Equivalent");
		log.info("Verifying the car with the name");
		System.out.println(At.carverify().getText());
		
		At.Name().sendKeys(Name);
		At.Email().sendKeys(Email);
		At.Mobile().sendKeys("1239654780");
		log.info("filling the details for booking");
		At.pickupterminal().click();
		Thread.sleep(2000);
		At.pickupterminal().sendKeys(Keys.ARROW_DOWN);
		At.pickupterminal().sendKeys(Keys.ARROW_DOWN);
		At.pickupterminal().sendKeys(Keys.ENTER);
		At.proceed().click();
		log.error("selecting the proceed detail with wrong mobile number format");
	}
		@AfterTest
		public void  teardown()
		{
			driver.close();
			driver.quit();
			driver = null;
		}
	}
