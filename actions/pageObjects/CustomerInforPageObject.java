package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerInforPageObject {
    //Declare Variable
    private WebDriver driver;

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInforPageObject customerInforPage;



    //Pre-Conditon
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Nó được sinh ra và bắt đầu làm những action của page đó
        homePage = new HomePageObject();

    }

    //Testcase
    @Test
    public void Register(){
        // Action 1
        homePage.clickToRegisterLink();

        // Từ homePage qua register page
        // Page đó được sinh ra và bắt đầu làm những action của page đó

        registerPage = new RegisterPageObject();

        registerPage.clickToMaleRadio();

        registerPage.enterToFirstNameTextBox("");

        registerPage.enterToLastNameTextBox("");

        registerPage.selectDayDropdown("");

        registerPage.selectMonthDropdown("");

        registerPage.selectYearDropdown("");

        registerPage.enterToEmailTextbox("");

        registerPage.enterToCompanyTextbox("");

        registerPage.enterToPasswordTextbox("");

        registerPage.enterToConfrimPasswordTextbox("");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"");


    }
    @Test
    public void Login(){
        registerPage.clickToLoginButton();
        // Từ register qua login page
        // Page đó được sinh ra và bắt đầu làm những action của page đó
        loginPage = new LoginPageObject();

        loginPage.enterToEmailTexbox("");
        loginPage.enterToPasswordTexbox("");
        loginPage.clickToLoginButton("");

        // Từ login qua home page
        // Page đó được sinh ra và bắt đầu làm những action của page đó
        homePage = new HomePageObject();

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }
    @Test
    public void MyAccount(){
        // Từ homepage qua Customer infor
        // Page đó được sinh ra và bắt đầu làm những action của page đó
        homePage.clickToMyAccountLink():

        customerInforPage = new CustomerInforPageObject();
        Assert.assertTrue(customerInforPage.isSelectedMalRadioButton());
        Assert.assertEquals(customerInforPage.getValueFirstNameTextbox(),"");
        Assert.assertEquals(customerInforPage.getValueLastNameTextbox(),"");
        Assert.assertEquals(customerInforPage.getValueEmailTextbox(),"");


    }
    //Post-Condition
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
