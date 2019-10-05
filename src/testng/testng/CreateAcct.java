package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CreateAcct {

//        private WebDriver driver;

        public static String baseURL = null;
        static String URL = "";

    public CreateAcct(WebDriver driver, int secs){
    	boolean testResult = true;
        driver.get(BootStrap.getLoginURL());
        System.out.println("You are in "+ BootStrap.getLoginURL());
        driver.findElement(By.name("Top-SignInCreateAccount-button")).click();
        driver.findElement(By.name("Top-SignInCreateAccount-button")).click();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //verify you are on the create account page maybe by seeing that the toggle button reads Sign In
        driver.findElement(By.name("username")).sendKeys("itriedthat@robertlsmall.us");
        driver.findElement(By.name("password")).sendKeys("APassword");
        driver.findElement(By.name("next")).click();
//        driver.findElement(By.className("tabs-title auto tab_active_auto")).isDisplayed();
        //Enter data for auto policy
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.println("BootStrap.getLastFour ="+BootStrap.getLastFour());
        driver.findElement(By.id("lastfour")).sendKeys(BootStrap.getLastFour());
        System.out.println("BootStrap.getDriversLicense = "+BootStrap.getDriversLicense());
        driver.findElement(By.id("driverslicense")).sendKeys(BootStrap.getDriversLicense());
        System.out.println("BootStrap.getZip = "+BootStrap.getZip());
        driver.findElement(By.name("zip")).sendKeys(BootStrap.getZip());
        driver.findElement(By.id("FindPolicy-AutoNext-button")).click();
        //Confirm vehicle
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(driver.findElement(By.id("Confirmation-MakeModel-filter")).isDisplayed());
        assertTrue(driver.findElement(By.id("Confirmation-Confirm-button")).isDisplayed());

    }

}
