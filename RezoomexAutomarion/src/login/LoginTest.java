package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

//import extent.ExtentManager;

public class LoginTest
{
	//ExtentReports rep = ExtentManager.getInstance();
	//ExtentTest test;
 public WebDriver driver;
      @BeforeClass
	  public void beforeMethod() throws InterruptedException 
	  {
		   System.setProperty("webdriver.chrome.driver","/home/synerzip/Selenium/Jar/chromedriver");
		   driver=new ChromeDriver();
		   ChromeOptions options = new ChromeOptions(); 
		   options.addArguments("disable-infobars"); 
		   driver.get("https://orphanqa.rezoomex.in");
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  }
      @AfterClass
	  public void afterMethod() throws InterruptedException
	  {
		  Thread.sleep(2000);
		   
		   driver.quit();
	  }
	
	 
	  @Test(priority=1)
	  public void pageTitleTest() 
	  {    
		  //ExtentReports rep = ExtentManager.getInstance();
		  //test=rep.startTest("pageTitleTest");
	       //test.log(LogStatus.INFO, "pageTitleTest");
	       
		   driver.manage().window().maximize();
		   String actual_title=driver.getTitle();
		   String expected_title="RezoomexApplicantTrackingSystem";
		   System.out.println(actual_title);
		   System.out.println(expected_title);
		   Assert.assertEquals(actual_title, expected_title);
		   System.out.println("TestCaseForPageTitlePass");
		    //test.log(LogStatus.FAIL, "Test Fails");
		   // rep.endTest(test);
		   //rep.flush();
		   
}
	  @DataProvider
	  public Object getData()
	  {
	  Object data[][]=new Object[1][2];
	  data[0][0]="sagar";
	  data[0][1]="sagar";
	  
	  /*data[1][0]="admin";
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
	  data[7][1]="password";*/
	  
	  
	  
	  return data;
	  }
	  @Test(dataProvider="getData",priority=2)
	  public void loginTest(String username,String password) throws InterruptedException
	  {
		   //ExtentReports rep = ExtentManager.getInstance();
	       String expectedButtonCaption="Login";
		   String actualButtonCaption=driver.findElement(By.className("form-group")).getText();
		   System.out.println(actualButtonCaption);
		   System.out.println(expectedButtonCaption);
		   Assert.assertEquals(actualButtonCaption,expectedButtonCaption );
		   System.out.println("TestCaseForButtonCaptionPass");
		   driver.findElement(By.id("login-username")).sendKeys(username);
		   driver.findElement(By.id("login-password")).sendKeys(password);
		   driver.findElement(By.id("loginBtn")).click();
		   System.out.println("Login Successful");
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   
	  
}
	  @Test(priority=3)
	  public void automatedjob() throws InterruptedException
	  {
		  //driver.findElement(By.name("company")).sendKeys("synerzip");
		  Thread.sleep(2000);
		 // driver.findElement(By.id("company-aboutus")).click();
		  Select jobtitle=new Select(driver.findElement(By.id("selectJob")));
		  jobtitle.selectByIndex(0);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  Select technology=new Select(driver.findElement(By.id("selectTechnology")));
		  technology.selectByIndex(0);
		  driver.findElement(By.id("createjobbuttonId"));
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
	 }
	  @Test(priority=11)
	  public void logoutTest()
	  {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  	driver.findElement(By.id("logoutbutton"));
	  }
	  @Test(priority=4)
	  public void manualjob()
	  {
		  Select jobtitle=new Select(driver.findElement(By.id("selectJob")));
		  jobtitle.selectByIndex(0);
		  Select technology=new Select(driver.findElement(By.id("selectTechnology")));
		  technology.selectByIndex(0);
		  driver.findElement(By.id("createjobid")).sendKeys("UIDeveloper");
		  //driver.findElement(By.xpath("//*[@id="JobDescriptionForm"]/div/div[7]/textarea"));
		  driver.findElement(By.id("jdtextarea")).sendKeys("Total Experience- 3-8 Years Must have- Object Oriented Javascript, HTML, CSS.Should have- Exposure to at least one of the JS framework/ library Backbone/ Angular/ React.Good to have- NodeJs.");
		  driver.findElement(By.id("createjobbuttonId"));
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
	  }
	  @Test(priority=5)
	  public void ProcessJob()
	  {
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
		 driver.findElement(By.id("processjdid")).getText();
		
	  }
	  @Test(priority=6)
	  public void deletejob()
	  {
		  driver.findElement(By.id("deletejobid")).getText();
	  }
	  
	  @Test(priority=7)
	  public void trackjob()
	  {
		  
		  driver.findElement(By.id("trackjdid"));
	  }
	  @Test(priority=8)
	  public void downloadtracker()
	  {
		driver.findElement(By.id("downloadjdid"));
	  }
	  
	  @Test(priority=9)
	  public void openjob()
	  {
		  driver.findElement(By.id("openjdtabid"));
	  }
	  @Test(priority=10)
	  public void Refreshjob()
	  {
	  driver.findElement(By.id("refreshbutton"));
	  }
	  
}
  


