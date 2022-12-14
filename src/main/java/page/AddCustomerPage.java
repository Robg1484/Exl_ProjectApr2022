package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElementList
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_NUM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")
	WebElement ADD_CONTACT_HEADER;

	public void validateAddContactPage(String addContactHeader) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(ADD_CONTACT_HEADER.getText(), addContactHeader, "Add Contact Page is not available");
	}

	// Corresponding Method
	String insertedName;

	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandomNum(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void selectCompanyDropdown(String company) {
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}

	public void insertEmail(String email) {
		String insertedEmail = generateRandomNum(9999) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);
	}

	public void insertPhone(String phone) {
		PHONE_NUM_ELEMENT.sendKeys(phone + generateRandomNum(9999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}

	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[3]/td[3]/following-sibling::td[4]/a[2]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";
	
	public void verifyInsertedName() throws InterruptedException {
		Thread.sleep(2000);
		for(int i = 1; i <= 10; i++) {
			String enteredName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(enteredName);
			driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			Assert.assertEquals(enteredName, insertedName, "Entered name does not match");
			break;
		}
	}

}
