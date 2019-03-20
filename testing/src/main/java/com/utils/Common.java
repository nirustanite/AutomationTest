package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.ExtentReports.ExtentTestManager;

public class Common {
	
	public static String value;
	public static WebDriver driver;

	
	// Reading a file function.
	public static String read(String key)
	{
		
		try {
			File file = new File("resources/config.properties");
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
	        prop.load(fileinput);
			fileinput.close();
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	// Loading the driver.
	public static void LoadDriver()
	{
		System.setProperty("webdriver.chrome.driver", read("chromedriverpath"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	public static void openUrl()
	{
		driver.get(Common.read("OpenURL"));
	}
	
	//Verify an Element.
	public static boolean isElementPresent(String xpath)
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	//Scroll to bottom.
	public static void ScrollWindow()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
	}
	
	public static void wait(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Take screenshot if passed.
	public static void TakeScreenshotPass()
	{
		 String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
	                getScreenshotAs(OutputType.BASE64);
	 
	        ExtentTestManager.getTest().log(LogStatus.PASS,"Step passed",
	                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}
	
	//Take screenshot if failed.
	public static void TakeScreenshotFail()
	{
		 String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
	                getScreenshotAs(OutputType.BASE64);
	 
	        ExtentTestManager.getTest().log(LogStatus.FAIL,"Step failed",
	                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}
	
	public static void click(String xpath)
	{
		if(isElementPresent(xpath))
		{
			driver.findElement(By.xpath(xpath)).click();	
		}
		else
		{
			TakeScreenshotFail();
		}
	}
	
}
