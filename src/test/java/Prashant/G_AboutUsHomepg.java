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

import PageObjects.G_AboutUs;

import Resources.Base;


public class G_AboutUsHomepg extends Base{       //inheritating all the methods from base class
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void AboutUsTab()  throws IOException
	{
		 Logger log = LogManager.getLogger(G_AboutUsHomepg.class);
			
			PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		G_AboutUs Au = new G_AboutUs(driver);
		Au.Aboutus().click();
		log.info("Clicking on the about us tab");
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		System.out.println(Au.AboutusText().getText());
		
		System.out.println("The CEO of the savaari.com is = "+Au.CEOName().getText());
		log.info("Printing the name of the CEO of savaari.com");
		Assert.assertEquals(Au.CEOName().getText(), "Gaurav Aggarwal");
	}
		@AfterTest
		public void  teardown()
		{
			driver.quit();
			driver = null;
			
		}	
	}
