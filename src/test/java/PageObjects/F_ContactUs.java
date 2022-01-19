package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class F_ContactUs {

	public WebDriver driver;
	
	By contact = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/app-footer/footer/div[1]/div[3]/ul/li[1]/a");
    By info=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]");
	
	
	public F_ContactUs(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement contact()
	{
		return driver.findElement(contact);
	}
	public WebElement info()
	{
		return driver.findElement(info);
	}
	
	
	
	
	
	 
}
