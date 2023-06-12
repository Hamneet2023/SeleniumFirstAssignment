package com.Hamneet.learningSeleniumTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumAssignment {
	WebDriver wd;
	WebDriverWait wait;
	@BeforeMethod	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();	
		wait= new WebDriverWait(wd, 10);
		wd.manage().window().maximize();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=24");
	}
	@Test
	public void validateSignUp() {
	WebElement accountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"My Account\"]")));
	accountBtn.click();
	WebElement registerBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Register\"]")));
	registerBtn.click();
	WebElement firstName=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-firstname")));
	firstName.sendKeys("Hamneet");
	WebElement lastName=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-lastname")));
	lastName.sendKeys("Kaur");
	WebElement emailID=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));
	emailID.sendKeys("h11@gmail.com");
	WebElement telephonenumber=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-telephone")));
	telephonenumber.sendKeys("123456789");
	WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
	password.sendKeys("Hamn@@@12");
	WebElement confirmPassword=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-confirm")));
	confirmPassword.sendKeys("Hamn@@@12");
	WebElement subscribe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name=\"newsletter\"])[1]")));
	subscribe.click();
	WebElement policyClick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"agree\"]")));
	policyClick.click();
	WebElement continueBtn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Continue\"]")));
	continueBtn.click();
	WebElement signupMessage=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1")));
	System.out.println(signupMessage);
	Assert.assertEquals(signupMessage.getText(), "Your Account Has Been Created!");
	//why its giving register account
	WebElement continueButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()=\"Continue\"]")));
	continueButton.click();
	}
	@Test
	public void validateLogin() {
	wd.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=24");
	WebElement loginBtn =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.dropdown ul.dropdown-menu li:nth-of-type(2)>a")));
	loginBtn.click();
	WebElement loginEmail= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));
	loginEmail.sendKeys("hamneet11@gmail.com");
	WebElement loginPassword=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
	loginPassword.sendKeys("Hamn@@@12");
	WebElement continueButton=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Login\"]")));
	continueButton.click();
	}
	@Test 
	public void validateChangePassword() {
	WebElement changePasswordLink=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Change your password\"]")));
	changePasswordLink.click();
	WebElement password=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
	password.sendKeys("12345");
	WebElement confirmPassword=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-confirm")));
	confirmPassword.sendKeys("12345");
	//WebElement changePasswordMessage=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert>i.fa")));
	//Assert.assertEquals(changePasswordMessage.getText(), " Success: Your password has been successfully updated.");
	WebElement logout=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.dropdown-menu>li:nth-of-type(5)>a")));
	logout.click();
	WebElement logoutMessage=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.buttons div.pull-right>a")));
	Assert.assertEquals(logoutMessage.getText(), "Account Logout");
	WebElement continuebtn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.buttons div.pull-right>a")));
	continuebtn.click();
	//login after change password and logout
	WebElement loginBtn =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.dropdown ul.dropdown-menu li:nth-of-type(2)>a")));
	loginBtn.click();
	WebElement loginEmail= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));
	loginEmail.sendKeys("hamneet1@gmail.com");
	WebElement loginPassword=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
	loginPassword.sendKeys("Hamn@@@12");
	WebElement continueButton=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Login\"]")));
	continueButton.click();	
	
	}
}

