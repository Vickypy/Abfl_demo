package abfl_QaServer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass  {
	WebDriver driver;
	
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");	
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@BeforeMethod
	public void openUrl() {
		driver.get("https://abfl-qa.credable.in/");
		driver.manage().deleteAllCookies();
	}

//	Generate Random Number --------
	@Test
	public void randomNumber() {
		RandomPhoneNumberGenerator numberGenerator = new RandomPhoneNumberGenerator();
		String pnumber = (numberGenerator.generateRandomPhoneNumber());
		System.out.println(pnumber);
	}
// Generate Random Pan number--------

	@Test
	public void randomPan() {
		randomPan pan = new randomPan();
		String PanNumber = (pan.generateRandomPAN());
		System.out.println(PanNumber);

	}

	@Test
	public void randomEmail() {
		randomEmail mail = new randomEmail();
		String abfl_mail = (mail.generateRandomEmail());
		System.out.println(abfl_mail);
	}
}
