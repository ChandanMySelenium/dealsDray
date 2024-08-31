package siteMap;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.baseTest;
import pages.initilizesPages;

public class AutomationTest02 extends baseTest {

	@Test
	public void AutomationTest02_script() {
		driver.get(data.getProperty("demodealsdrayurl"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		initilizesPages pages = new initilizesPages(driver);
		pages.prexLogin.setUserNamse(data.getProperty("username"));
		pages.prexLogin.setPsw(data.getProperty("password"));
		pages.prexLogin.clickOnLoginBtn();
		pages.prexoHome.clickOnOrderBtn();
		pages.prexoOrder.clickOnOrdersBtn();
		pages.prexoOrder.clickOnAddBulkOrdersBtn();
		pages.prexoHome.clickOnMenuBtn();
		pages.prexoBulkOrders.setChooseFile("C:\\Users\\DELL\\Downloads\\demo-data.xlsx");
		pages.prexoBulkOrders.clickOnImportBtn();
		pages.prexoBulkOrders.clickOnValidatedataBtn();
		try {
			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println("There is not alter present");
		}
		
		Alert a = driver.switchTo().alert();
		a.accept();
		actionUtil.captureFullpageScreenshot("bulkfileupload");
	}
}
