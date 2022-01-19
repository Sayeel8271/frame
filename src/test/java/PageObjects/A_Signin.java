package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A_Signin {
	  
      
	  
    

	public WebDriver driver;
	
	By signinclick = By.xpath("//*[@id=\"sv_header\"]/div/div[3]/div/a[3]/div");
	By username=By.xpath("//*[@id=\"approot\"]/app-navbar/div[2]/div/div[2]/form/input[1]");
	By Password=By.xpath("//*[@id=\"approot\"]/app-navbar/div[2]/div/div[2]/form/input[2]");
	By Login=By.xpath("//*[@id=\"approot\"]/app-navbar/div[2]/div/div[2]/form/div[2]/button[1]");
	By errormesssageprint=By.xpath("//*[@id=\"approot\"]/app-navbar/div[2]/div/div[2]/form/div[3]/div");
	
	
	public A_Signin(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement ClickForsignin()
	{
		return driver.findElement(signinclick);
	}
	
	public WebElement Email()
	{
		return driver.findElement(username);
	}
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	
	public WebElement ToLogin()
	{
		return driver.findElement(Login);
	}
	public WebElement Toverify()
	{
		return driver.findElement(errormesssageprint);
	}
	
	
	
	 
}
