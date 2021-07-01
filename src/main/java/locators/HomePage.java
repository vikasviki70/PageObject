package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By homePageUserName = By.xpath("//div[@id='WelcomeContent']");

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//get username from HomePage
	public String getHomePageDashboardUserName() {
		return driver.findElement(homePageUserName).getText();
	}
}
