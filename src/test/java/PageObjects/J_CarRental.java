package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class J_CarRental {

	public WebDriver driver;
	
	By cityName = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/app-footer/footer/div[2]/div[2]/div/a[6]");
	By Text=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[3]/div[2]/div/div[2]/div");
	
	
	public J_CarRental(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement ClickForCity()
	{
		return driver.findElement(cityName);
	}
	
	public WebElement ClickForText()
	{
		return driver.findElement(Text);
	}
	
	
	
	
	
	 
}
