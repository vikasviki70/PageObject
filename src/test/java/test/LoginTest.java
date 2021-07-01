package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Login;
import locators.HomePage;
import locators.Login;


public class LoginTest{
	WebDriver driver;
	Login objLogin;
	HomePage objHomePage;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	}
	
	
	@Test
	public void test_Home_Page_Appear_Correct() {
		objLogin=new Login(driver);
		//login page title verification
		String loginPageMessage = objLogin.getLoginTitle();
		System.out.println("loginPageMessage");
		Assert.assertTrue(loginPageMessage.contains("Please enter your username and password."));
		
		objLogin.loginToApplication("tarun", "Abcd@1234");
		objHomePage=new HomePage(driver);
		//verify Home Page
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("Tarun"));
	}

}
