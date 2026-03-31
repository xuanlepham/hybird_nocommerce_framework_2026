package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.RegisterPageUi;


public class RegisterPageObject extends BasePage {
    private WebDriver driver;
    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToMaleRadio() {
        onlyWaitForElementClickable(driver, RegisterPageUi.GENDER_MALE_RADIO_BUTTON,15);
        checkTheCheckboxOrRadio(driver, RegisterPageUi.GENDER_MALE_RADIO_BUTTON);
    }

    public void enterToFirstNameTextBox(String firtName) {
        onlyWaitForElementVisible(driver,RegisterPageUi.FRISTNAME_TEXTBOX,15);
        sendkeyToElement(driver,RegisterPageUi.FRISTNAME_TEXTBOX,firtName);
    }

    public void enterToLastNameTextBox(String lastName) {
        onlyWaitForElementVisible(driver,RegisterPageUi.LASTNAME_TEXTBOX,15);
        sendkeyToElement(driver,RegisterPageUi.LASTNAME_TEXTBOX,lastName);

    }

    public void selectDayDropdown(String day) {
        onlyWaitForElementVisible(driver,RegisterPageUi.DAY_DROPDOWN,15);
        selectItemInDropdown(driver, RegisterPageUi.DAY_DROPDOWN,day);
    }

    public void selectMonthDropdown(String month) {
        onlyWaitForElementVisible(driver,RegisterPageUi.MONTH_DROPDOWN,15);
        selectItemInDropdown(driver, RegisterPageUi.MONTH_DROPDOWN,month);
    }

    public void selectYearDropdown(String year) {
        onlyWaitForElementVisible(driver,RegisterPageUi.YEAR_DROPDOWN,15);
        selectItemInDropdown(driver, RegisterPageUi.YEAR_DROPDOWN,year);
    }

    public void enterToEmailTextbox(String emailAddress) {
        onlyWaitForElementVisible(driver,RegisterPageUi.EMAIL_TEXTBOX,15);
        sendkeyToElement(driver,RegisterPageUi.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToCompanyTextbox(String company) {
        onlyWaitForElementVisible(driver,RegisterPageUi.COMPANY_NAME_TEXTBOX,15);
        sendkeyToElement(driver,RegisterPageUi.COMPANY_NAME_TEXTBOX,company);
    }

    public void enterToPasswordTextbox(String password) {
        onlyWaitForElementVisible(driver,RegisterPageUi.PASSWORD_TEXTBOX,15);
        sendkeyToElement(driver,RegisterPageUi.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfrimPasswordTextbox(String confirmPassword) {
        onlyWaitForElementVisible(driver,RegisterPageUi.CONFIRM_PASSWORĐ_TEXTBOX,15);
        sendkeyToElement(driver,RegisterPageUi.CONFIRM_PASSWORĐ_TEXTBOX,confirmPassword);

    }

    public void clickToRegisterButton() {
        onlyWaitForElementClickable(driver,RegisterPageUi.REGISTER_BUTTON,15);
        clickToElement(driver,RegisterPageUi.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        onlyWaitForElementVisible(driver, RegisterPageUi.REGISTER_SUCCESS_MESSAGE,15);
        return getElementText(driver, RegisterPageUi.GENDER_MALE_RADIO_BUTTON);
    }

    public void clickToLoginLink() {
        onlyWaitForElementClickable(driver,RegisterPageUi.LOGIN_LINK,15);
        clickToElement(driver,RegisterPageUi.LOGIN_LINK);
    }


    public String getRegisterErrorMessage() {
        return null;
    }
}
