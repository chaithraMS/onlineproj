



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;

import org.apache.poi.sl.usermodel.TextBox;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;



public class WebDriverUtility {
	
	public void  maximixewindow(WebDriver driver)
	{
        driver.manage().window().maximize();
	}
/**
 * This class is used to write webdriver specific methods
 * @author DELL
 */
	
	public void implcitlyWait(WebDriver driver) {
		
		 driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}
	/**
	 * This method is used  for wait until element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToVisible(WebDriver driver, WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	/**
	 * This method enables user to handle dropdown by index
	 * @param 
	 * @param value
	 */
	public void  select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}
	/**
	 * This method enables user to handle dropdown using text value
	 * @param element
	 * @param text
	 */
	
	public void select(String value, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method enables user to handle dropdown using visible text
	 * @param element
	 * @param text
	 */
	
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	 
	
	
	/**
	 * 
	 * @param driver
	 * @param JavaScript
	 */
	public void executeJavaScript(WebDriver driver, String JavaScript)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeAsyncScript(JavaScript, null);
	}
	  public void waitAndClick(WebElement element) throws InterruptedException
	  {
		  int count=0;
		  while(count<20) {
			  try {
				  element.click();
				  break;
			  } catch(Throwable e) {
				  Thread.sleep(1000);
				  count++;
			  }
		  }
	  }
	  public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
	  {
		  TakesScreenshot  ts =  (TakesScreenshot) driver;
		  File src =ts.getScreenshotAs(OutputType.FILE);
		  File dest= new File("./screenshot/"+screenshotName+".PNG");
		  Files.copy(src, dest);
	  }
	  
	 
	  /**
	   * This method will press Enter Key
	   * @param driver
	 * @throws AWTException 
	   */
	  
	  public void enterkeyPress(WebDriver driver, int Enter) throws AWTException
	  {
		  Robot rb= new Robot();
		  rb.keyPress(KeyEvent.VK_ENTER);
	  }
	  /**
	   * This method is used to release the key
	   * @param driver
	 * @throws AWTException 
	   */
	  public void enterRelease(WebDriver driver,int ENTER) throws AWTException
	  {
		  Robot rb =  new Robot();
		  rb.keyRelease(KeyEvent.VK_ENTER);
	  }
	  /**
	   * This method will switch the frame based on Index
	   * @param driver
	   * @param index
	   */
	  
	  public void switchTOFrame(WebDriver driver, int index)
	  {
		  driver.switchTo().frame(index);
	  }
	  /**
	   * This method  will switch the frame based on name
	   * @param driver
	   * @param name
	   */
	  public  void  switchToFrame(WebDriver driver, String name)
	  {
		 driver.switchTo().frame(name);
	  }
	  /**
	   * This method will switch the frame based on address
	   * @param driver
	   * @param address
	   */
	  public void switchToFrame(WebDriver driver, WebElement address)
	  {
		  driver.switchTo().frame(address);
	  }
	  
	  /**
	   * This method is used to accept alert popup
	   */
	  public void acceptAlert(WebDriver driver)
	  {
		  driver.switchTo().alert().accept();
	  }
	  /**
	   * This method is used to cancel alert pop up
	   * @param driver
	   */
	  
	  public void cancelAlert(WebDriver driver)
	  
	  {
		  driver.switchTo().alert().dismiss();
		  
	  }
	  /**
	   * This method will perform random scroll
	   * @param driver
	   */
	  
	  public void scrollBarAction(WebDriver driver)
	  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,800)", "");
	  }
	  /**
	   * This method will perform drag and drop action
	   * @param driver
	   * @param src
	   * @param dst
	   */
	  
	  public void dragAnddrop(WebDriver driver, WebElement src ,WebElement dst) 
	  {  
	     Actions act =  new Actions(driver);
	     act.dragAndDrop(src, dst).perform();
	  }
	  /**
	   * This method will double click on element
	   * @param driver
	   * @param element
	   */
	  public void doubleClickAction(WebDriver driver, WebElement element)
	  {
		  Actions act = new Actions(driver);
		  act.doubleClick(element).perform();
	  }
	  /**
	   * This method will perform double click on web pages
	   */
	  public void doubleClickAction(WebDriver driver)
	  {
		  Actions act = new Actions(driver);
		  act.doubleClick().perform();
	  }
	  /**
	   * This method will perform right click on web pages 
	   */
	  public void rightClick(WebDriver driver)
	  {
		  Actions act = new Actions(driver);
		  act.contextClick().perform();
	  }
	  /**
	   * This method will press Enter Key
	   * @param driver
	   */
	  public void enterKeyPress(WebDriver driver)
	  {
		  Actions act = new Actions(driver);
		  act.sendKeys(Keys.ENTER).perform();
	  }
	  
	  public void switchToWindow(WebDriver driver,String partialTitle)
	  {
		  //step1: use getwindowHandles to capture all window id's
		  Set<String> windows = driver.getWindowHandles();
		  
		  //step2: iterate through the windows 
		 Iterator<String> it = windows.iterator();
		 
		 //step3 : check whether there is next window 
		 while (it.hasNext()) {
			//step 4; capture current window id
			 String winId = it.next();
			 
			 //step 5:switch to current window and capture Title
			String currentwinTitle = driver.switchTo().window(winId).getTitle();
			//step 6;check whether current window is expected
			if (currentwinTitle.contains(partialTitle)) {
				break;
			}
			
		}
	  }
	  public void scrollAction(WebDriver driver, WebElement element)
	  {
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  int y = element.getLocation().getY();
		  jse.executeScript("window.scrollBy(0,"+y+")", element);
		  //jse.executeScript("argument[0].scrollIntoView()", element);
	  }
	 
	 
}
	  
	  
	 
	  
	  
	

