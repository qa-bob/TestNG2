package testng;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payments {
    public static void payment (WebDriver driver, int secs) {
    	TestRegistry.setupTest("MyPolicyLogin", "Payments");
       	driver.get(BootStrap.getPaymentsURL());
        try {
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	driver.findElement(By.id("aaaie-wallet-card")).isDisplayed();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
    }
}
