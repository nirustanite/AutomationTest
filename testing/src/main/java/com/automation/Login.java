package com.automation;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.Common;
import com.utils.ExtentReports.ExtentTestManager;

public class Login extends Common{

	public static void CreateAnAccount()
	{
		Common.LoadDriver();
	    Common.openUrl();
	    if(Common.isElementPresent(Common.read("CheckLogo")))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"The website is loaded properly");
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.FAIL,"The website is not loaded properly");
	    }
	    
	    
	}
	
}
