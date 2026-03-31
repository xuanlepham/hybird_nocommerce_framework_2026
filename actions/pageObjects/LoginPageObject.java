package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.HomePageUi;
import pageUis.LoginPageUi;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void enterToEmailTexbox(String emailAddress) {
        onlyWaitForElementVisible(driver, LoginPageUi.EMAIL_TEXTBOX,15);
        sendkeyToElement(driver,LoginPageUi.EMAIL_TEXTBOX,emailAddress);

    }

    public void enterToPasswordTexbox(String passwordTextbox) {
        onlyWaitForElementVisible(driver, LoginPageUi.PASSWORD_TEXTBOX,15);
        sendkeyToElement(driver,LoginPageUi.PASSWORD_TEXTBOX,passwordTextbox);
    }

    public void clickToLoginButton(String s) {
        onlyWaitForElementClickable(driver, LoginPageUi.LOGIN_BUTTON,15);
        clickToElement(driver,LoginPageUi.LOGIN_BUTTON);

    }
}
