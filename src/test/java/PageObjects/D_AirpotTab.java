package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class D_AirpotTab {

	public WebDriver driver;
	
	By selectAirpot = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[1]/div[3]/a/span");
	By cityTab=By.id("fromCityList");
	
	
	By triptab=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[2]/div/select");
	By dropAddress=By.id("search_places");
	By calender=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[4]/div[1]/div/p-calendar[1]/span");
	By Time=By.xpath("//*[@id=\"pickUpTime\"]/option[9]");
	By SelectCar=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[5]/div/button");
	By carText=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div[1]/span");
	By carSelect=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[1]/div/div[4]/div/button");
	By carverify=By.xpath("//*[@id=\"static-1\"]/div/div/div[4]/div[2]/div");
	
	By Name=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-booking/div[2]/app-booking-pickup-detail/div/div[2]/form/div[1]/div/input");
	By email=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-booking/div[2]/app-booking-pickup-detail/div/div[2]/form/div[2]/input");
	By Mobile=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-booking/div[2]/app-booking-pickup-detail/div/div[2]/form/div[3]/div/input");
	By pickupterminal=By.xpath("//*[@id=\"idTerminal\"]");
	By proceed =By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-booking/div[2]/app-booking-pickup-detail/div/div[2]/form/button/div");
	public D_AirpotTab(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement AirpotTab()
	{
		return driver.findElement(selectAirpot);
	}
	public WebElement CityTab()
	{
		return driver.findElement(cityTab);
	}
	public WebElement Trip()
	{
		return driver.findElement(triptab);
	}
	public WebElement dropAddress()
	{
		return driver.findElement(dropAddress);
	}
	
	public WebElement Calender()
	{
		return driver.findElement(calender);
	}
	public WebElement Time()
	{
		return driver.findElement(Time);
	}
	public WebElement SelectCar()
	{
		return driver.findElement(SelectCar);
	}
	public WebElement carText()
	{
		return driver.findElement(carText);
	}
	public WebElement carSelect()
	{
		return driver.findElement(carSelect);
	}
	public WebElement carverify()
	{
		return driver.findElement(carverify);
	}
	public WebElement Name()
	{
		return driver.findElement(Name);
	}
	public WebElement Email()
	{
		return driver.findElement(email);
	}
	public WebElement Mobile()
	{
		return driver.findElement(Mobile);
	}
	public WebElement pickupterminal()
	{
		return driver.findElement(pickupterminal);
	}
	public WebElement proceed()
	{
		return driver.findElement(proceed);
	}
	 
}
