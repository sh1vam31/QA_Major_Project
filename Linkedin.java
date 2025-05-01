package Class_Selector_and_driverMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedIn {
     WebDriver driver;
	
	

	
	@Test(priority =1)
	public void Test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		Thread.sleep(3000);
		driver.get("https://in.linkedin.com/");
		WebElement Sign_btn = driver.findElement(By.cssSelector("a[data-test-id=\"home-hero-sign-in-cta\"]"));
		Sign_btn.click();
		
		Thread.sleep(4000);
		
		WebElement Email_btn = driver.findElement(By.id("username"));
		Email_btn.sendKeys("s31122004@gmail.com");
		WebElement Password_btn = driver.findElement(By.id("password"));
		Password_btn.sendKeys("loveuma");
		
		WebElement SignIn_btn = driver.findElement(By.xpath("//button[@class=\"btn__primary--large from__button--floating\"]"));
		SignIn_btn.click();
		
		Thread.sleep(4000);
		
		WebElement Error = driver.findElement(By.cssSelector("span[data-tracking-control-name=\"login_error_create_account\"]"));
		String error = Error.getText();
		Assert.assertEquals(error,"Wrong email or password. Try again or create an account .");
	}
	
	
		
	@Test(priority =2)
	public void test2() throws InterruptedException {
		WebElement Email_btn = driver.findElement(By.id("username"));
		Email_btn.clear();
		Email_btn.sendKeys("sc31122004@gmail.com");
		WebElement Password_btn = driver.findElement(By.id("password"));
		Password_btn.sendKeys("loveuma");
		
		WebElement SignIn_btn = driver.findElement(By.xpath("//button[@class=\"btn__primary--large from__button--floating\"]"));
		SignIn_btn.click();
		
		Thread.sleep(4000);
		
		WebElement profile = driver.findElement(By.cssSelector("p[class=\"profile-card-headline text-body-xsmall mt1\"]"));
		profile.click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.navigate().to("https://www.youtube.com/");
		WebElement Search_btn = driver.findElement(By.cssSelector("input[name=\"search_query\"]"));
		Search_btn.sendKeys("Polaris School of Technology");
		Search_btn.sendKeys(Keys.ENTER);    // try with all keys functions
		
		Thread.sleep(4000);
		
		Search_btn.clear();
		
		
		driver.navigate().back();
		

		
		WebElement Search_btn_2 = driver.findElement(By.cssSelector("input[role=\"combobox\"]"));
		Search_btn_2.sendKeys("QA");
		Search_btn_2.sendKeys(Keys.RETURN);
		
		Thread.sleep(4000);
		
		driver.navigate().refresh();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().to("https://www.selenium.dev/documentation/webdriver/elements/locators/");
		
		Thread.sleep(4000);
		
		WebElement Sel_Search_btn = driver.findElement(By.cssSelector("a[title=\"Finding web elements\"]"));
		Sel_Search_btn.click();
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		Thread.sleep(4000);
		
		
		driver.quit();
		}
	}
