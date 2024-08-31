package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class prexoOrder_page {

	@FindBy(xpath = "//span[text()='Orders']")
	private WebElement btnOrders;
	
	@FindBy(xpath = "//span[text()='Bad Orders']")
	private WebElement btnBadOrders;
	
	@FindBy(xpath = "//button[text()='Add Bulk Orders']")
	private WebElement btnAddBulkOrders;
	
	public prexoOrder_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOrdersBtn() {
		this.btnOrders.click();
	}
	
	public void clickOnBadOrdersBtn() {
		this.btnBadOrders.click();
	}
	
	public void clickOnAddBulkOrdersBtn() {
		this.btnAddBulkOrders.click();
	}
}
