package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class E_Featured {

	public WebDriver driver;
	
	By IndianExpress = By.xpath("//img[@width='44%']");
	By Headline=By.id("content_head");
	public E_Featured(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement IndianExpress()
	{
		return driver.findElement(IndianExpress);
	}
	
	public WebElement HeadLine()
	{
		return driver.findElement(Headline);
	}
	
	
	
	
	
	 
}
