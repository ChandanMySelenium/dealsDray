package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class prexoBulkOrders_page {

	@FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root css-i44wyl']/descendant::input")
	private WebElement btnChooseFile;
	
	@FindBy(xpath = "//button[text()='Import']")
	private WebElement btnImport;
	
	@FindBy(xpath = "//button[text()='Validate Data']")
	private WebElement btnValidateData;
	
	public prexoBulkOrders_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnChooseFileBtn() {
		this.btnChooseFile.click();
	}
	
	public void clickOnImportBtn() {
		this.btnImport.click();
	}
	
	public void clickOnValidatedataBtn() {
		this.btnValidateData.click();
	}
	
	public void setChooseFile(String data) {
		this.btnChooseFile.sendKeys(data);
	}
}
