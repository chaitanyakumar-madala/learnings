package vivcap.com.testcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
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

	// TestNG class ,here we initiate browser
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

		// read questions from excel
		HashMap<String, String> questions = new HashMap<String, String>();
		questions.putAll(starUtilities.questions());

		// can pass data from various sources
		final String url = "https://www.starofservice.in/dir/telangana/hyderabad/hyderabad/plumbing#/";
		final String cityname = p.getProperty("city");
		final String problem = p.getProperty("problem");
		final String need = p.getProperty("need");
		final String problemyouhave = p.getProperty("problemyouhave");
		final String message = "Test message";
		final String datemessage = p.getProperty("datemessage");

		PageFactory.initElements(driver, StarOfServicePageActions.class);// pagefactory to pass driver to actions class
		StarOfServicePageActions.launchURL(url);// launch URL
		StarOfServicePageActions.enterCity(cityname);// Enter City name
		StarOfServicePageActions.clickGo();// click Go
		StarOfServicePageActions.clickNextButton();// click Next
		StarOfServicePageActions.answerToQuestion(questions, message);// Select questions and answers and enter messgae
																		// to technician

		/*
		 * Static methods can select only questions which are already present
		 * StarOfServicePageActions.slectProblems(problem);//select Problem
		 * StarOfServicePageActions.selectNeed(need);// select need
		 * StarOfServicePageActions.problemYouhave(problemyouhave); // select
		 * problemyouhave StarOfServicePageActions.plumberneedstoKnow(message);//
		 * 
		 */

		StarOfServicePageActions.technicianDate(datemessage);// select technican date message
		StarOfServicePageActions.requiredDate();// Selcte date for technician
		StarOfServicePageActions.selectTime();// Select time
		StarOfServicePageActions.waitForEmailScreen();// wait for email screen
	}

	@AfterClass
	public void closeDriver() {
		starUtilities.quitDriver(driver);// quits driver
	}

}
