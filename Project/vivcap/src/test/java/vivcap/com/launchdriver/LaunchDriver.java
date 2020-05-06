package vivcap.com.launchdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchDriver {

	WebDriver driver;
	final String chromeDriverPath = "resources/chromedriver.exe";

	// method to launch and initiate chrome driver
	public WebDriver initiateDriver() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
