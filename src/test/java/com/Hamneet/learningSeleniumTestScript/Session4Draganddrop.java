//package com.Hamneet.learningSeleniumTestScript;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class Session4Draganddrop {
//	WebDriver wd;
//	Actions action;
//	WebDriverWait wait;
//	
//@BeforeMethod
//public void setup() {
//	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
//	wd = new ChromeDriver();
//	wait = new WebDriverWait(wd, 0);
//	action = new Actions(wd);
//	wd.get("https://demoqa.com/droppable");
//	wd.manage().window().maximize();
//}
//@Test
//public void validateDragAndDrop() {
//	//wd.navigate().to("");
//WebElement dragSource=	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#draggablel")));
//WebElement dragTarget=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#droppable")));
//action.dragAndDrop(dragSource, dragTarget).perform();
//Assert.assertEquals(dragTarget.getText(),"Dropped!","this is not a correcrt way");
//}
//
//@Test 
//public void validateTooltip() {
//	wd.navigate().to("https://demoqa.com/tool-tips");
//	WebElement mouseHovertooltip=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#toolTipButton")));
//	action.moveToElement(mouseHovertooltip);
//	String addedAttribute =	mouseHovertooltip.getAttribute("aria-describedby");	
//	Assert.assertEquals(addedAttribute, "buttonToolTip","didnot match the attribute:");
//}
//@Test
//public void validateAlerts() {
//	wd.navigate().to("https://demoqa.com/alerts");
//WebElement simpeAlert=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#alertButton")));
//simpeAlert.click();
//wd.switchTo().alert().accept();
//}
//}
