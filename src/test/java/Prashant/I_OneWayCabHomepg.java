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


import PageObjects.I_OneWayCab;
import Resources.Base;


public class I_OneWayCabHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void OneWayCabTab()  throws IOException, InterruptedException
	{
		 Logger log = LogManager.getLogger(I_OneWayCabHomepg.class);
			
			PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		I_OneWayCab Oc = new I_OneWayCab(driver);
		Oc.OneWayCabText().click();
		log.info("clicking on OneWayCabTextTab");
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		System.out.println(driver.getTitle());
		
		Oc.clickCity().click();
		log.info("clicking on the city name that you want to select");
		Oc.location().click();
		System.out.println(Oc.location().getText());
		
		Set<String> ids1=driver.getWindowHandles();
		Iterator<String>it1=ids1.iterator();
		it1.next();
		it1.next();
		String Childid1=it1.next();
		driver.switchTo().window(Childid1);
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		
		Oc.Signin().click();
		log.info("click on the signin tab on the third window using two times window handling method");
		System.out.println(Oc.Signin().getText());
	}   
		@AfterTest
		public void  teardown()
		{
			driver.close();
			driver.quit();
			driver = null;
		}	
	}
