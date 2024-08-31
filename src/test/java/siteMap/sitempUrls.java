package siteMap;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import dataproviders.sitemapDataprovider;
import generic.baseTest;
import pages.initilizesPages;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class sitempUrls extends baseTest{

	@Test(dataProviderClass = sitemapDataprovider.class, dataProvider = "devicesAndResolutions")
	public void uiTesting(String device, int width, int height) {
		driver.get(data.getProperty("sitemapurl"));

		initilizesPages pages = new initilizesPages(driver);
		List<WebElement> urls = pages.sitemap.getUrls();
		
		for (int i = 0; i < urls.size(); i++) {
			urls.get(i).click();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String siteName = url.substring(0, url.length()-1);
			System.out.println(siteName);
			Dimension d = new Dimension(width, height);
			driver.manage().window().setSize(d);
			ZonedDateTime zonedDateTime = ZonedDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss z");
			String formattedZonedDateTime = zonedDateTime.format(formatter);
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

	        try {
				ImageIO.write(screenshot.getImage(), "PNG", new File(baseTest.UserDir + "\\screenshot\\" + device+ " " + width + " X " + height + " " + formattedZonedDateTime +".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        if(i == 4) {
	        	break;
	        }
	        
	        driver.navigate().back();
		}
	}
}
