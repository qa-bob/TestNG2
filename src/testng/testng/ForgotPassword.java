package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ForgotPassword {
    public static void reset(WebDriver driver) {
    	boolean testResult = true;
        driver.get(BootStrap.getForgotpwdURL());
        driver.findElement(By.id("ForgotPassword-sendForgotPasswordEmail-button")).isDisplayed();
        System.out.println("On the forgot password page");
        driver.findElement(By.id("ForgotPassword-Email-input")).sendKeys(BootStrap.getUsername());
        System.out.println("Entering username");
        driver.findElement(By.id("ForgotPassword-sendForgotPasswordEmail-button")).click();
        System.out.println("Waiting for the ReSend Email banner");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        System.out.println("Verified Email banner is displayed");
        assertTrue(isTextPresent("Email sent", driver));
    }

    public static boolean isTextPresent(String text, WebDriver driver){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
    }
}
