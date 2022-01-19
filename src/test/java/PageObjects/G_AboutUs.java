package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class G_AboutUs {

	public WebDriver driver;
	
	By aboutus = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/app-footer/footer/div[1]/div[1]/ul/li[1]/a");
	By aboutusText=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-about-us/div[3]/div/div[2]");
	By ceoname=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-about-us/div[3]/div/div[3]");
	
	
	public G_AboutUs(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement Aboutus()
	{
		return driver.findElement(aboutus);
	}
	public WebElement AboutusText()
	{
		return driver.findElement(aboutusText);
	}
	public WebElement CEOName()
	{
		return driver.findElement(ceoname);
	}
	
	
	
	
	 
}
