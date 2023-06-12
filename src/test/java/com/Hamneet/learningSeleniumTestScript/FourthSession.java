package com.Hamneet.learningSeleniumTestScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FourthSession {
	WebDriver wd;
	Actions action;
	WebDriverWait wait;
	
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	wd = new ChromeDriver();
	wait = new WebDriverWait(wd, 0);
	action = new Actions(wd);
	wd.get("https://demoqa.com/buttons");
	wd.manage().window().maximize();
}

@Test
public void validateRegularClick() {
//WebElement clkBtn=wd.findElement(By.xpath("//button[text()='Click Me']"));
//clkBtn.click();//why this click is working  but  when i am doing using action.click(clkBtn) is not working.
//action.click(clkBtn);
//Assert.assertEquals(clkBtn.getText(), "You have done a dynamic click","this is not correct one:");
//Assert.assertTrue(false);

WebElement clickable=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));
action.click(clickable).perform();
WebElement dynamicClickMessage= wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dynamicClickMessage"))); 
Assert.assertEquals(dynamicClickMessage.getText(),"You have done a dynamic click");	
}

@Test
public void validateRightClick() {
	WebElement rigntClickbtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#rightClickBtn")));
	action.contextClick(rigntClickbtn).perform();
	WebElement dynamicClickMessage= wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#rightClickMessage"))); 
	Assert.assertEquals(dynamicClickMessage.getText(),"You have done a right click");
}
@Test 
public void doubleClick() {
	WebElement doubleClickbtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#doubleClickBtn")));
     action.doubleClick( doubleClickbtn).perform();
     WebElement doubleClick=  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("doubleClickMessage")));
     Assert.assertEquals(doubleClick.getText(), "You have done a double click");
}
@AfterTest
public void tearDown() {
	
}
}
