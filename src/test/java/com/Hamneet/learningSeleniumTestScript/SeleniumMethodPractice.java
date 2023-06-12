package com.Hamneet.learningSeleniumTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumMethodPractice {
	WebDriver wd;
@BeforeMethod	
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	wd = new ChromeDriver();
	wd.manage().window().maximize();
	wd.get("https://ca.hotels.com/login?&uurl=e3id%3Dredr%26rurl%3D%2F%3Flocale%3Den_CA%26pos%3DHCOM_CA%26siteid%3D300000002");
	
}
@Test
public void selectBox() {
	WebElement continuebutton=wd.findElement(By.id("loginFormSubmitButton"));
	WebElement email=wd.findElement(By.id("loginFormEmailInput"));
	email.sendKeys("test");
	boolean isButtonEnabled=continuebutton.isEnabled();
	//Assert.assertFalse(isButtonEnabled);//this button is returning false
	Assert.assertTrue(isButtonEnabled);
}
@Test
public void radioButtonSelected() {
}

@AfterMethod
public void tearDown() {
	wd.close();
}
}
