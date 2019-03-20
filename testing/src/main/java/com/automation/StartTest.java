package com.automation;
import org.testng.annotations.Test;
import com.utils.Common;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class StartTest extends Common {
	
  @BeforeClass
  public void beforeClass() {
	  
  }
  
  @Test(priority = 1)
  public void CreateAnAccountUsingNegativeValues() {
	  Login.CreateAnAccount();
	  
  }
  
  @Test(priority = 2)
  public void CreateAnAccountUsingPositiveValues() {
	  
  }
  
  @Test(priority = 1)
  public void CheckoutUsingSignIn() {
	  
  }
  
  @Test(priority = 1)
  public void CHeckoutUsingCreateAnAccount() {
	  
  }
  
  @Test(priority = 1)
  public void SignInandCheckout() {
	  
  }
  
  @AfterClass
  public void afterClass() {
  }

}
