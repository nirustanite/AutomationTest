package com.automation;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.Common;
import com.utils.ExtentReports.ExtentTestManager;

public class HomePage extends Common{

	public static void LoadWebsite()
	{
		Common.LoadDriver();
	    Common.openUrl();
	    Common.wait(5);
	    //ExtentTestManager.getTest().setDescription("Testing");
	    if(Common.isElementPresent(Common.read("CheckLogo")))
	    {
	    	System.out.println("Logo is present");
	    	//Common.message();
	    	//ExtentTestManager.getTest().log(LogStatus.PASS,"The website is loaded properly");
	    	//test.log(LogStatus.PASS, "The website is loaded properly");
	    }
	    else
	    {
	    	//ExtentTestManager.getTest().log(LogStatus.FAIL,"The website is not loaded properly");
	    	Common.TakeScreenshotFail();
	    }
	}
	
}
