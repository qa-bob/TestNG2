package testng;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Preferences {
    public static void pref (WebDriver driver, int secs) {
    	TestRegistry.setupTest("MyPolicyLogin", "Preferences");
        driver.navigate().to(BootStrap.getPreferencesURL());
        Assert.assertTrue(driver.getCurrentUrl().contains("preferences"));
        try {
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	driver.findElement(By.id("aaaie-delivery-preferences")).isDisplayed();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
        driver.findElement(By.id("change_email")).click();
        driver.findElement(By.id("new_email")).sendKeys(BootStrap.getNewemail());
        driver.findElement(By.id("current_password")).sendKeys(BootStrap.getPassword());
        driver.findElement(By.id("save")).click();
    }

    public static void account_settings (WebDriver driver) {
    	TestRegistry.setupTest("MyPolicyLogin", "Preferences");
//    	@FindBy(id="user-pane-text").click();
        driver.findElement(By.id("user-pane-text")).click();
        driver.findElement(By.linkText("Account Settings")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("preferences"));
        try {
        	driver.findElement(By.id("aaaie-delivery-preferences")).isDisplayed();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
    }
    public static void change_email (WebDriver driver) {
    	TestRegistry.setupTest("MyPolicyLogin", "Preferences");
        driver.findElement(By.id("change_email")).click();
        driver.findElement(By.id("new_email")).sendKeys(BootStrap.getNewemail());
        driver.findElement(By.id("email_current_password")).sendKeys(BootStrap.getPassword());
        try {
        	driver.findElement(By.id("save")).click();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
    }
    public static void change_password (WebDriver driver) {
    	TestRegistry.setupTest("MyPolicyLogin", "Preferences");
        driver.findElement(By.id("change_password")).click();
        driver.findElement(By.id("password_current_password")).sendKeys(BootStrap.getPassword());
        driver.findElement(By.id("new_password")).sendKeys(BootStrap.getNewpassword());
        try {
        	driver.findElement(By.id("save")).click();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
    }
    public static void add_phone_number (WebDriver driver) {
    	TestRegistry.setupTest("MyPolicyLogin", "Preferences");
        driver.findElement(By.id("add_phone_number")).click();
        driver.findElement(By.id("new_mobile_number")).sendKeys(BootStrap.getAddnumber());
        driver.findElement(By.id("password_current_password")).sendKeys(BootStrap.getPassword());
        try {
        	driver.findElement(By.id("save")).click();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
  	  }
    }
}
