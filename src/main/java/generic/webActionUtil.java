package generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class webActionUtil {

	WebDriver driver;
	WebDriverWait wait;

	public webActionUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/* method to capture screenshot */
	public void captureScreenshot(String scriptName) {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(baseTest.UserDir + "\\screenshot\\" + scriptName + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void captureFullpageScreenshot(String scriptName) {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);

        try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(baseTest.UserDir + "\\screenshot\\" + scriptName +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Shutterbug.shootPage(driver, Capture.FULL_SCROLL, true).save(baseTest.UserDir + "\\screenshot\\" + scriptName +".png");
	}
}
