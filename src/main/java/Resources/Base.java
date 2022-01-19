package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;





public class Base {
	public static  WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Prashant\\eclipse-workspace\\ComAssessment\\src\\main\\java\\Resources\\Data.properties");
		
		prop.load (fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			//execute in chrome driver
			
			System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else if (browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver","Driver\\msedgedriver.exe");
		    driver = new EdgeDriver();
			driver.manage().window().maximize();
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	public void getScreenshot_success(String result) throws IOException
	{
		File src =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src , new File("screenshot\\success"+result+"screenshot.png"));
	}
	public void getScreenshot_failure(String result) throws IOException
	{
		File src =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src , new File("screenshot\\failure"+result+"screenshot.png"));
	}
}
