package com.nopcommerce.users;

import commons.BaseTest;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_04_Mutiple_Browser extends BaseTest {
    //Declare Variable
    private WebDriver driver;

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInforPageObject customerInforPage;
    private String firstName, lastName,emailAddress,day,month,year;
    @Parameters("browser")


    //Pre-Conditon
    @BeforeClass
    public void beforeClass(String browserName){
       driver = getBrowserDriver(browserName);




        // Nó được sinh ra và bắt đầu làm những action của page đó
        homePage = new HomePageObject(driver);
        firstName="";
        lastName="";
        emailAddress="test"+generateRandomNumber()+"@gmail.com";
        day="";
        month="";
        year="";
    }

    //Testcase
    @Test
    public void Register(){
        // Action 1
        homePage.clickToRegisterLink();

        // Từ homePage qua register page
        // Page đó được sinh ra và bắt đầu làm những action của page đó

        registerPage = new RegisterPageObject(driver);

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

        String error =  registerPage.getRegisterErrorMessage();


    }
    @Test
    public void Login(){
        registerPage.clickToLoginLink();
        // Từ register qua login page
        // Page đó được sinh ra và bắt đầu làm những action của page đó
        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTexbox("");
        loginPage.enterToPasswordTexbox("");
        loginPage.clickToLoginButton("");

        // Từ login qua home page
        // Page đó được sinh ra và bắt đầu làm những action của page đó
        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }
    @Test
    public void MyAccount(){
        // Từ homepage qua Customer infor
        // Page đó được sinh ra và bắt đầu làm những action của page đó
        homePage.clickToMyAccountLink();

        customerInforPage = new CustomerInforPageObject(driver);
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
