package vivcap.com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import vivcap.com.launchdriver.LaunchDriver;

public class StarofServiceUtilities extends LaunchDriver {
	public void quitDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}

	public void waitForElementToBeEnabled(WebElement e, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		wait.until((driverr) -> e.isEnabled());
		return;
	}

	public static void takeScreenShot(WebDriver driver) throws IOException {
		String ssnamee = "screenshots/" + java.time.LocalDateTime.now() + ".png";
		String ssname = ssnamee.replace(":", "!");
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(ssname);
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public String seconddayfromNow() {
		String day = null;
		String month = null;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			day = "Sunday";
			break;
		case 2:
			day = "Monday";
			break;
		case 3:
			day = "Tuesday";
			break;
		case 4:
			day = "Wednesday";
			break;
		case 5:
			day = "Thursday";
			break;
		case 6:
			day = "Friday";
			break;
		case 7:
			day = "Saturday";
			break;

		}
		switch (calendar.get(Calendar.MONTH) + 1) {
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		}

		String next2day = day + ", " + month + " " + calendar.get(Calendar.DATE) + ", " + calendar.get(Calendar.YEAR);
		return next2day;
	}

	public boolean leapyearcheck() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int year = calendar.get(Calendar.YEAR);
		boolean leap = false;

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				// year is divisible by 400, hence the year is a leap year
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;

		if (leap)
			return true;
		else
			return false;
	}

	public Map<String, String> questions() throws IOException {
		String path = "resources/questions.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		Map<String, String> dataMap = new HashMap<String, String>();
		for (int i = 0; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			Cell valueCell = row.getCell(1);
			Cell keyCell = row.getCell(0);
			String value = valueCell.getStringCellValue().trim();
			String key = keyCell.getStringCellValue().trim();
			dataMap.put(key, value);

		}
		workbook.close();
		return dataMap;
	}

}
