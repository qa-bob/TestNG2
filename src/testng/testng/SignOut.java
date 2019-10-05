package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class SignOut {
    public static void out (WebDriver driver, int secs) {
    	TestRegistry.setupTest("MyPolicyLogin", "SignIn");
        System.out.println("Starting Signout sequence");
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.findElement(By.id("user-pane-text")).click();
        try {
        	driver.findElement(By.linkText("Sign Out")).click();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
    	  }
    }
}
