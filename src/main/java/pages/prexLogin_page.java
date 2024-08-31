package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class prexLogin_page {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement tbUserName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement tbPsw;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;
	
	public prexLogin_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserNamse(String data) {
		this.tbUserName.sendKeys(data);
	}
	
	public void setPsw(String data) {
		this.tbPsw.sendKeys(data);
	}
	
	public void clickOnLoginBtn() {
		this.btnLogin.click();
	}
}
