package login;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LatestJD {
	
	@Test
	public void processJd() throws InterruptedException
	{    
		
		System.setProperty("webdriver.chrome.driver","/home/synerzip/Selenium/Jar/chromedriver");
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-infobars"); 
		driver.get("https://orphanqa.rezoomex.in");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("login-username")).sendKeys("sagar");
		driver.findElement(By.id("login-password")).sendKeys("sagar");
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(2000);
		Select technology=new Select(driver.findElement(By.id("selectTechnology")));
		technology.selectByVisibleText("Javaj2ee");
		Thread.sleep(6000);
		driver.findElement(By.id("createjobid")).sendKeys("UIdeveloperJobDescription11");
		Thread.sleep(3000);
		driver.findElement(By.id("jdtextarea")).sendKeys("Total Experience- 3-8 Years Must have- Object Oriented Javascript, HTML, CSS.Should have- Exposure to at least one of the JS framework/ library Backbone/ Angular/ React.Good to have- NodeJs.");
		Thread.sleep(3000);
		driver.findElement(By.id("createjobbuttonId")).click();
		
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
		lastrowlastColsButtons.get(0).click();
		
		System.out.println("Job Process Successfully");
		
		
		
		
		
		
		//System.out.println("Open Job");
        
		
		//lastrowlastColsButtons.get(0).click();
        //Thread.sleep(3000);
        //System.out.println("Job Process Successfully");
	    
       /* WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);    
        java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
		System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());            
		*/
		//lastrowlastColsButtons.get(0).click();
		//Thread.sleep(3000);
		//lastrowlastColsButtons.get(3).click();
		
		//System.out.println("Open Job");
		
		
		//driver.close();
		
		
		
		
		
		
		
		
		//lastrow.getText();
		//System.out.println(lastrow);
		//java.util.List <WebElement> rows=driver.findElements(By.xpath("//*[@id='manageJobs']/table/tbody/tr"));
		//System.out.println("No of rows=" + rows.size());
		//WebElement lastRow=rows.get(rows.size()-1);    
		//java.util.List<WebElement> lastrowCols =lastRow.findElements(By.tagName("td"));       
		//System.out.println("lastrowCols: " +lastrowCols.size());        
		//WebElement lastColoflastRow=lastrowCols.get(lastrowCols.size()-1);       
		////java.util.List<WebElement> lastrowlastColsButtons =lastColoflastRow.findElements(By.tagName("button"));        
		//System.out.println("lastrowlastColsButtons: " +lastrowlastColsButtons.size());            
		//lastrowlastColsButtons.get(lastrowlastColsButtons.size()-2).click();
		
		}
	
}
