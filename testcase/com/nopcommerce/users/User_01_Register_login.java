package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_01_Register_login {
    WebDriver  driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();

    }
    @Test
    public void TC_01_Register(){

    }
    @Test
    public void TC_02_Login(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
