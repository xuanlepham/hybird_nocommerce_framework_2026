package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Register_login {
    private  WebDriver  driver;
    private  String firstName, lastName, emailAddress, companyName, password;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        firstName="Leex";
        lastName="Pham";
        emailAddress="letest2205"+generateRandomNumber()+"@gmail.com";
        companyName="savis";
        password="Le@123";

    }
    @Test
    public void TC_01_Register(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//a[@class='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");
//         new Select(driver.findElement(By.xpath())).selectByVisibleText("); dropdown thẻ select
    }
    @Test
    public void TC_02_Login(){
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());
    }
    @Test
    public void TC_03_MyAccount(){
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='gender-male")).isSelected());
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Company']")).getAttribute("value"),companyName);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private int generateRandomNumber(){
        return new Random().nextInt(99999);
    }

}
