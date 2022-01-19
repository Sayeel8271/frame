package Prashant;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import PageObjects.J_CarRental;
import Resources.Base;


public class J_CarRentalHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void CarRental()  throws IOException, InterruptedException
	{
		 Logger log = LogManager.getLogger(J_CarRentalHomepg.class);
			
			PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		J_CarRental Cr = new J_CarRental(driver);
		Cr.ClickForCity().click();
		log.info("click on the city on car rental section");
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		System.out.println(driver.getTitle());
		
		Cr.ClickForText().getText();
		log.info("getting the text after clicking on the city");
		System.out.println(Cr.ClickForText().getText());
	}   
		@AfterTest
		public void  teardown()
		{
			driver.close();
			driver = null;
		}	
	}
