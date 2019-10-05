package testng;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs {
    public static void contact (WebDriver driver, int secs) {
    	TestRegistry.setupTest("MyPolicyLogin", "ContactUs");
        driver.navigate().to(BootStrap.getContactusURL());
        try {
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	driver.findElement(By.id("aaaie-contact-us")).isDisplayed();
            TestRegistry.passTestResult();
        } catch (Exception e) {
        	TestRegistry.failTestResult();
        }
    }
}
