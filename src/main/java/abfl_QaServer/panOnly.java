package abfl_QaServer;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.interactions.Actions;


public class panOnly {
	WebDriver driver;
	String pnumber;
	String PanNumber;
	String abfl_mail;
	ExplicityWait expWait = new ExplicityWait(driver);

	@BeforeClass(alwaysRun = true)
	public void setupDriver() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Files\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");	
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	/**
	 */
	@BeforeMethod
	public void openUrl() {
		driver.get("https://abfl-qa.credable.in/");
		driver.manage().deleteAllCookies();
	}

//	Generate Random Number --------
	@Test
	public void randomNumber() {
		RandomPhoneNumberGenerator numberGenerator = new RandomPhoneNumberGenerator();
		pnumber = (numberGenerator.generateRandomPhoneNumber());
		System.out.println(pnumber);
	}
// Generate Random Pan number--------

	@Test
	public void randomPan() {
		randomPan pan = new randomPan();
		PanNumber = (pan.generateRandomPAN());
		System.out.println(PanNumber);

	}

	@Test
	public void randomEmail() {
		randomEmail mail = new randomEmail();
		abfl_mail = (mail.generateRandomEmail());
		System.out.println(abfl_mail);
	}

	@Test
	public void singUpPage() throws InterruptedException {
//		driver.findElement(By.id("username")).sendKeys("9699394021");
			driver.findElement(By.id("username")).sendKeys(pnumber);
		driver.findElement(By.className("send__otp__button")).click();
		Thread.sleep(1000);
//		expWait.waitForElementVisibility(By.id("loginOtp1"), Duration.ofSeconds(10));
//		Thread.sleep(4000);
		driver.findElement(By.id("loginOtp1")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.className("login__button")).click();
//		Thread.sleep(1000);
		By panEle = By.id("pan");
		expWait.waitForElementVisibility(panEle, Duration.ofSeconds(15));
//		Start Signup Page 1 ------ 
//		driver.findElement(By.id("pan")).sendKeys(""); // Use for specific pan

		driver.findElement(By.id("pan")).sendKeys(PanNumber);// Using Random PAN
//		driver.findElement(By.id("pan")).sendKeys("SOLEP025R");

		driver.findElement(By.id("username")).sendKeys("Vicky SHarma");

//		Select Gender --
		driver.findElement(By.xpath("//div[@class='drop_down_option search_field_on_box ng-star-inserted']")).click();
		List<WebElement> selectGender = driver.findElements(By.xpath(
				"//div[@class='range__selection__options single__selection']/div[@class='range__selection__option ng-star-inserted']"));
		WebElement selectedGender = selectGender.stream().filter(gender -> gender.getText().equalsIgnoreCase("Male"))
				.findFirst().orElse(null);
		selectedGender.click();
		driver.findElement(By.id("email")).sendKeys(abfl_mail);

//		 Scroll Down into element --
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//button[@class='submit_btn disabled']"))).perform();

//		select DOB ---
		driver.findElement(By.xpath("//input[@class='ng-tns-c52-2 p-inputtext p-component ng-star-inserted']")).click();
		driver.findElement(By.xpath("//button[@class='p-datepicker-year p-link ng-tns-c52-2 ng-star-inserted']"))
				.click();

//		Select Year ---
		List<WebElement> selectyear = driver.findElements(
				By.xpath("//span[@class='p-ripple p-element p-yearpicker-year ng-tns-c52-2 ng-star-inserted']"));
		WebElement year = selectyear.stream().filter(years -> years.getText().equalsIgnoreCase("2000")).findFirst()
				.orElse(null);
		year.click();
//		Select Month
		List<WebElement> selectmonth = driver.findElements(
				By.xpath("//span[@class='p-ripple p-element p-monthpicker-month ng-tns-c52-2 ng-star-inserted']"));
		WebElement month = selectmonth.stream().filter(months -> months.getText().equalsIgnoreCase("Jan")).findFirst()
				.orElse(null);
		month.click();
//		Select Date
		List<WebElement> selectDate = driver
				.findElements(By.xpath("//span[@class='p-ripple p-element ng-tns-c52-2 ng-star-inserted']"));
		WebElement date = selectDate.stream().filter(dates -> dates.getText().equalsIgnoreCase("1")).findFirst()
				.orElse(null);
		date.click();

		driver.findElement(By.xpath("//button[@class='submit_btn']")).click();

//		-------------------------------Signup 2 Page only Pan Journey ------------------

		driver.findElement(By.id("entityName")).sendKeys("Toooatdd");



// 		Select Business Type 
		driver.findElement(By.xpath("(//div[@class='drop_down_option search_field_on_box ng-star-inserted'])[1]"))
				.click();
		List<WebElement> selectBusiness = driver
				.findElements(By.xpath("//div[@class='range__selection__option ng-star-inserted']/div"));
		WebElement Business = selectBusiness.stream().filter(busin -> busin.getText().equalsIgnoreCase("Manufacturer"))
				.findFirst().orElse(null);
		Business.click();

//		Select Industry Type --
		driver.findElement(By.xpath("(//div[@class='drop_down_option search_field_on_box ng-star-inserted'])[2]"))
				.click();
		List<WebElement> selectIndustry = driver
				.findElements(By.xpath("//div[@class='range__selection__option ng-star-inserted']/div"));
		WebElement industry = selectIndustry.stream().filter(indus -> indus.getText().equalsIgnoreCase("Advertising"))
				.findFirst().orElse(null);
		industry.click();

//	----------------------------------UDYAM NUMBER -------------------------------------------------4
		driver.findElement(By.id("udyam1")).sendKeys("UDYAM");
		driver.findElement(By.id("udyam2")).sendKeys("PB");
		driver.findElement(By.id("udyam3")).sendKeys("12");
		driver.findElement(By.id("udyam4")).sendKeys("0001234");
//		
		driver.findElement(By.xpath("//button[@class='submit_btn']")).click();

//		Singup 3 ----------------------------------------

		driver.findElement(By.id("addressLineOne")).sendKeys("Hoshiyarpur Sector 51 Noida");
		driver.findElement(By.id("addressLineTwo")).sendKeys("Gali No 2/2 House No 2");
		driver.findElement(By.id("pinCode")).sendKeys("201301");
		driver.findElement(By.id("city")).sendKeys("Noida");

//		select State for address line 1 - office address
		driver.findElement(By.xpath("(//div[@class='drop_down_option search_field_on_box ng-star-inserted'])[1]"))
				.click();
		List<WebElement> selectState = driver
				.findElements(By.xpath("//div[@class='range__selection__option ng-star-inserted']/div"));
		WebElement state = selectState.stream().filter(states -> states.getText().equalsIgnoreCase("Uttar Pradesh"))
				.findFirst().orElse(null);
		state.click();

//		fill Residence Address ---

		driver.findElement(By.id("residenceAddressLineOne")).sendKeys("WTT Tower Sector 16");
		driver.findElement(By.id("residenceAddressLineTwo")).sendKeys("Near Metro sector 16");
		driver.findElement(By.id("residencePinCode")).sendKeys("201301");
		driver.findElement(By.id("residenceCity")).sendKeys("Noida");
//		Select Residence Address --------
		driver.findElement(By.xpath("(//div[@class='drop_down_option search_field_on_box ng-star-inserted'])[2]"))
				.click();
		List<WebElement> selectResidenceState = driver
				.findElements(By.xpath("//div[@class='range__selection__option ng-star-inserted']/div"));
		WebElement residenceState = selectResidenceState.stream()
				.filter(resi -> resi.getText().equalsIgnoreCase("Uttar Pradesh")).findFirst().orElse(null);
		residenceState.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='submit_btn']")).click();
		Thread.sleep(5000);
		driver.close();
		

	}

}
