package pages;

import org.openqa.selenium.WebDriver;

public class initilizesPages {

	public sitemap_page sitemap;
	public prexLogin_page prexLogin;
	public prexoHome_page prexoHome;
	public prexoOrder_page prexoOrder;
	public prexoBulkOrders_page prexoBulkOrders;
	
	public initilizesPages(WebDriver driver) {
		sitemap = new sitemap_page(driver);
		prexLogin = new prexLogin_page(driver);
		prexoHome = new prexoHome_page(driver);
		prexoOrder = new prexoOrder_page(driver);
		prexoBulkOrders = new prexoBulkOrders_page(driver);
	}
}
