package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import TestRegistry;

import java.util.concurrent.TimeUnit;

public class SignIn {

	public void beforeTest() {
	}
    public static void signIn (WebDriver driver, int secs, int runNumber) throws InterruptedException {
    	//boolean testResult = true;
    	TestRegistry.setupTest("MyPolicyLogin", "SignIn");
        WebDriverWait wait = new WebDriverWait(driver,secs,100);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("Top-SignInCreateAccount-button"))).click();
        try {
        	TestRegistry.startTest("Page Load");
        	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	System.out.println("The testResult before links is "+TestRegistry.currentTestResult());
            System.out.println("Verify the links are on the Sign In page");
            System.out.println("Verify the Forgot Password is there");
            driver.findElement(By.id("AccountSignIn-ForgotPassword-link")).isDisplayed();
            System.out.println("Verify the Terms of Use link is there");
            driver.findElement(By.id("Bottom-TermsOfUse-link")).isDisplayed();
            System.out.println("Verify the Privacy Policy link is there");
            driver.findElement(By.id("AgentInfo-PrivacyPolicy-link")).isDisplayed();
            
            TestRegistry.passTestResult();
        } catch (Exception e) {
            System.err.println(e);
            TestRegistry.failTestResult();
        }
 
        
        try {
        	TestRegistry.startTest("Login");
            System.out.println("Sign in using a valid account");
            driver.findElement(By.name("username")).sendKeys(BootStrap.getUsername());
            driver.findElement(By.name("password")).sendKeys(BootStrap.getPassword());
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.findElement(By.name("next")).click();
            TestRegistry.passTestResult();
        } catch (Exception e) {
            System.err.println(e);
            TestRegistry.failTestResult();
        }

        try {
        	TestRegistry.startTest("Load Dashboard");
            System.out.println("Verify the dashboard is displayed with the cards");
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//            System.out.println("Verify payments card");
//            driver.findElement(By.id("aaaie-b2c-payments")).isDisplayed();
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
//            System.out.println("Verify Preferences card");
//            driver.findElement(By.id("aaaie-delivery-preferences")).isDisplayed();
            System.out.println("Verify Chat card");
//            driver.findElement(By.id("habla_topbar_div")).isDisplayed();
            
            TestRegistry.passTestResult();
        } catch (Exception e) {
            System.err.println(e);
            TestRegistry.failTestResult();
        }
        //Thread.sleep(10000);
    }
    
}

