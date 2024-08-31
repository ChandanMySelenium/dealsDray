package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sitemap_page {

	@FindBy(xpath = "(//td)/a")
	private List<WebElement> url;

	public sitemap_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getUrls() {
		return this.url;
	}
}
