package com.automation;

import com.relevantcodes.extentreports.LogStatus;
import com.utils.Common;
import com.utils.ExtentReports.ExtentTestManager;

public class Login extends Common{

	
	public static void CreateAnAccount()
	{
		 Common.click(Common.read("SignIn"));
		 if(Common.isElementPresent(Common.read("CreateAnAccount")))
		 {
		    	//ExtentTestManager.getTest().log(LogStatus.PASS,"Create An account is present"); 
			 
			 
		 }
		 else
		 {
		    	//ExtentTestManager.getTest().log(LogStatus.PASS,"Create An account is not present");
		    	Common.TakeScreenshotFail();
		 }
	}
	
}
