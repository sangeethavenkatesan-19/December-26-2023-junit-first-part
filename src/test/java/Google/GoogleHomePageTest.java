package Google;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class GoogleHomePageTest {

	//step 1: formulate a test domain url and driver path
	String siteUrl = "https://www.google.com/";
	String driverPath = "drivers/windows/chromedriver.exe";	
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", driverPath);

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
	@RepeatedTest(value = 3 , name = RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("Should validate Google Homepage source url")
	public void testAmazonHomePageSourceUrl() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
}
