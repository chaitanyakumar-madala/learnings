package vivcap.com.pageactions;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import vivcap.com.pages.StarOfServicePage;
import vivcap.com.utilities.StarofServiceUtilities;

public class StarOfServicePageActions extends StarOfServicePage {

	static WebDriver driver;
	static StarofServiceUtilities starUtils = new StarofServiceUtilities();

	public StarOfServicePageActions(WebDriver driver) {
		StarOfServicePageActions.driver = driver;
	}

	// launche URL method
	public static void launchURL(String url) throws IOException {
		try {
			driver.get(url);
			starUtils.waitForElementToBeEnabled(getGoButton(), driver);
			StarofServiceUtilities.takeScreenShot(driver);
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// Enters city method
	public static void enterCity(String cityname) throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(getGoButton(), driver);
			getCityTextFiled().clear();
			getCityTextFiled().sendKeys(cityname);

		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

	}

	// click on go button method
	public static void clickGo() throws IOException {
		try {
			StarofServiceUtilities.takeScreenShot(driver);
			getGoButton().click();

		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// click on next button
	public static void clickNextButton() throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(getNextButton1(), driver);
			StarofServiceUtilities.takeScreenShot(driver);
			getNextButton1().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	public static void answerToQuestion(HashMap<String, String> questions, String message) throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(getQuestionsElement(), driver);
			while (!questions.get("qstn").equals(getQuestionsElement().getText().trim())) {
				boolean randomQtn = true;
				Iterator<String> it = questions.keySet().iterator();
				randomQtn = true;
				starUtils.waitForElementToBeEnabled(getQuestionsElement(), driver);
				while (it.hasNext()) {
					String key = it.next();
					if (key.equals(getQuestionsElement().getText().trim())) {

						starUtils.waitForElementToBeEnabled(driver.findElement(By.xpath("//label/input[@name='" + key
								+ "']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
								+ questions.get(key) + "')]")), driver);
						driver.findElement(By.xpath("//label/input[@name='" + key
								+ "']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
								+ questions.get(key) + "')]")).click();
						StarofServiceUtilities.takeScreenShot(driver);
						getNextbtnafterqstns().click();
						it.remove();
						randomQtn = false;

					}
				}
				if (randomQtn) {
					starUtils.waitForElementToBeEnabled(getQuestionsElement(), driver);
					starUtils.waitForElementToBeEnabled(getRandomAnswer(), driver);
					//click on answers for questions added
					getRandomAnswer().click();

				}
			}
			if (questions.get("qstn").equals(getQuestionsElement().getText().trim())) {
				try {
					starUtils.waitForElementToBeEnabled(getProblemMessage(), driver);
					getProblemMessage().clear();
					getProblemMessage().sendKeys(message);
					StarofServiceUtilities.takeScreenShot(driver);
					clickNextButton();
				} catch (Exception e) {
					StarofServiceUtilities.takeScreenShot(driver);
					e.printStackTrace();
					throw e;
				}
			}
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;
		}
	}

	public static void slectProblems(String slectProblem) throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(driver.findElement(By.xpath(
					"//label/input[@name='The problems are to do with which of the following things?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ slectProblem + "')]")),
					driver);
			driver.findElement(By.xpath(
					"//label/input[@name='The problems are to do with which of the following things?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ slectProblem + "')]"))
					.click();
			// getSelectProblem().click();
			StarofServiceUtilities.takeScreenShot(driver);
			getNextbtnafterqstns().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// select problem here
	public static void selectNeed(String need) throws Exception {
		try {
			starUtils.waitForElementToBeEnabled(driver.findElement(By.xpath(
					"//label/input[@name='What do you need done?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ need + "')]")),
					driver);
			driver.findElement(By.xpath(
					"//label/input[@name='What do you need done?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ need + "')]"))
					.click();
			// getNeed().click();
			StarofServiceUtilities.takeScreenShot(driver);
			getNextButton1().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// select what do you have
	public static void problemYouhave(String problemyouhave) throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(driver.findElement(By.xpath(
					"//label/input[@name='What problem(s) do you have?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ problemyouhave + "')]")),
					driver);
			driver.findElement(By.xpath(
					"//label/input[@name='What problem(s) do you have?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ problemyouhave + "')]"))
					.click();
			// getProblemyouhave().click();
			StarofServiceUtilities.takeScreenShot(driver);
			getNextButton1().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// select problem that technician need to know
	public static void plumberneedstoKnow(String message) throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(getProblemMessage(), driver);
			getProblemMessage().clear();
			getProblemMessage().sendKeys(message);
			StarofServiceUtilities.takeScreenShot(driver);
			clickNextButton();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// click on next button after all questions
	public static void clickonNextafterqstns() throws IOException {
		try {
			getNextbtnafterqstns().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// select when do you require technician
	public static void technicianDate(String datemsg) throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(driver.findElement(By.xpath(
					"//label/input[@name='When do you require plumbing?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ datemsg + "')]")),
					driver);
			driver.findElement(By.xpath(
					"//label/input[@name='When do you require plumbing?']/parent::label/div[@class='styles__iconContainer___1sNdo']/following::div[contains(text(),'"
							+ datemsg + "')]"))
					.click();
			// getTechtime().click();
			StarofServiceUtilities.takeScreenShot(driver);
			getNextButton1().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// select date from calendar
	public static void requiredDate() throws IOException {
		StarofServiceUtilities star = new StarofServiceUtilities();
		try {
			Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
			if (calendar.get(Calendar.MONTH) + 1 == 1 || calendar.get(Calendar.MONTH) + 1 == 3
					|| calendar.get(Calendar.MONTH) + 1 == 5 || calendar.get(Calendar.MONTH) + 1 == 7
					|| calendar.get(Calendar.MONTH) + 1 == 8 || calendar.get(Calendar.MONTH) + 1 == 10
					|| calendar.get(Calendar.MONTH) + 1 == 12) {
				{
					if (calendar.get(Calendar.DATE) == 30 || calendar.get(Calendar.DATE) == 31) {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						getNextArrow().click();
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					} else {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					}
				}
				if (calendar.get(Calendar.MONTH) + 1 == 4 || calendar.get(Calendar.MONTH) + 1 == 6
						|| calendar.get(Calendar.MONTH) + 1 == 9 || calendar.get(Calendar.MONTH) + 1 == 11) {
					if (calendar.get(Calendar.DATE) == 29 || calendar.get(Calendar.DATE) == 30) {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						getNextArrow().click();
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					} else {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					}
				}
				if (calendar.get(Calendar.MONTH) + 1 == 2 && star.leapyearcheck() == true) {
					if (calendar.get(Calendar.DATE) == 28 || calendar.get(Calendar.DATE) == 29) {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						getNextArrow().click();
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					} else {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					}
				}
				if (calendar.get(Calendar.MONTH) + 1 == 2 && star.leapyearcheck() == false) {
					if (calendar.get(Calendar.DATE) == 27 || calendar.get(Calendar.DATE) == 28) {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						getNextArrow().click();
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					} else {
						starUtils.waitForElementToBeEnabled(
								driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")),
								driver);
						driver.findElement(By.xpath("//button[@aria-label='" + star.seconddayfromNow() + "']")).click();
						StarofServiceUtilities.takeScreenShot(driver);
					}
				}
			}
			getNextButton1().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// select time
	public static void selectTime() throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(getSelectTime(), driver);
			Select time = new Select(getSelectTime());
			time.selectByIndex(2);
			getDuration().sendKeys("4");
			StarofServiceUtilities.takeScreenShot(driver);
			getNextButton1().click();
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			throw e;

		}
	}

	// wait for the email screen to appear
	public static void waitForEmailScreen() throws IOException {
		try {
			starUtils.waitForElementToBeEnabled(getEmailplaceholder(), driver);
			getEmailplaceholder().isDisplayed();
			StarofServiceUtilities.takeScreenShot(driver);
		} catch (Exception e) {
			StarofServiceUtilities.takeScreenShot(driver);
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}
}
