package com.Hamneet.learningSeleniumTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumAssignment {
	WebDriver wd;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wait = new WebDriverWait(wd, 10);
		wd.manage().window().maximize();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=24");
	}

	@Test(priority = 1)
	public void validateRegisterUser() {
		WebElement accountBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"My Account\"]")));
		accountBtn.click();
		WebElement registerBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Register\"]")));
		registerBtn.click();
		WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-firstname")));
		firstName.sendKeys("Hamneet");
		WebElement lastName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-lastname")));
		lastName.sendKeys("Kaur");
		WebElement emailID = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));
		emailID.sendKeys("mummy@gmail.com");
		WebElement telephonenumber = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-telephone")));
		telephonenumber.sendKeys("123456789");
		WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
		password.sendKeys("Hamn@@@12");
		WebElement confirmPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-confirm")));
		confirmPassword.sendKeys("Hamn@@@12");
		WebElement subscribe = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name=\"newsletter\"])[1]")));
		subscribe.click();
		WebElement policyClick = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"agree\"]")));
		policyClick.click();
		WebElement continueBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Continue\"]")));
		continueBtn.click();
		WebElement signupMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
		Assert.assertEquals(signupMessage.getText(), "Your Account Has Been Created!",
				"you have already account login please!");
	}

	@Test(priority = 2)
	public void validateLogin() {
		WebElement accountBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"My Account\"]")));
		accountBtn.click();
		WebElement loginBtn = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("li.dropdown ul.dropdown-menu li:nth-of-type(2)>a")));
		loginBtn.click();
		WebElement loginEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));
		loginEmail.sendKeys("h11@gmail.com");
		WebElement loginPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
		loginPassword.sendKeys("12345");
		WebElement continueButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Login\"]")));
		continueButton.click();
		Assert.assertEquals(wd.getTitle(), "My Account", "You are not abe to login please check credentials");
	}

	@Test(priority = 3)
	public void validateChangePassword() {
		// Login user
		WebElement accountBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"My Account\"]")));
		accountBtn.click();
		WebElement loginBtn = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("li.dropdown ul.dropdown-menu li:nth-of-type(2)>a")));
		loginBtn.click();
		WebElement loginEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));
		loginEmail.sendKeys("h11@gmail.com");
		WebElement loginPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
		loginPassword.sendKeys("12345");
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Login\"]")));
		loginButton.click();
		Assert.assertEquals(wd.getTitle(), "My Account", "You are not abe to login please check credentials");
		// changePaasword
		WebElement changePasswordLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Change your password\"]")));
		changePasswordLink.click();
		WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
		password.sendKeys("12345");
		WebElement confirmPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-confirm")));
		confirmPassword.sendKeys("12345");
		WebElement changePasswordBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Continue\"]")));
		changePasswordBtn.click();
		WebElement changePasswordMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[text()=\" Success: Your password has been successfully updated.\"]")));
		Assert.assertEquals(changePasswordMessage.getText(), "Success: Your password has been successfully updated.");
		WebElement accountBtnforLogout = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"My Account\"]")));
		accountBtnforLogout.click();
		WebElement logout = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.dropdown-menu>li:nth-of-type(5)>a")));
		logout.click();
		Assert.assertEquals(wd.getTitle(), "Account Logout");// logout Account
		// login again after changing password
		WebElement accountBtn1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"My Account\"]")));
		accountBtn1.click();
		WebElement loginBtn1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("li.dropdown ul.dropdown-menu li:nth-of-type(2)>a")));
		loginBtn1.click();
		WebElement loginEmail1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));
		loginEmail1.sendKeys("h11@gmail.com");
		WebElement loginPassword1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-password")));
		loginPassword1.sendKeys("12345");
		WebElement continueButton1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Login\"]")));
		continueButton1.click();
		Assert.assertEquals(wd.getTitle(), "My Account", "You are not abe to login please check credentials");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
