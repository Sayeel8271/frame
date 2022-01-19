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
import Resources.Base;


public class H_BloggingHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void Blogging_icon()  throws IOException, InterruptedException
	{
		 Logger log = LogManager.getLogger(H_BloggingHomepg.class);
			
			PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		H_Blogging B = new H_Blogging(driver);
		B.IconClick().click();
		log.info("clicking on the blogging icon");
	    Thread.sleep(5000);
		
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		log.info("Navigating the other window using window handling tab");
		
		B.TravelTab().click();
		log.info("clicking on the Travel Tab");
		System.out.println(B.TravelTab().getText());
		B.City().click();
	    System.out.println(B.City().getText());
		System.out.println(B.CityTitle().getText());
		log.info("clicking on the city and geeting the information about that city");
	}
		@AfterTest
		public void  teardown()
		{
			driver.quit();
			driver = null;
			
		}	
	}
