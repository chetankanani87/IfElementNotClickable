package elementNotClickable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import lib.BrowserDriverUtility;
import lib.ExtentReportUtility;
import lib.ScreenshotUtility;


public class ElementNotClickable {
	WebDriver dr = BrowserDriverUtility.InvokeBrowser("webdriver.chrome.driver",
			"C:\\Chetan\\SeleniumSuite\\WebDrivers\\chromedriver.exe",
			"http://login.yahoo.com");
	ExtentReports report = ExtentReportUtility.InvokeExtentReport();;
	ExtentTest logger = report.createTest("Mouse Hover Action");
	String path;
	
	@BeforeTest
	public void InvokeBrowser() {
		try {
			path = ScreenshotUtility.CaptureScreenshot(dr, "1_MainPage");
			logger.pass("Main Page - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void MouseHover() {
		try {
			
			//Method-1
			WebElement ele = dr.findElement(By.id("persistent"));
			((JavascriptExecutor)dr).executeScript("arguments[0].click();", ele);
			
			//Method-2
			//Actions act = new Actions (dr);
			//act.moveToElement(dr.findElement(By.id("persistent"))).click().build().perform();
			
			path = ScreenshotUtility.CaptureScreenshot(dr, "2_ClickedOnCheckbox");
			logger.pass("Clicked on 'Stay signed in' checkbox - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown() {
		report.flush();
		dr.close();
	}
}
