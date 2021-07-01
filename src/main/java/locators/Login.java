package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	By user=By.name("username");
	By password=By.name("password");
	By login=By.name("signon");
	By message=By.xpath("//p[contains(text(),'Please enter your')]");
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}

	//setusername in textbox
	public void setUserName(String strUserName) {
		driver.findElement(user).sendKeys(strUserName);
	}
	
	//setpassword in textbox
	public void setPassword(String strPassword) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strPassword);
	}
	
	//click on the login button
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	//get message of login page
	public String getLoginTitle() {
		return driver.findElement(message).getText();
	}
	
	//method to login
	public void loginToApplication(String strUserName, String strPassword) {
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}
	
	
}
