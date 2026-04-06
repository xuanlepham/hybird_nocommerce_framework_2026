package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    protected int generateRandomNumber(){
        return new Random().nextInt(99999);
    }

    protected WebDriver getBrowserDriver(String browserName){
        switch (browserName){
            case "friefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw  new RuntimeException("Brower name is not valid");
        }
        driver.get("https://www.google.com/?hl=vi");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
