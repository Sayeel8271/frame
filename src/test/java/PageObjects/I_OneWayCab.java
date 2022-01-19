package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class I_OneWayCab {

	public WebDriver driver;
	By Cabs=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/app-footer/footer/div[1]/div[2]/ul/li[3]/a");
	By clickCity=By.xpath("//*[@id=\"tabAhmedabad\"]");
	By location=By.xpath("//*[@id=\"west-0\"]/div/a[1]/div[1]");
	
	By Signin= By.xpath("//*[@id=\"sv_header\"]/div/div[3]/div/a[3]/span");
	/*By Timeselection=By.xpath("//*[@id=\"pickUpTime\"]/option[8]");
	By Date =By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[1]/div/p-calendar[1]/span/input");
	
	By selectDate=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[1]/div/p-calendar[1]/span/div/div/div/div[2]/table/tbody/tr[5]/td[7]/span");
	*/public I_OneWayCab(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}
    

	
	public WebElement OneWayCabText()
	{
		return driver.findElement(Cabs);
		
	}
	public WebElement clickCity()
	{
		return driver.findElement(clickCity);
		
	}
	public WebElement location()
	{
		return driver.findElement(location);
		
	}
	
	/*public WebElement Date()
	{
		return driver.findElement(Date);
		
	}
	public WebElement SelectDate()
	{
		return driver.findElement(selectDate);
		
	}
	public WebElement PickupTime()
	{
		return driver.findElement(Time);
		
	}*/
	public WebElement Signin()
	{
		return driver.findElement(Signin);
		
	}
	
	
}
