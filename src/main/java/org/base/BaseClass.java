package org.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
		
	    //Browser Launch
		//public static WebDriver launchBrowser() {
			
			//WebDriverManager.chromedriver().setup();
			
			//driver = new ChromeDriver();
			//return driver;
		
		//}
		
		
	     /* public static WebDriver launchBrowser(String browserName) {
			
	    	 
			if(browserName.equals("chrome"))  {
	    		  WebDriverManager.chromedriver().setup();
	    		  driver = new ChromeDriver();
	    	  }
	    	  
	    	  else if(browserName.equals("edge")) {
	    		  WebDriverManager.edgedriver().setup();
	    		  driver = new EdgeDriver();
	    		 
	    	  }
	    	  
	    	  else if(browserName.equals("firefox")) {
	    		  WebDriverManager.firefoxdriver().setup();
	    		  driver = new FirefoxDriver();
	    	  }
	    	  
	    	  
	    	  else {
	    		  System.out.println("Invalid browser");
	    	  }
	    	  
	    	  
	    	  return driver;*/
		
		   
	    //  }
		
	    public static WebDriver launchBrowser(String browserName) {
			
	    	switch(browserName) {
	    	case"chrome":
	    		WebDriverManager.chromedriver().setup();
	  		    driver = new ChromeDriver();
	  		    break;
	  		    
	    	case"firefox":
	    		WebDriverManager.firefoxdriver().setup();
	    		driver=new FirefoxDriver();
	    		break;
	    		
	    	case"edge":
	    		WebDriverManager.edgedriver().setup();
	    		driver=new EdgeDriver();
	    		break;
	    		
	    	default:
	    		System.err.println("Invalid Browser");
	  		    
	  		 }
	    
	        return driver;
		
		
	       }

	      //urllaunch
	      public static void urlLaunch(String url) {
			driver.get(url);
	        driver.manage().window().maximize();
		}

	      //navigation
	     public static Navigation navigate() {
			Navigation navigate = driver.navigate();
			return navigate;

		}
	      
	      
	      
	      //wait
	      public static void implicitlywait(long time) {
			
	        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}

	      //getcurrenturl
	      public static String getCurrentUrl() {
			
	        String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

	       //gettitle
	      public static String getTitle() {
			String title = driver.getTitle();
			return title;

		}
	     

	     //quit
	      public static void quit() {
			driver.quit();

		}

	      //sendkeys
	      public static void sendKeys(WebElement e,String name) {
			e.sendKeys(name);

		}
	      
	      //click
	      public static void click(WebElement e) {
		      e.click();

		}
	    
	      //gettext
	      public static String getText(WebElement e) {
		     String text = e.getText();
			return text;
		}
	      
	      
	      //getattribute
	      public static String getAttribute(WebElement e) {
			String attribute = e.getAttribute("value");
			return attribute;

		}
	      
	      //Actions
	      //movetoelement
	      
	      public static void moveToElement(WebElement target) {
	    	  Actions a = new Actions(driver);
	           a.moveToElement(target).perform();
		}
	      
	      //draganddrop
	      public static void dragAndDrop(WebElement source,WebElement target) {
			Actions a=new Actions(driver);
			a.dragAndDrop(source, target).perform();

		}
	      
	      
	      //findelement
	      
	      public static WebElement findElement(String locator,String locatorName) {
			
	    	  WebElement value = null;
	    	  
	    	  if(locator.equals("id")) {
	    		  value=driver.findElement(By.id(locatorName));
	    	  }
	    	  
	    	  else if(locator.equals("name")) {
	    		  value=driver.findElement(By.name(locatorName));
	    	  }
	    	  
	    	  else if(locator.equals("xpath")) {
	    		  value=driver.findElement(By.xpath(locatorName));
	    	  }
	    	  
			return value;

		}
	      
	      
	      //selectbyvalue
	      
	      public static void selectbyValue(WebElement e,String value) {
			Select s = new Select(e);
	         s.selectByValue(value);
		}
	      
	      //selectbyvisibletext
	      
	      public static void selectbyVisibletext(WebElement e,String text) {
			Select s = new Select(e);
	         s.selectByVisibleText(text);
		}
	      
	      
	      
	    //select
	      //selectbyindex
	      
	      public static void selectByIndex(WebElement e,int index) {
			Select s=new Select(e);
	        s.selectByIndex(index);
		}
	      
	      
	      
	      //deselectbyvalue
	      
	      public static void deselectByvalue(WebElement e,String value) {
			Select s=new Select(e);
	        s.deselectByValue(value);
		}
	      
	      
	      
	     //deselectbyindex
	      
	      public static void deSelectByIndex(WebElement e,int index) {
			Select s = new Select(e);
			s.deselectByIndex(index);

		}
	      
	      //deselectbyvisibletext
	      public static void deSelectByVisibleText(WebElement e,String text) {
			Select s = new Select(e);
	        s.deselectByVisibleText(text);
		}
	      
	      
	      
	      //deselectall
	      
	      public static void deSelectAll(WebElement e) {
			Select s = new Select(e);
	        s.deselectAll();
		}
	      
	      
	      
	      //getoptions
	      public static List<WebElement> getOptions(WebElement e) {
			Select s = new Select(e);
	        List<WebElement> options = s.getOptions();
			return options;
		}
	      
	      
	      //getfirstselectedoptions
	      public static WebElement getFirstSelectedOptions(WebElement e) {
			Select s = new Select(e);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			return firstSelectedOption;

		}
	      

	      //getallselectedoptions
	      public static List<WebElement> getAllSelectedOptions(WebElement e) {
			Select s = new Select(e);
	        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			return allSelectedOptions;
		}
	      
	      //ismultiple
	      public static boolean isMultiple(WebElement e) {
			Select s = new Select(e);
			boolean multiple = s.isMultiple();
			return multiple;

		}
	      
	      
	      
//	      public static Alert accept(String name) {        //doubt
//			Alert a = driver.switchTo().alert();
//			
//			a.accept();
//			a.dismiss();
//			a.sendKeys(name);
//			String text = a.getText();
//			
//			
//			
//			
//			return a;
	//
//		}
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      


	}

	
	
	


