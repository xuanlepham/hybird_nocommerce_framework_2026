package pageObjects;

import com.beust.jcommander.IStringConverter;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageUis.CustomerInforPageUi;

import java.time.Duration;

public class CustomerInforPageObject extends BasePage {

    private WebDriver driver;
    public CustomerInforPageObject(WebDriver driver){
        this.driver = driver;
    }
    public boolean isSelectedMalRadioButton() {
        onlyWaitForElementSelected(driver, CustomerInforPageUi.GENDER_MALE_RADIO_BUTTON,15);
        return isControlSelected(driver, CustomerInforPageUi.GENDER_MALE_RADIO_BUTTON);
    }

    public String getValueFirstNameTextbox() {
        onlyWaitForElementVisible(driver, CustomerInforPageUi.FRISTNAME_TEXTBOX,15);
        return getAttributeValue(driver,CustomerInforPageUi.FRISTNAME_TEXTBOX,"value") ;
    }

    public String getValueLastNameTextbox() {
        onlyWaitForElementVisible(driver, CustomerInforPageUi.LASTNAME_TEXTBOX,15);
        return getAttributeValue(driver,CustomerInforPageUi.LASTNAME_TEXTBOX,"value") ;
    }

    public String getValueEmailTextbox() {
        onlyWaitForElementVisible(driver, CustomerInforPageUi.EMAIL_TEXTBOX,15);
        return getAttributeValue(driver,CustomerInforPageUi.EMAIL_TEXTBOX,"value") ;
    }
    //Declare Variable

}
