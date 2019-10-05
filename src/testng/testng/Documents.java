package testng;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Documents {
    public static void docs (WebDriver driver, int secs) {
    	TestRegistry.setupTest("MyPolicyLogin", "SignIn");
        driver.navigate().to(BootStrap.getDocumentsURL());
        try {
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	driver.findElement(By.id("aaaie-documents-card")).isDisplayed();
        	TestRegistry.passTestResult();
        }catch (Exception e) {
        	TestRegistry.failTestResult();
    	}
    }
}
