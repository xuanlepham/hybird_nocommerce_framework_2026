package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_03_Page_Object_Parttern extends BasePage{

    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.get("");



    }
    @Test
    public void TC_01_Test(){
      onlyWaitForElementClickable(driver,"//a[@class='ico-register']",15);
      clickToElement(driver,"//a[@class='ico-register']" );

      onlyWaitForElementClickable(driver,"//input[@id='gender-male']",15);
      clickToElement(driver,"//input[@id='gender-male']" );

      sendkeyToElement(driver, "//input[@id='FirstName']","Thomas");

      selectItemInDropdown(driver,"//input[@id='FirstName']","text");
      Assert.assertEquals(getElementText(driver,"//div[@class='result']"),"Your registration completed");

    }
}
