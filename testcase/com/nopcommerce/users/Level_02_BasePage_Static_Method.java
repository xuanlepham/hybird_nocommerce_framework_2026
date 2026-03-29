package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_02_BasePage_Static_Method {
    BasePage basePage;
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        basePage = BasePage.getBasePage();

        driver.get("");



    }
    @Test
    public void TC_01_Test(){
        basePage.onlyWaitForElementClickable(driver,"//a[@class='ico-register']",15);
        basePage.clickToElement(driver,"//a[@class='ico-register']" );

        basePage.onlyWaitForElementClickable(driver,"//input[@id='gender-male']",15);
        basePage.clickToElement(driver,"//input[@id='gender-male']" );

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']","Thomas");

        basePage.selectItemInDropdown(driver,"//input[@id='FirstName']","text");
        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),"Your registration completed");

    }
}
