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


import PageObjects.H_Blogging;
import PageObjects.F_ContactUs;
import Resources.Base;


public class F_ContactUsHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void ContactUsTab()  throws IOException, InterruptedException
	{
		 Logger log = LogManager.getLogger(F_ContactUsHomepg.class);
			
			PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		F_ContactUs Cu = new F_ContactUs(driver);
		Cu.contact().click();
		log.info("Clicking on the contact us tab ");
	    
		
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		log.info("Navigating to other window using window handling method");
		System.out.println(Cu.info().getText());
		log.info("Getting all the information about contact details");
		
		
	}
		@AfterTest
		public void  teardown()
		{
			driver.quit();
			driver = null;
			
		}	
	}
