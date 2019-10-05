package testng;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Help {
    public static void help(WebDriver driver, int secs) {
    	TestRegistry.setupTest("MyPolicyLogin", "SignIn");
        driver.navigate().to(BootStrap.getHelpURL());
        try {
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	driver.findElement(By.id("aaaie-contactus-card")).isDisplayed();
        	TestRegistry.passTestResult();
        } catch (Exception e) {
        	TestRegistry.failTestResult();
    	}
    }
}
