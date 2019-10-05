package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PasswordRest {
    public static void reset () {
    	boolean testResult = true;
        WebDriver driver = new FirefoxDriver();
        driver.get("http://mypolicy.dev.digital.pncie.com/mypolicy/transactionid");  //This goes to transactionid testharness page
        WebElement transactionid = driver.findElement(By.id("transactionid"));  //The transaction id needs to have an attribute of id=transactionid
        driver.get(BootStrap.getResetpwdURL()+"?"+transactionid);
        driver.findElement(By.id("newpassword")).sendKeys(BootStrap.getNewpassword());
        driver.findElement(By.id("submit")).click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        System.out.println("Verify you are on the dashboard");
        System.out.println("Verify payments card");
        driver.findElement(By.id("aaaie-b2c-payments")).isDisplayed();
        System.out.println("Verify policy card");
        driver.findElement(By.id("aaaie-policies-card")).isDisplayed();
        System.out.println("Verify ContactUs card");
        driver.findElement(By.id("aaaie-contactus-card")).isDisplayed();
        System.out.println("Verify ID card");
        driver.findElement(By.id("aaaie-id-card")).isDisplayed();
        System.out.println("Verify claims card");
        driver.findElement(By.id("aaaie-claims")).isDisplayed();
        System.out.println("Verify Link Policy card");
        driver.findElement(By.id("aaaie-linkpolicy")).isDisplayed();
        System.out.println("Verify FAQ card");
        driver.findElement(By.id("aaaie-faq")).isDisplayed();
        System.out.println("Verify Chat card");
        driver.findElement(By.id("habla_topbar_div")).isDisplayed();
    }

}
