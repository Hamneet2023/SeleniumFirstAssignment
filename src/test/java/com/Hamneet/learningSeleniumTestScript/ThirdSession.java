package com.Hamneet.learningSeleniumTestScript;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ThirdSession {
WebDriver wd;
WebDriverWait wait;
@BeforeMethod
public void setup() {
	//telling computer where is the chrome driver:
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	// Intialize Instance of WebDriver Interface.
	// This line opens an instance of the browser
	wd = new ChromeDriver(); 
	wait = new WebDriverWait(wd, 10);
	wd.manage().window().maximize();	
	wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
@Test
public void loginFunctionality() {
   
	WebElement contactUS = wd.findElement(By.xpath("//a[text()=\"Contact Us\"]"));
    contactUS.click();
	WebElement name=wd.findElement(By.cssSelector("input[id^='input-n']"));
	WebElement email=wd.findElement(By.cssSelector("input[id^='input-e']"));
	WebElement enquiry=wd.findElement(By.cssSelector("textarea[id^='input-e']"));
    WebElement submit=wd.findElement(By.cssSelector("input[value=\"Submit\"]"));

   name.sendKeys("Hamneet Kaur");
   email.sendKeys("hamneet@gmail.com");
   enquiry.sendKeys("I just want check this  text is going or not in the enquiery text field");
   enquiry.clear();
   enquiry.sendKeys("after clear identify:text");
   submit.click();	
   WebElement enquiryMessage= wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//p[text()=\"Your enquiry has been successfully sent to the store owner!\"]"))));
  // WebElement enquiryMessage =wd.findElement(By.xpath("//p[text()=\"Your enquiry has been successfully sent to the store owner!\"]"));
   Assert.assertEquals(enquiryMessage.getText(),"Your enquiry has been successfully sent to the store owner!","this not is right page");
   
}
}
