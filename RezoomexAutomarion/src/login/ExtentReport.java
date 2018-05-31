package login;

import java.awt.List;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.utility.CaptureScreenShot;

@Test
public class ExtentReport {

	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	WebDriver driver;

	@BeforeTest
	public void startTest() {
		reports = new ExtentReports();

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//extentreport.html");
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine", "Sagar-478");
		reports.setSystemInfo("Env", "QA");
		reports.setSystemInfo("Build", "Integration");
		reports.setSystemInfo("Browser", "Chrome");
	}

	@BeforeMethod
	  public void beforeclass() throws InterruptedException 
	  {
		   System.setProperty("webdriver.chrome.driver","/home/synerzip/Selenium/Jar/chromedriver");
		   driver=new ChromeDriver();
		   ChromeOptions options = new ChromeOptions(); 
		   options.addArguments("disable-infobars"); 
		   driver.manage().window().maximize();
		   driver.get("https://orphanqa.rezoomex.in");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   driver.findElement(By.id("login-username")).sendKeys("sagar");
		   driver.findElement(By.id("login-password")).sendKeys("sagar");
		   driver.findElement(By.id("loginBtn")).click();
		   Thread.sleep(2000);
	  }

@Test(priority=1)
	  public void pageTitleTest() 
	  {   	
		   test = reports.createTest("pageTitleTest");
  
		  
		   String actual_title=driver.getTitle();
		   String expected_title="Rezoomex Applicant Tracking System";
		   System.out.println(actual_title);
		   System.out.println(expected_title);
		   Assert.assertEquals(actual_title, expected_title);
		   //System.out.println("TestCaseForPageTitlePass");
	  }
	  @DataProvider
	  public Object getData()
	  {
	  Object data[][]=new Object[1][2];
	  data[0][0]="sagar";
	  data[0][1]="sagar";
	 
	  data[1][0]="admin";
	  data[1][1]="password";
	  
	  data[2][0]="chetan";
	  data[2][1]="password";
	  
	  data[3][0]="namrata";
	  data[3][1]="password";
	  
	  data[4][0]="demo";
	  data[4][1]="demo";
	  
	  data[5][0]="devops";
	  data[5][1]="password";
	  
     data[6][0]="dinesh";
	  data[6][1]="dineshg";
	  
	  data[7][0]="akshay";
	  data[7][1]="password";
	  return data;
	  
	  
	  
	  }
	  @Test(dataProvider="getData",priority=2)
	  public void loginTest(String username,String password) throws InterruptedException
	  
	 // @Test(priority=2)
	 // public void loginTest() throws InterruptedException 
	  {
		  test = reports.createTest("loginTest");
         
	       //String expectedButtonCaption="Login";
		   //String actualButtonCaption=driver.findElement(By.className("form-group")).getText();
		   //System.out.println(actualButtonCaption);
		  // System.out.println(expectedButtonCaption);
		  // Assert.assertEquals(actualButtonCaption,expectedButtonCaption );
		   driver.findElement(By.id("login-username")).sendKeys("sagar");
		   driver.findElement(By.id("login-password")).sendKeys("sagar");
		   driver.findElement(By.id("loginBtn")).click();
		   
		   System.out.println("Login Successful");
		   Thread.sleep(2000);
		  
	  
}


	  @Test(priority=3)
	  public void automatedjob() throws InterruptedException
	  {
		    test = reports.createTest("automatedjob");
		   //driver.findElement(By.name("company")).sendKeys("Synerzip");
	       Thread.sleep(2000);
		   //driver.findElement(By.id("company-aboutus")).click();
		   
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   WebElement element=driver.findElement(By.id("selectJob"));
		   Select job=new Select(element);
		   System.out.println("Jobs are : "+job);
		   job.selectByVisibleText("Senior BI/ Reports Developer");
		   Thread.sleep(9000);
		   Select technology=new Select(driver.findElement(By.id("selectTechnology")));
		   technology.selectByVisibleText(".Net");
		   Thread.sleep(3000);
		   
		   driver.findElement(By.id("createjobbuttonId")).click();
		   Thread.sleep(3000);
		  
	 }
	
	  @Test(priority=4)
	  public void manualjob() throws InterruptedException
	  {
		  test = reports.createTest("manualjob");
		  Select technology=new Select(driver.findElement(By.id("selectTechnology")));
		  technology.selectByVisibleText("Angularjs");
		  Thread.sleep(9000);
		  driver.findElement(By.id("createjobid")).sendKeys("UIDev1");
		  Thread.sleep(3000);
		  driver.findElement(By.id("jdtextarea")).sendKeys("Total Experience- 3-8 Years Must have- Object Oriented Javascript, HTML, CSS.Should have- Exposure to at least one of the JS framework/ library Backbone/ Angular/ React.Good to have- NodeJs.");
		  Thread.sleep(3000);
		  driver.findElement(By.id("createjobbuttonId")).click();;
		  Thread.sleep(5000);
		  
		  
	  }
	  
	  
	  @Test(priority=5)
	  public void ProcessJob() throws InterruptedException
	  {  
		    test = reports.createTest("processJob");
		    Thread.sleep(2000);
		    Select technology=new Select(driver.findElement(By.id("selectTechnology")));
		    technology.selectByVisibleText("Javaj2ee");
		    Thread.sleep(9000);
		    driver.findElement(By.id("createjobid")).sendKeys("UI3to5JD11");
		    Thread.sleep(3000);
		    driver.findElement(By.id("jdtextarea")).sendKeys("Total Experience- 3-8 Years Must have- Object Oriented Javascript, HTML, CSS.Should have- Exposure to at least one of the JS framework/ library Backbone/ Angular/ React.Good to have- NodeJs.");
		    Thread.sleep(3000);
		    driver.findElement(By.id("createjobbuttonId")).click();;
		    Thread.sleep(5000);
		    
		    WebElement table = driver.findElement(By.xpath("//*[@id='manageJobs']"));    
			java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));        
			System.out.println("Rows: " +rows.size());
			java.util.List<WebElement> cols=table.findElements(By.tagName("td"));        
			System.out.println("Columns: " +cols.size()); 
			WebElement lastrowcount=rows.get(rows.size()-1);
			System.out.println("last row:"+lastrowcount);
			java.util.List<WebElement> lastrowCols =lastrowcount.findElements(By.tagName("td"));       
	        System.out.println("lastrowCols: " +lastrowCols.size()); 
	        
	        WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);    
	        java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
			System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());
			Thread.sleep(1000);
			lastrowlastColsButtons.get(0).click();
			Thread.sleep(9000);
			System.out.println("Job Process Successfully");
		
	  }
	  
	  
	  @Test(priority=6)
	  public void openjobannotatedtab() throws InterruptedException
	  
	  {     Thread.sleep(2000);
	        test = reports.createTest("openjobannotatedtab");
		    WebElement table = driver.findElement(By.xpath("//*[@id='manageJobs']"));    
			java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));        
			System.out.println("Rows: " +rows.size());
			java.util.List<WebElement> cols=table.findElements(By.tagName("td"));        
			System.out.println("Columns: " +cols.size()); 
			WebElement lastrowcount=rows.get(rows.size()-1);
			System.out.println("last row:"+lastrowcount);
			java.util.List<WebElement> lastrowCols =lastrowcount.findElements(By.tagName("td"));       
	        System.out.println("lastrowCols: " +lastrowCols.size()); 
	        
	        WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);    
	        java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
			System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());
			Thread.sleep(1000);
			
			lastrowlastColsButtons.get(1).click();
			Thread.sleep(9000);
			//Annotated and missing info Tab
			driver.findElement(By.id("backtocorpusbuttonid")).click();
		    Thread.sleep(9000);
			
			//To Be Annotated Tab
			
			/*Thread.sleep(1000);
			//lastrowlastColsButtons.get(1).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[1]/div/ul/li[2]/a"));
			//driver.findElement(By.cssSelector("body > div > div > div.di-app-body > div.main-Container.col-xs-12.ng-scope > div > div > div.col-md-12.col-sm-12.main-container > div > ul > li.ng-isolate-scope.active > a"));
			Thread.sleep(5000);
			//driver.findElement(By.id("openjdtabid")).click();
			driver.findElement(By.xpath("//a[contains(text(),'To Be Annotated')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("saveButtonId")).click();
			driver.findElement(By.id("finishEditingButtonId")).click();
			driver.findElement(By.id("backtocorpusbuttonid")).click();
			*/
			
	  }
	  
	  @Test(priority=7)
	  public void openjobtobeannotatedtab() throws InterruptedException
	  
	  {     Thread.sleep(2000);
	        test = reports.createTest("openjobtobeannotatedtab");
		    WebElement table = driver.findElement(By.xpath("//*[@id='manageJobs']"));    
			java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));        
			System.out.println("Rows: " +rows.size());
			java.util.List<WebElement> cols=table.findElements(By.tagName("td"));        
			System.out.println("Columns: " +cols.size()); 
			WebElement lastrowcount=rows.get(rows.size()-1);
			System.out.println("last row:"+lastrowcount);
			java.util.List<WebElement> lastrowCols =lastrowcount.findElements(By.tagName("td"));       
	        System.out.println("lastrowCols: " +lastrowCols.size()); 
	        
	        WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);    
	        java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
			System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());
			Thread.sleep(1000);
			
			lastrowlastColsButtons.get(1).click();
			Thread.sleep(9000);
			driver.findElement(By.xpath("//a[contains(text(),'To Be Annotated')]")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("saveButtonId")).click();
			Thread.sleep(9000);
			driver.findElement(By.id("finishEditingButtonId")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]")).click();
			Thread.sleep(12000);
			driver.findElement(By.id("standardizejdButtonId")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("saveButtonId")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("backtocorpusbuttonid")).click();
			
	  }
	  @Test (priority=8)
	  public void trackjob() throws InterruptedException
	  {
		    Thread.sleep(2000);
		    test = reports.createTest("trackjob");
		    WebElement table = driver.findElement(By.xpath("//*[@id='manageJobs']"));    
			java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));        
			System.out.println("Rows: " +rows.size());
			java.util.List<WebElement> cols=table.findElements(By.tagName("td"));        
			System.out.println("Columns: " +cols.size()); 
			WebElement lastrowcount=rows.get(rows.size()-1);
			System.out.println("last row:"+lastrowcount);
			java.util.List<WebElement> lastrowCols =lastrowcount.findElements(By.tagName("td"));       
	        System.out.println("lastrowCols: " +lastrowCols.size()); 
	        
	        WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);    
	        java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
			System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());
			Thread.sleep(1000);
			lastrowlastColsButtons.get(3).click();
			Thread.sleep(9000);
			
	  }
	  @Test(priority=9)
	  public void downloadtracker() throws InterruptedException
	  {
		    Thread.sleep(2000);
		    test = reports.createTest("downloadtracker");
		    WebElement table = driver.findElement(By.xpath("//*[@id='manageJobs']"));    
			java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));        
			System.out.println("Rows: " +rows.size());
			java.util.List<WebElement> cols=table.findElements(By.tagName("td"));        
			System.out.println("Columns: " +cols.size()); 
			WebElement lastrowcount=rows.get(rows.size()-1);
			System.out.println("last row:"+lastrowcount);
			java.util.List<WebElement> lastrowCols =lastrowcount.findElements(By.tagName("td"));       
	        System.out.println("lastrowCols: " +lastrowCols.size()); 
	        
	        WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);    
	        java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
			System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());
			Thread.sleep(1000);
			lastrowlastColsButtons.get(4).click();
			Thread.sleep(9000);
		  
	  }
	  
	  @Test(priority=10)
	  public void deletejob() throws InterruptedException
	  {
		    Thread.sleep(2000);
		    test = reports.createTest("deletejob");
		    WebElement table = driver.findElement(By.xpath("//*[@id='manageJobs']"));    
			java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));        
			System.out.println("Rows: " +rows.size());
			java.util.List<WebElement> cols=table.findElements(By.tagName("td"));        
			System.out.println("Columns: " +cols.size()); 
			WebElement lastrowcount=rows.get(rows.size()-1);
			System.out.println("last row:"+lastrowcount);
			java.util.List<WebElement> lastrowCols =lastrowcount.findElements(By.tagName("td"));       
	        System.out.println("lastrowCols: " +lastrowCols.size()); 
	        
	        WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);    
	        java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
			System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());
			Thread.sleep(1000);
			lastrowlastColsButtons.get(2).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]")).click();
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//WebElement element = (WebElement) wait.until(ExpectedConditions.alertIsPresent());
			
			/*Set<String> windowids = driver.getWindowHandles(); 
			Iterator<String> iter = windowids.iterator(); 
			String mainWindowId=iter.next(); 
			String popupWindowId=iter.next(); 
			driver.switchTo().window(popupWindowId);
			*/
			/*Alert alt=driver.switchTo().alert();
			alt.accept();
			*/
			Thread.sleep(9000);  
			
	  }
	  
	  @Test(priority=11)
	  public void refreshjob() throws InterruptedException
	  {
		  test = reports.createTest("refreshjob");
		  Thread.sleep(2000);
	      driver.findElement(By.id("refreshbutton")).click();
	      Thread.sleep(3000);
	  }
	 
	  @Test(priority=12)
	 public void logoutTest() throws InterruptedException
	  {
		  driver.findElement(By.id("logoutbutton"));
	     
	      Thread.sleep(3000);
	      }
		  
	
	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {

		String screenShot = CaptureScreenShot.captureScreen(driver);

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL,result.getThrowable());
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Case : " + result.getName() + " has been skipped");
		}
 
		reports.flush();
		driver.close();
	}

	@AfterTest
	public void endTest() {
		
		reports.flush();
	}
	
	

}
