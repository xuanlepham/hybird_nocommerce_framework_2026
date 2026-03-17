package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    protected void clickToElement(){
        driver.findElement(By.xpath("")).click();
    }
    public String getElementText(){
        return driver.findElement(By.xpath("")).getText();

    }
    public void sendkeyElement(String valueSendkey){
        driver.findElement(By.xpath("")).sendKeys(valueSendkey);

    }
    public boolean isElementDisplay(){
        return driver.findElement(By.xpath("")).isDisplayed();
    }

    public String getCurentUrl(){
       return driver.getCurrentUrl();
    }
    public String getPageSource(){
        return driver.getPageSource();
    }
    public void back(){
        driver.navigate().back();
    }
    public void forward(){
        driver.navigate().forward();
    }
    public void refresh(){
        driver.navigate().refresh();
    }
    public Alert waitAlertPresence(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void cancelAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String getTextAlert(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public void sendkeyAlert(String valueAlert){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(valueAlert);
    }
}
