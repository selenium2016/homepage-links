package eComm_homepage;

// This script will launch the homepage and check all of the links

import java.io.*;
import java.net.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.*;
import org.junit.Assert;
import java.util.Date;


public class homepage_links {

	public static void main(String[] args) throws Exception {
		
		String browser = args[0];
		String baseURL ="https://" + args[1]+".pepboys.com/";
		System.out.println("Selected testing enviornment is " + baseURL);
		WebDriver driver = null;
		Date date=new Date();
		FileWriter outfile = new FileWriter("homepage_links_" + date.getTime() + ".txt", false);

		PrintWriter output = new PrintWriter(outfile); 
		
		switch (browser) {
		
		case "ff":  System.out.println("Selected browser is FireFox");
					driver = new FirefoxDriver();
					break;
		
		case "ie":  System.out.println("Selected browser is Internet Explorer");
					System.setProperty("webdriver.ie.driver", "selenium-2.48.2\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
		
		case "ch":  System.out.println("Selected browser is Chrome");
					System.setProperty("webdriver.chrome.driver", "selenium-2.48.2\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
					
		case "sf":  System.out.println("Selected browser is Safari");
					System.setProperty("webdriver.safari.driver", "selenium-safari-driver-2.48.1.exe");
					driver = new SafariDriver();
		
		default:    System.out.println("No Browser Passed. Default is FireFox");
					driver = new FirefoxDriver();
					break;
			
		}
		
		// First thing we are going to do is get the version of the build that we are testing
		
		try{
		loggingInfo(" Launcing the selected browser", output);
		loggingInfo(" ---Checking the build version", output);
		
		driver.get(baseURL + "version");
		driver.manage().window().maximize();
		String buildVersion= driver.findElement(By.xpath("html/body")).getText();
		loggingInfo("---Build version is "+ buildVersion, output);
		
		//Home Page//
		loggingInfo("---Navigating to "+ baseURL, output);
		driver.get(baseURL);
	
		
		
		//**************THIS IS THE HEADER OF THE HOME PAGE***************//
		
		loggingInfo(" Beginning to check the links in the header", output);
		
		//Speed Shop//
		loggingInfo("---Trying the Speed Shop Link", output);
		driver.findElement(By.xpath("html/body/header/div[1]/div/nav/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
	
		//For the Professional//
		loggingInfo("---Trying the For the Prof Link", output);
		//driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[1]/div/nav/ul/li[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Weekly Ad//
		loggingInfo("---Trying the Weekly Add Link", output);
		driver.get("https://stage.pepboys.com/");
		driver.findElement(By.xpath("html/body/header/div[1]/div/nav/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Need Help//
		loggingInfo("---Trying the Need Help Link", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[1]/div/nav/ul/li[4]/a")).click();		
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Find Store//
		loggingInfo("---Trying the Find a Store", output);
		//driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[1]/div/nav/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Make An Appointment//
		loggingInfo("---Trying the Make an Appointment", output);
		driver.get("https://stage.pepboys.com");
		driver.findElement(By.xpath("html/body/header/div[1]/div/nav/ul/li[6]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Cart/
		loggingInfo("---Trying Cart", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[1]/div/div/div[2]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Create an Account//
		loggingInfo("---Trying the Login or Create an Account", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[1]/div/div/div[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Service//
		loggingInfo("---Trying Service", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[2]/nav/ul/li[1]/a/span")).click();		
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Tires//
		loggingInfo("---Trying Tires", output);
		//driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[2]/nav/ul/li[2]/a")).click();		
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Products//
		loggingInfo("---Trying Products", output);
		//driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[2]/nav/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Savings//
		loggingInfo("---Trying Savings", output);
		//driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[2]/nav/ul/li[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Research & Learn//
		loggingInfo("---Trying Research and Learn", output);
		//driver.navigate().back();
		driver.findElement(By.xpath("html/body/header/div[2]/nav/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		
		loggingInfo(" Header complete", output);
		
		
		
		//******************THIS IS THE MAIN BODY OF THE HOME PAGE*******************//
		
		System.out.println(new Date() + " Beginning to check the links in the body");
		
		//Tires
		driver.get(baseURL);
		loggingInfo("---Trying Tires", output);
		driver.findElement(By.xpath(".//*[@id='spot-a']/div/a[1]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Oil Change//
		driver.navigate().back();
		loggingInfo("---Trying Oil Change", output);
		driver.findElement(By.xpath(".//*[@id='oil-change-btn']")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Brakes
		driver.navigate().back();
		loggingInfo("---Trying Brakes", output);
		driver.findElement(By.xpath(".//*[@id='spot-a']/div/a[3]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Make an Appointment
		driver.navigate().back();
		loggingInfo("---Trying Make An Appointment", output);
		driver.findElement(By.xpath("html/body/main/div[3]/div/div/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//View All Services
		driver.navigate().back();
		loggingInfo("---Trying View All Screens", output);
		driver.findElement(By.xpath(".//*[@id='spot-a']/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
			
		//Shop Tires
		driver.navigate().back();
		loggingInfo("---Trying Shop Tires", output);
		driver.findElement(By.xpath("html/body/main/div[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//See All Principles
		driver.navigate().back();
		loggingInfo("---Trying See All Principles", output);
		driver.findElement(By.xpath(".//*[@id='spot-d']/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Local Weekly Add
		driver.navigate().back();
		loggingInfo("---Trying Local Weekly Add", output);
		driver.findElement(By.xpath(".//*[@id='spot-e']/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Shop Tires By Vehicle//
		loggingInfo("---Trying Shop Tires By Vehicle", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[7]/a[1]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Shop Tires By Size//
		loggingInfo("---Trying Shop Tires By Size", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[7]/a[2]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[6]/p")).click();//?????//
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Shop Now//
		loggingInfo("---Trying Shop Now", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[6]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Shop Tires//
		loggingInfo("---Trying Shop Tires", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[7]/a[3]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Accessories//
		loggingInfo("---Trying Accessories", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[8]/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Batteries????//
		loggingInfo("---Trying Batteries", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[8]/ul/li[2]/a/img")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Brakes//
		loggingInfo("---Trying Brakes", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[8]/ul/li[3]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Oil & Fluids//
		loggingInfo("---Trying Oils & Fluids", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[8]/ul/li[4]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Shocks & Suspension//
		loggingInfo("---Trying Shocks & Suspention", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[8]/ul/li[5]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[7]/a[3]")).click();//?????//
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Shop Tires//
		loggingInfo("---Trying Shop Tires", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[9]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//More Savings//
		loggingInfo("---Trying More Savings", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[10]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Read Article//
		loggingInfo("---Trying Read Article", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[11]/a[1]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		/*
		//Research & Learn//
		loggingInfo("---Trying Research & Learn", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[11]/a[2]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output); Commented out */
		
		//Find Out Why//
		loggingInfo("---Trying Find Out Why", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[12]/a[1]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//About Us//
		loggingInfo("---Trying About Us", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[12]/a[2]")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Learn More//
		loggingInfo("---Trying Learn More", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/main/div[13]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		loggingInfo(" Body Cpmplete", output);
		
		//********************THIS IS THE FOOTER OF THE HOME PAGE*****************//
		
		loggingInfo(" Beginning to check the links in the footer", output);
		
		//Our History//
		loggingInfo("---Trying Ojur History", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[1]/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Press Releases
		loggingInfo("---Trying Press Releases", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[1]/ul/li[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Media//
		loggingInfo("---Trying Media", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[1]/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Investor Relations//
		loggingInfo("---Trying Investor Relations", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[1]/ul/li[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Careers//
		loggingInfo("---Trying Carreers", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[1]/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Video Library//
		loggingInfo("---Trying Video Library", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[1]/ul/li[6]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Affiliate Program//
		loggingInfo("---Trying Affiliate Program", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[1]/ul/li[7]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Find a Store//
		loggingInfo("---Trying Find A Store", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[2]/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//View All Pep Boys Locations//
		loggingInfo("---Trying View All Pep Boys Locations", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[2]/ul/li[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Make an Appointment//
		loggingInfo("---Trying Make An Appointment", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[2]/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Need a Tow?//
		loggingInfo("---Trying Need a Tow", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[2]/ul/li[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Speed Shop//
		loggingInfo("---Trying Speed Shop", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[2]/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//For the Professional//
		loggingInfo("---Trying For the Professional", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[2]/ul/li[6]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Coupons//
		loggingInfo("---Trying Coupons", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[3]/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Weekly Flyer//
		loggingInfo("---Trying Weekly Flyer", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[3]/ul/li[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Manufacturer Rebates//
		loggingInfo("---Trying Manufacturer Rebates", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[3]/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Pep Boys Rebates//
		loggingInfo("---Trying Pep Boys Rebates", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[3]/ul/li[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Online Savings//
		loggingInfo("---Trying Online Savings", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[3]/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Pep Boys Credit Card//
		loggingInfo("---Trying Pep Boys Credit Cards", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[3]/ul/li[6]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//How it Works//
		loggingInfo("---Trying How it Works", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[4]/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Enroll for Rewards//
		loggingInfo("---Trying Enroll for Rewards", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[4]/ul/li[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Check Your Points//
		loggingInfo("---Trying Check Your Points", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[4]/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Add Rewards//
		loggingInfo("---Trying Add Rewards", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[4]/ul/li[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Voucher Balance//
		loggingInfo("---Trying Voucher Balance", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[4]/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Customer Care//
		loggingInfo("---Trying Customer Care", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[5]/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//FAQ//
		loggingInfo("---Trying FAQ", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[5]/ul/li[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//My Appointments//
		loggingInfo("---Trying My Appointments", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[5]/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Track an Order//
		loggingInfo("---Trying Track an Order", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[5]/ul/li[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Shipping Information//
		loggingInfo("---Trying Shipping Information", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[5]/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Gift Cards//
		loggingInfo("---Trying Gift Cards", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[5]/ul/li[6]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Contact Information//
		loggingInfo("---Trying Contact Information", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[5]/ul/li[7]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Sign Up for Email//
		loggingInfo("---Trying Sign Up For Email", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[6]/div[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Sign Up for Text Alerts//
		loggingInfo("---Trying Sign Up for Text Alerts", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[6]/div[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Download the Mobile App//
		loggingInfo("---Trying Download the mobile app", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[1]/div[6]/div[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Terms & Conditions//
		loggingInfo("---Trying Terms and Conditions", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[3]/ul/li[1]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Privacy & Security//
		loggingInfo("---Trying Privacy & Security", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[3]/ul/li[2]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//CA Transparency in Supply Chains Act//
		loggingInfo("---Trying CA Transparency in Supply Chains Act", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[3]/ul/li[3]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Arbitration Process//
		loggingInfo("---Trying Arbitration Process", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[3]/ul/li[4]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Price Match Guarantee//
		loggingInfo("---Trying Price match Guarantee", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[3]/ul/li[5]/a")).click();
		waitForPageLoaded(driver);
		checkFor_404(driver, output);
		
		//Site Map//
		loggingInfo("---Trying Site map", output);
		driver.navigate().back();
		driver.findElement(By.xpath("html/body/footer/div[3]/ul/li[6]/a")).click();
	
		loggingInfo(" Footer Complete", output);
	
		
		}
		 catch(Exception e)
	    {
	        Assert.assertFalse("*** Oops, something went wrong! ***",true);
	        output.close();
	        throw e;

	    }
		
		output.close();

	}

	
	public static void waitForPageLoaded(WebDriver driver)
	{
	    ExpectedCondition<Boolean> expectation = new
	ExpectedCondition<Boolean>() 
	    {
	        public Boolean apply(WebDriver driver)
	        {
	            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	    };
	    Wait<WebDriver> wait = new WebDriverWait(driver,90);
	    try
	    {
	        wait.until(expectation);
	    }
	    catch(Throwable error)
	    {
	        Assert.assertFalse("*** Timeout waiting for Page Load Request to complete! ***",true);
	    }
	}
	
	
	public static void loggingInfo(String output_message, PrintWriter output){
		
		
		System.out.println(new Date() + output_message);
		output.println(new Date() + output_message);


	}

	public static void checkFor_404(WebDriver driver, PrintWriter output) throws Exception
	{
		boolean found_404 = driver.getPageSource().contains("Looks like you've hit a bump in the road");
		String thisURL= driver.getCurrentUrl();
		URL aURL = new URL(driver.getCurrentUrl());
		
		if (found_404){
		    loggingInfo("*** Warning - 404 Detected at " + thisURL + "  ***", output);  

			String path = new String(aURL.getPath());
	        String screenshot = path.replaceAll("/", "---");        
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("screenshot___" + screenshot + ".png"));
		}
	
	}
			
		

	
}
