package abfl_QaServer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicityWait {
	WebDriver driver;
	
	public ExplicityWait(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementVisibility(By Locator, Duration i) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

}
