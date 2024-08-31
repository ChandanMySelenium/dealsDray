package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class prexoHome_page {

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement btnDashBoard;
	
	@FindBy(xpath = "//span[text()='Order']")
	private WebElement btnOrder;
	
	@FindBy(xpath = "//span[text()='menu']")
	private WebElement btnMenu;
	
	public prexoHome_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDashboardBtn() {
		this.btnDashBoard.click();
	}
	
	public void clickOnOrderBtn() {
		this.btnOrder.click();
	}
	
	public void clickOnMenuBtn() {
		this.btnMenu.click();
	}
}
