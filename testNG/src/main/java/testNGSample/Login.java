package testNGSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	ChromeDriver driver;

     @Test(dataProvider = "testdata")
	public void check(String email, String password) {
		
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.facebook.com/");
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.linkText("Login")).click();
		 driver.findElement(By.id("input-email")).sendKeys(email);
		 driver.findElement(By.id("input-password")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@value='Login']"));
	//	 Assert.assertTrue(driver.findElement(By.linkText("")));


	}
    
     
}
