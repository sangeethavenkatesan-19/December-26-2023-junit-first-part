package Phase2_26MondayOne;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AmazonLinkVerification {

	// step1: formulate a test domain url & driver path
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/windows/chromedriver.exe";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();

		// step4: launch browser
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit(); // the quit() method closes all browser windows and ends the WebDriver session.
	}

	@Test
	@DisplayName("Should verify Amazon BestSellers")
	public void linkTest1() throws InterruptedException {
		WebElement link = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));

		link.click();

		// add delay
		Thread.sleep(1000);

		String expectedTitle = "Amazon.in Bestsellers: The most popular items on Amazon";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	@DisplayName("Should verify Amazon Deals")
	public void linkTest2() throws InterruptedException {
		WebElement link = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)"));

		link.click();

		// add delay
		Thread.sleep(1000);

		String expectedTitle = "Amazon.in - Deals";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
}