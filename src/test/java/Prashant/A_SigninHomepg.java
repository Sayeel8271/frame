package Prashant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import PageObjects.A_Signin;
import Resources.Base;

public class A_SigninHomepg extends Base {    //inheritating all the methods from base class
	
	 
	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void SigninHomepg()  throws IOException
	{
		Logger log = LogManager.getLogger(A_SigninHomepg.class);
		
		PropertyConfigurator.configure("log4j.properties");
	    
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		A_Signin s = new A_Signin(driver);
		FileInputStream fileinput=null;
		File search = new File("excelsheet\\Book2.xlsx");
		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		String email = sheet1.getRow(1).getCell(1).getStringCellValue();
		String Password = sheet1.getRow(2).getCell(1).getStringCellValue();
		
		
		s.ClickForsignin().click();
		log.info("click on the sign in tab");
		s.Email().sendKeys(email);
		log.info("click on the email and fill the email id");
		s.Password().sendKeys(Password);
		log.info("click on the Password and fill the password");
		s.ToLogin().click();
		log.info("successfully clicked on the login button");
		System.out.println(s.Toverify().isDisplayed());
		System.out.println(s.Toverify().getText());
		log.warn("Log in error message is displayed");
	}
		@AfterTest
		public void  teardown()
		{
			driver.quit();
			driver = null;
		}	
	}
