package testng;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Policies {
    public static void policy(WebDriver driver, int secs) {
    	WebDriverWait wait = new WebDriverWait(driver,secs,100);
    	TestRegistry.setupTest("MyPolicyLogin", "Policies");
        System.out.println("Go to Policies");
        try {
        	driver.get(BootStrap.getPolicyURL());
        	System.out.println("The Policy URL is "+BootStrap.getPolicyURL());
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
        try {
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aaaie-policies-card")));
        	driver.findElement(By.id("aaaie-policies-card")).isDisplayed();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
        System.out.println("Verified policy card is displayed");
    }
}
