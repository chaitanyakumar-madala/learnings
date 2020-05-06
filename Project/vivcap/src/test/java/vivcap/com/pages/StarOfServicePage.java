package vivcap.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StarOfServicePage {

	@FindBy(className = "postal-code")
	private static WebElement cityTextFiled;

	public static WebElement getCityTextFiled() {
		return cityTextFiled;
	}

	@FindBy(xpath = "//button[@class='button button--branded blue go']")
	private static WebElement goButton;

	public static WebElement getGoButton() {
		return goButton;
	}

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private static WebElement nextButton1;

	public static WebElement getNextButton1() {
		return nextButton1;
	}

	@FindBy(xpath = "//div[text()='Tap']/preceding-sibling::div")
	private static WebElement selectProblem;

	public static WebElement getSelectProblem() {
		return selectProblem;
	}

	@FindBy(xpath = "//div[text()='Replace']/preceding-sibling::div")
	private static WebElement need;

	public static WebElement getNeed() {
		return need;
	}

	@FindBy(xpath = "//div[text()='Leak in a pipe']/preceding-sibling::div")
	private static WebElement problemyouhave;

	public static WebElement getProblemyouhave() {
		return problemyouhave;
	}

	@FindBy(xpath = "//textarea[@class='text-area__textArea___2N_HC input-text styles__textareaV2___2SDY1']")
	private static WebElement problemMessage;

	public static WebElement getProblemMessage() {
		return problemMessage;
	}

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private static WebElement nextbtnafterqstns;

	public static WebElement getNextbtnafterqstns() {
		return nextbtnafterqstns;
	}

	@FindBy(xpath = "//div[text()='On a specific date']/preceding-sibling::div")
	private static WebElement techtime;

	public static WebElement getTechtime() {
		return techtime;
	}

	@FindBy(xpath = "//i[@class='styles__nextIcon___PJOhO icon-next styles__navigationIcon___1OWNL']")
	private static WebElement nextArrow;

	public static WebElement getNextArrow() {
		return nextArrow;
	}

	@FindBy(id = "2fb1107f62b7900a8af4942e0a0532a856dd41ed")
	private static WebElement selectTime;

	public static WebElement getSelectTime() {
		return selectTime;
	}

	public static WebElement getEmailplaceholder() {
		return emailplaceholder;
	}

	@FindBy(id = "54987802773ca222ebc4a9e21e0da21022647489")
	private static WebElement duration;

	public static WebElement getDuration() {
		return duration;
	}

	@FindBy(xpath = "//input[@placeholder='Email address']")
	private static WebElement emailplaceholder;

	@FindBy(xpath = "//div[contains(@class,'commonFormTitle')]")
	private static WebElement questionsElement;

	public static WebElement getQuestionsElement() {
		return questionsElement;
	}

	@FindBy(xpath = "//label[@class='styles__itemV2___1Vo1Z styles__itemBase___rDyIf']")
	private static WebElement randomAnswer;

	public static WebElement getRandomAnswer() {
		return randomAnswer;
	}
}
