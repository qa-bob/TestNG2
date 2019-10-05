package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
public class BootStrap {

    public static String loginURL = null;
    public static String policyURL = null;
    public static String paymentsURL = null;
    public static String helpURL = null;
    public static String documentsURL = null;
    public static String contactusURL = null;
    public static String username = null;
    public static String password = null;
    public static String forgotpwdURL = null;
    public static String emailURL = null;
    public static String forgotpwdPassword = null;
    public static String newpassword = "APassword";
    public static String resetpwdURL = null;
    public static String preferencesURL = null;
    public static String newemail = "newemail@csaa.com";
    public static String lastFour = "1921";
    public static String driversLicense = "041946716";
    public static String zip = "06085";
    public static String addnumber = "602-123-1234";
    public static String currentEnv = "dev";

    public static String getPreferencesURL() {
        return preferencesURL;
    }

    public static void setPreferencesURL(String preferencesURL) {
        BootStrap.preferencesURL = preferencesURL;
    }

    public static void setLastFour(String lastFour) {
        BootStrap.lastFour = lastFour;
    }

    public static void setDriversLicense(String driversLicense) {
        BootStrap.driversLicense = driversLicense;
    }

    public static void setZip(String zip) {
        BootStrap.zip = zip;
    }

    public static String getLastFour() {
        return lastFour;
    }
    
    public static String getCurrentEnvironment() {
        return currentEnv;
    }

    public static String getDriversLicense() {
        return driversLicense;
    }

    public static String getZip() {
        return zip;
    }

    public static String getNewpassword() {
        return newpassword;
    }

    public static void setNewpassword(String newpassword) {
        BootStrap.newpassword = newpassword;
    }



    public static String getResetpwdURL() {
        return resetpwdURL;
    }

    public static void setResetpwdURL(String resetpwdURL) {
        BootStrap.resetpwdURL = resetpwdURL;
    }



    public static String getForgotpwdPassword() {
        return forgotpwdPassword;
    }

    public static void setForgotpwdPassword(String forgotpwdPassword) {
        BootStrap.forgotpwdPassword = forgotpwdPassword;
    }

    public static String getEmailURL() {
        return emailURL;
    }

    public static void setEmailURL(String emailURL) {
        BootStrap.emailURL = emailURL;
    }

    public static String getForgotpwdusername() {
        return forgotpwdusername;
    }

    public static void setForgotpwdusername(String forgotpwdusername) {
        BootStrap.forgotpwdusername = forgotpwdusername;
    }

    public static String forgotpwdusername = null;

    public static String getForgotpwdURL() {
        return forgotpwdURL;
    }

    public static void setForgotpwdURL(String forgotpwdURL) {
        BootStrap.forgotpwdURL = forgotpwdURL;
    }

    public static String getContactusURL() {
        return contactusURL;
    }

    public static void setContactusURL(String contactusURL) {
        BootStrap.contactusURL = contactusURL;
    }

    public static String getDocumentsURL() {
        return documentsURL;
    }

    public static void setDocumentsURL(String documentsURL) {
        BootStrap.documentsURL = documentsURL;
    }

    public static String getHelpURL() {
        return helpURL;
    }

    public static void setHelpURL(String helpURL) {
        BootStrap.helpURL = helpURL;
    }

    public static String getPaymentsURL() {
        return paymentsURL;
    }

    public static void setPaymentsURL(String paymentsURL) {
        BootStrap.paymentsURL = paymentsURL;
    }

    public static String getPolicyURL() {
        return policyURL;
    }

    public static void setPolicyURL(String policyURL) {
        BootStrap.policyURL = policyURL;
    }

    public static void setLoginURL(String loginURL) {
        BootStrap.loginURL = loginURL;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        BootStrap.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        BootStrap.password = password;
    }

    public static String getAddnumber() {
        return addnumber;
    }

    public static void setAddnumber(String addnumber) {
        BootStrap.addnumber = addnumber;
    }

    public static String getNewemail() {
        return newemail;
    }

    public static void setNewemail(String newemail) {
        BootStrap.newemail = newemail;
    }

    public static String getLoginURL() {
        System.out.println("Getting loginURL to navigate to.");
        return loginURL;
    }

    static {
        String environment = getEnvironment("./environment.txt");
        currentEnv = environment;
        switch (environment) {
            case "DEV":
                loginURL = "https://mypolicy.dev.digital.pncie.com/mypolicy/login";
                policyURL= "https://mypolicy.dev.digital.pncie.com/mypolicy/policies";
                paymentsURL= "https://mypolicy.dev.digital.pncie.com/mypolicy/payments";
                helpURL= "https://mypolicy.dev.digital.pncie.com/mypolicy/help";
                documentsURL= "https://mypolicy.dev.digital.pncie.com/mypolicy/documents";
                contactusURL= "https://mypolicy.dev.digital.pncie.com/mypolicy/contactUs";
                preferencesURL = "https://mypolicy.dev.digital.pncie.com/mypolicy/preferences";
                forgotpwdURL= "https://mypolicy.dev.digital.pncie.com/mypolicy/forgot-password";
                resetpwdURL = "https://mypolicy.dev.digital.pncie.com/mypolicy/reset-password";
                username = "todd.kurtz@csaa.com";
                password = "Password1";
                forgotpwdusername = "todd.kurtz@robertlsmall.us";
                emailURL = "https://email.secureserver.net";
                forgotpwdPassword = "Password2";
                break;
            case "PERF":
                loginURL = "https://mypolicy.perf.digital.pncie.com/mypolicy/login";
                policyURL= "https://mypolicy.perf.digital.pncie.com/mypolicy/policies";
                paymentsURL= "https://mypolicy.perf.digital.pncie.com/mypolicy/payments";
                helpURL= "https://mypolicy.perf.digital.pncie.com/mypolicy/help";
                documentsURL= "https://mypolicy.perf.digital.pncie.com/mypolicy/documents";
                contactusURL= "https://mypolicy.perf.digital.pncie.com/mypolicy/contactUs";
                preferencesURL = "https://mypolicy.dev.digital.pncie.com/mypolicy/preferences";
                forgotpwdURL= "https://mypolicy.perf.digital.pncie.com/mypolicy/forgot-password";
                username = "todd.kurtz@csaa.com";
                password = "Password1";
                forgotpwdusername = "todd.kurtz@robertlsmall.us";
                forgotpwdPassword = "Password2";
                break;
            default:
                loginURL = "https://mypolicy.digital.csaa-insurance.aaa.com/mypolicy/login";
                policyURL= "https://mypolicy.digital.csaa-insurance.aaa.com/mypolicy/policies";
                paymentsURL= "https://mypolicy.digital.csaa-insurance.aaa.com/mypolicy/payments";
                helpURL= "https://mypolicy.digital.csaa-insurance.aaa.com/mypolicy/help";
                documentsURL= "https://mypolicy.digital.csaa-insurance.aaa.com/mypolicy/documents";
                contactusURL= "https://mypolicy.digital.csaa-insurance.aaa.com/mypolicy/contactUs";
                preferencesURL = "https://mypolicy.dev.digital.pncie.com/mypolicy/preferences";
                forgotpwdURL= "https://mypolicy.digital.csaa-insurance.aaa.com/mypolicy/forgot-password";
                username = "todd.kurtz@csaa.com";
                password = "Password1";
                forgotpwdusername = "todd.kurtz@robertlsmall.us";
                forgotpwdPassword = "Password2";
                break;
        }

    }

    private static WebDriver driver;

    private BootStrap () {
        //Leaving private to keep from multiple instantiations of BootStrap class
    }

    public static WebDriver getDriver(String runNumber) {
        System.out.println("Getting driver from BootStrap");
        String username = "TransactPDSubscriptions@blackboard.com";
        String authkey = "uf08f12f58f814a3";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("name", "BbTransact Automation");
        caps.setCapability("build", "0.0.1");
        caps.setCapability("record_video", "false");
        caps.setCapability("record_network", "false");
        System.out.println("Entering switch statement");
        switch (runNumber) {

            case "0":
                caps.setCapability("browser_api_name", "IE11");
                caps.setCapability("os_api_name", "Win7x64-Base");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
            case "1":
                caps.setCapability("browser_api_name", "IE11");
                caps.setCapability("os_api_name", "Win8.1");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
            case "2":
                caps.setCapability("browser_api_name", "IE11");
                caps.setCapability("os_api_name", "Win10");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
            case "3":
                caps.setCapability("browser_api_name", "Chrome52x64");
                caps.setCapability("os_api_name", "Win10");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
            case "4":
                caps.setCapability("browser_api_name", "Safari9");
                caps.setCapability("os_api_name", "Mac10.11");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
            case "5":
                caps.setCapability("browser_api_name", "Chrome52x64");
                caps.setCapability("os_api_name", "Mac10.11");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
            case "6":
                caps.setCapability("browser_api_name", "FF46");
                caps.setCapability("os_api_name", "Mac10.11");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
//            case "7":
//                caps.setCapability("browser_api_name", "MblSafari9.0");
//                caps.setCapability("os_api_name", "iPhone6s-iOS9sim");
//                caps.setCapability("screen_resolution", "750x1334");
//                break;
//            case "8":
//                caps.setCapability("browser_api_name", "MblChrome35");
//                caps.setCapability("os_api_name", "GalaxyS5-And44");
//                caps.setCapability("screen_resolution", "1080x1920");
//                break;
            default:
                caps.setCapability("browser_api_name", "Chrome52x64");
                caps.setCapability("os_api_name", "Win7x64-C1");
                caps.setCapability("screen_resolution", "1400x1050");
                break;
        }
        try {
            RemoteWebDriver driver1 = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
            driver = driver1;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        WebDriver driver = new FirefoxDriver();
        System.out.println("Got the driver");
        return driver;
    }


    
    
    //Getting Environment where code was deployed to.
    @SuppressWarnings("resource")
    public static String getEnvironment() {
        String env = "";
        try {
            File file = new File (filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                env = s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }return env;
    }
}

