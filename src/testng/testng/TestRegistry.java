package testng;

/**
 * Created by gmm4shu on 8/3/2016.
 */
import com.codahale.metrics.*;
import org.coursera.metrics.datadog.DatadogReporter;
import org.coursera.metrics.datadog.DatadogReporter.Expansion;
import org.coursera.metrics.datadog.DefaultMetricNameFormatter;
import org.coursera.metrics.datadog.TaggedName;
import org.coursera.metrics.datadog.transport.Transport;
import org.coursera.metrics.datadog.transport.HttpTransport;
import com.timgroup.statsd.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.TestNGAntTask.Mode.testng;

public class TestRegistry {
    public enum TestResult {Pass,Fail,Blocked};
    private static String TheKey = "Akey";
    private static MetricRegistry Mreg = new MetricRegistry();
    private static List<String> tags = Arrays.asList("test_id","feature_id", "env_id", "app_id", "test_result");
    private static void reset(Counter value)
    {
        long val = value.getCount();
        value.dec(val);           // Zeroes the counter
    }
     private static String getTime()
     {
         Calendar cal = Calendar.getInstance();
         Date now = cal.getTime();
         Timestamp tim = new Timestamp(now.getTime());
         return tim.toString();

     }
    private static void DumpAll()
    {
    	System.out.println("--------------------Starting the DumpAll method-----------------------");
        DefaultMetricNameFormatter The_format = new DefaultMetricNameFormatter();
        HttpTransport val = new HttpTransport.Builder().withApiKey(TheKey).build();
        DatadogReporter reporter = DatadogReporter.forRegistry(Mreg)
                .withTransport(val)
                .withTags(tags)
                .withMetricNameFormatter(The_format)
                 .build();
        reporter.start(5, TimeUnit.SECONDS);
        System.out.println("Metrics reporting complete-----------------------------------");
        Mreg = new MetricRegistry();   // report metrics after each logout
    }
    private static void PassTest (Counter sam) {
        sam.inc();
    }
    private static void FailTest (Counter sam)
    {
        sam.dec();
    }
    private static Counter getNew(String TestName, String Feature, String EnvironmentData,
                                      String Application, String result)
    {
        TaggedName value = new TaggedName.TaggedNameBuilder ()
//                .metricName("B2BAutomationTestResults")
                .metricName("csaa.ds.web_automation")  //test_name suite/feature environment data application
                .addTag(tags.get(0),TestName)
                .addTag(tags.get(1),Feature)
                .addTag(tags.get(2),EnvironmentData)
                .addTag(tags.get(3),Application)
                .addTag(tags.get(4),result)
                .build();
           Counter pam = Mreg.counter(value.encode());
        reset(pam);   // default to blocked
        if (result.equalsIgnoreCase("pass"))
            PassTest(pam);
        else if (result.equalsIgnoreCase("fail"))
            FailTest(pam);
//        Mreg.getCounters(bob.matches(MetricRegistry.name(TestClass,TestSubClass,AgentName,AgentId),pam));
        System.out.println("Logged metrics data to registry-----------------------------");
        return pam;
    }
    private static void LogResult(String TestName, String Feature, String EnvironmentData,
            String Application, TestResult result)
    {
        String the_result;
        if (result == TestResult.Pass)
        {
            the_result = "pass";
        } else if (result == TestResult.Fail)
        {
            the_result = "fail";
        } else the_result = "blocked";
        getNew(TestName,
                Feature, EnvironmentData, Application, the_result);

    }
    
    
    static TestResult testResult=TestResult.Pass;
    static String _testName;
    static String _app;
    static String _feature;
    public static void setupTest(String app, String testName){
    	_testName = testName;
    	_app = app;
    }
    public static void startTest(String feature){
    	_feature = feature;
    	testResult= TestResult.Pass;
    }
    public static void passTestResult(){
    	testResult = TestResult.Pass;
    	TestRegistry.LogResult(_testName, _feature, BootStrap.getEnvironment(), _app, testResult);
    	TestRegistry.DumpAll();
    }
    public static void failTestResult(){
    	testResult = TestResult.Fail;
    	TestRegistry.LogResult(_testName, _feature, BootStrap.getCurrentEnvironment(), _app, testResult);
    	TestRegistry.DumpAll();
    }
    public static void blockTestResult(){
    	testResult = TestResult.Blocked;
    	TestRegistry.LogResult(_testName, _feature, BootStrap.getCurrentEnvironment(), _app, testResult);
    	TestRegistry.DumpAll();
    }
    public static TestResult currentTestResult(){
    	return testResult;
    }
  
}


