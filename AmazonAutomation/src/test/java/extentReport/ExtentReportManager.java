package extentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;// UI of report 
	
	public ExtentReports reports;// update the info
	
	public ExtentTest test;// create a test entries and update the test methods 
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");// specifying the location
		
		sparkReporter.config().setDocumentTitle("Automation report");
		
		sparkReporter.config().setReportName("Smoke testing");
		
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		reports = new ExtentReports();
		
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("ComputerName", "local");
		
		reports.setSystemInfo("Environment", "QA Automation test");
		
		reports.setSystemInfo("TesterName", "KodTest");
		
		reports.setSystemInfo("BrowserName", "Chrome");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = reports.createTest(result.getName());
		test.log(Status.PASS, "Test case got passed is " + result.getName());// updating whether TC is passed / fail
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, "Test case got failed is " + result.getName());// updating whether TC is passed / fail
		
	}

	public void onFinish(ITestContext context) {
		
		reports.flush();// update the changes
		
	}
}