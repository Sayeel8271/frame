package Prashant;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.E_Featured;
import PageObjects.A_Signin;
import Resources.Base;


public class E_FeaturedHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void FeaturedTab()  throws IOException
	{
		 Logger log = LogManager.getLogger(E_FeaturedHomepg.class);
			
	    PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		E_Featured F = new E_Featured(driver);
		F.IndianExpress().click();
		log.info("cliking on the indian express ");
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		log.info("Navigating to other window using window handle");
		
		System.out.println(F.HeadLine().getText());
		log.info("Printing the Headline of indian express");
		Assert.assertEquals(F.HeadLine().getText(), "Rent a car to avoid risk of COVID-19 is what office goers seem to prefer");
	}
		@AfterTest
		public void  teardown()
		{
			driver.quit();
			driver = null;
		}	
	}
