package Pages;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	//public static WebDriver driver;
	public static WebDriver driver = new ChromeDriver();
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;

	public void getBrowser() {
        
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://dbankdemo.com/bank/login");

	}

	@BeforeTest
	public void getnameMethod(ITestContext context) {

		extentTest = extentreports.createTest(context.getName());
	}

	@BeforeSuite // this method will be executed before suite begins its execution
	public void InitalizeExtentReport() {
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("register1_user1_report.html");
		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		extentreports.setSystemInfo("OS", System.getProperty("os.name"));
		extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));

	}

	@AfterSuite
	public void generateReports() throws IOException {
		extentreports.flush();
		Desktop.getDesktop().browse(new File("register_user_report.html").toURI());
	}

	@AfterMethod
	public void generateTestStatus(Method m, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Capture Screenshot");
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}
	}

}