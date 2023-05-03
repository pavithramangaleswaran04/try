package testNGSample;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelFile {

	
	ChromeDriver driver;
	
	@Test(dataProvider = "testdata")
	public void  DemoProject(String username, String password) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		// driver.get("https://www.browserstack.com/users/sign_in");
		// driver.findElement(By.name("user[login]")).sendKeys(username);
		// driver.findElement(By.name("user[password]")).sendKeys(password);
      //   driver.findElement(By.name("commit")).click();
		 
		 
		 
		/* driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");		
		 driver.findElement(By.name("username")).sendKeys(username);
		 driver.findElement(By.name("password")).sendKeys(password);
		 driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")).click();
		 */
		 
		 driver.get("https://www.facebook.com/");		
		 driver.findElement(By.name("email")).sendKeys(username);
		 driver.findElement(By.name("pass")).sendKeys(password);
		 driver.findElement(By.name("login")).click();
		// driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/span/div/div[1]/div/svg/g/image")).click();
		 //driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/span/div/div[1]/div/svg/g/image")).click();
		 
		// Thread.sleep(5000);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();	
		 Alert a = driver.switchTo().alert();
		 a.accept();
		 Assert.assertTrue(driver.getTitle().matches("BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool"), "Invalid credentials");
		 System.out.println("Login successful");	 
		
	}
	
	
	
	@DataProvider(name="testdata")
	public Object[][] testDataExample(){
	ExcelUtils configuration = new ExcelUtils("C:\\Users\\Admin\\Documents\\Demo File.xlsx");
	int rows = configuration.getRowCount(0);
	Object[][]signin_credentials = new Object[rows][2];

	for(int i=0;i<rows;i++)
	{
		
	signin_credentials[i][0] = configuration.getData(0, i, 0);
	signin_credentials[i][1] = configuration.getData(0, i, 1);
	}
	return signin_credentials;
	}
	
	/*@AfterMethod
	void ProgramTermination() {
	driver.quit();
	}*/
}
