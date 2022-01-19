package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class H_Blogging {

	public WebDriver driver;
	
	By IconClick = By.className("bg-blog");
	By TravelGuide=By.id("menu-item-10093");	
	By Lonavala=By.xpath("//a[@href='https://blog.savaari.com/lonavala-travel-guide/']");
	By cityTitle=By.className("entry-title");
	
	public H_Blogging(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement IconClick()
	{
		return driver.findElement(IconClick);
	}
	public WebElement TravelTab()
	{
		return driver.findElement(TravelGuide);
	}
	public WebElement City()
	{
		return driver.findElement(Lonavala);
	}
	public WebElement CityTitle()
	{
		return driver.findElement(cityTitle);
	}
	
	
	
	
	 
}
