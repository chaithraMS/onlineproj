

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
    public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib =new ExcelUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public  WebDriver driver = null;
	public static  WebDriver sdriver;
	
 	@BeforeSuite(groups="Intregration")
	//@BeforeSuite
	public void connectToDB() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("--connect to DB--");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups="Intregration")
	//@BeforeClass
	public void launchBrowser() throws Throwable
	{
	String BROWSER = fLib.readDataFromFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		sdriver=driver;
		wLib.implcitlyWait(driver);
		wLib.maximixewindow(driver);
		
		String URL = fLib.readDataFromFile("url");
		driver.get(URL);
	}
		@BeforeMethod(groups="Intregration")
	//@BeforeMethod
		public void loginToApp() throws Throwable
		{
			
			System.out.println("---Login to App--");
		}
	//@AfterMethod
		@AfterMethod(groups="Intregration")
		public void signout()
		{
			
			System.out.println("--Logout to app--");
		}
	//@AfterClass
		@AfterClass(groups="Intregration")
		public void closeBrowser()
		{
			driver.quit();
			System.out.println("--close browser");
			
		}
//	@AfterSuite
		@AfterSuite(groups="Intregration")
		public void closeDB() throws Throwable
		{
			dLib.closeDB();
			System.out.println("--close DB---");
		}
	}

