package javaOOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Polymorphirm {
    // hàm khởi tạo không tham số
    public Polymorphirm(){

    }
    // hàm khởi tạo 1 tham số
    public Polymorphirm(WebDriver webDriver){

    }
    // hàm khởi tạo 2 tham số
    public Polymorphirm(WebDriver webDriver, WebDriverWait expliciWait){

    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        actions.clickAndHold();
        actions.clickAndHold(driver.findElement(By.xpath("")));








    }

}
