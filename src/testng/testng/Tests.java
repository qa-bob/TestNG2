package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.TestNGAntTask.Mode.testng;

public class Tests {
	@Test
    public static void main () throws InterruptedException {
    int runNumber = 0;
    System.out.println("runNumber set to "+runNumber);
    while (runNumber < 8) {
        System.out.println("runNumber set to "+runNumber);
        System.out.println("Entering the while loop");
        System.out.println("Getting Driver");
        WebDriver driver = BootStrap.getDriver(Integer.toString(runNumber));
        driver.get(BootStrap.getLoginURL());
        System.out.println(" The loginURL is "+ BootStrap.getLoginURL()+".");
        System.out.println(" The Environment is "+ BootStrap.getCurrentEnvironment() +".");

            SignIn.signIn(driver, 10, runNumber);
            System.out.println("The dashboard has been verified");
            Policies.policy(driver, 10);
            System.out.println("The policy page has been verified");
            Payments.payment(driver, 10);
            System.out.println("The payments page has been verified");
            Documents.docs(driver, 10);
            System.out.println("The documents page has been verified");
            Help.help(driver, 10);
            System.out.println("The help page has been verified");
            ContactUs.contact(driver, 10);
            System.out.println("The contact page has been verified");
            runNumber++;
            driver.quit();
        }
    }
}
