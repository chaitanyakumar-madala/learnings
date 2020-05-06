package vivcap.com.testcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vivcap.com.launchdriver.LaunchDriver;
import vivcap.com.pageactions.StarOfServicePageActions;
import vivcap.com.utilities.StarofServiceUtilities;

public class StarofServiceTests {

	WebDriver driver;
	LaunchDriver launchDriver = new LaunchDriver();
	StarofServiceUtilities starUtilities = new StarofServiceUtilities();

	// TestNG class ,here we initiate brower
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver = launchDriver.initiateDriver();
	}

	// Test case starts here
	@Test
	public void startTestcase() throws IOException, InterruptedException {
		FileReader reader = new FileReader("resources/testdata.properties");
		Properties p = new Properties();
		p.load(reader);

		// can pass data from various sources
		final String url = "https://www.starofservice.in/dir/telangana/hyderabad/hyderabad/plumbing#/";
		final String cityname = p.getProperty("city");
		final String problem = p.getProperty("problem");
		final String need = p.getProperty("need");
		final String problemyouhave = p.getProperty("problemyouhave");
		final String message = "Test message";
		final String datemessage = p.getProperty("datemessage");

		// pagefactory to pass driver to actions class
		PageFactory.initElements(driver, StarOfServicePageActions.class);

		// launch URL
		StarOfServicePageActions.launchURL(url);

		// Enter City name
		StarOfServicePageActions.enterCity(cityname);

		// click Go
		StarOfServicePageActions.clickGo();

		// click Next
		StarOfServicePageActions.clickNextButton();

		// select Problem
		StarOfServicePageActions.slectProblems(problem);

		// select need
		StarOfServicePageActions.selectNeed(need);

		// select problemyouhave
		StarOfServicePageActions.problemYouhave(problemyouhave);

		// Enter message to technician
		StarOfServicePageActions.plumberneedstoKnow(message);

		// select type of date for technician
		StarOfServicePageActions.technicianDate(datemessage);

		// Selcte date for technician
		StarOfServicePageActions.requiredDate();

		// Select time
		StarOfServicePageActions.selectTime();

		// wait for email screen
		StarOfServicePageActions.waitForEmailScreen();
	}

	// After class drivers quits here
	@AfterClass
	public void closeDriver() {
		starUtilities.quitDriver(driver);
	}

}
