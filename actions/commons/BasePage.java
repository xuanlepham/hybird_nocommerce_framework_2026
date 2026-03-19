package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
//    private WebDriver driver;

    // Biến global (private chỉ dùng trong class) sinh ra trong phạm vi Class
   private String fullName;

    // Biến sinh ra trong tham số của hàm vẫn là biến local (cục bộ)
    public String getFullname(){
        // Biến local (cục bộ chỉ dùng trong class)
        String fullName = null ; // Biến sinh ra trong thân hàm

        // Trong phạm vi khối lệnh ( block code)

        for (int i = 0; i < 10; i++) {// biến cục bộ
            int n=1; // biến cục bộ
            if(n>0){
                int x =10;// biến cục bộ
            }

        }
        return this.fullName; // dùng this. để sử dụng biến global
    }


    protected void clickToElement(WebDriver driver){
        driver.findElement(By.xpath("")).click();
    }
    public String getElementText(WebDriver driver){
        return driver.findElement(By.xpath("")).getText();

    }
    public void sendkeyElement(WebDriver driver,String valueSendkey){
        driver.findElement(By.xpath("")).sendKeys(valueSendkey);

    }
    public boolean isElementDisplay(WebDriver driver){
        return driver.findElement(By.xpath("")).isDisplayed();
    }

    public void openPageUrl(WebDriver driver, String url){
        driver.get(url);
    }
    public String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }
    public  String getTitle(WebDriver driver ){
        return driver.getTitle();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public Alert waitAlertPresence(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
        // new lên không khai báo biến
    public Alert waitAlertPresences(WebDriver driver){
         return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.alertIsPresent());
    }
        // new lên không khai báo biến và sử dụng code riêng k dùng hàm
    public void acceptAlerts(WebDriver driver){
         new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.alertIsPresent()).accept();
    }
    // hàm trong hàm
    public void acceptAlert(WebDriver driver){
        waitAlertPresences(driver).accept();
    }


    public void cancelAlert(WebDriver driver){
        waitAlertPresences(driver).dismiss();
    }
    public String getTextAlert(WebDriver driver){
        return waitAlertPresences(driver).getText();
    }

    public void sendkeyAlert(WebDriver driver, String valueAlert){
        waitAlertPresences(driver).sendKeys(valueAlert);
    }
    //switchToWindowByID dùng cho trường hợp mở 2 tab
    public void switchToWindowByID(WebDriver driver, String parentID) { // tham số truyền vào driver là driver của trình duyệt,parentID của tab hiện tại
        Set<String> allWindows = driver.getWindowHandles(); // Lấy tất cả các tab windows hiện có
        for (String runWindow : allWindows) { // duyệt qua từng tab window
            if (!runWindow.equals(parentID)) { // Nếu tab window nào không trùng với id của tab hiện tại ( tab gốc) -> tab window mới vừa mở
                driver.switchTo().window(runWindow);// chuyển thao tác element qua tab mới
                break;
            }
        }
    }
    //switchToWindowByTitle dùng trong trường hợp nhiều tab phải lấy title của tab
    public void switchToWindowByTitle(WebDriver driver, String title) { //tham số truyền vào driver là driver của trình duyệt,String title của tab cần đến
        Set<String> allWindows = driver.getWindowHandles();//Lấy tất cả các tab windows hiện có
        for (String runWindows : allWindows) {// duyệt qua từng tab window
            driver.switchTo().window(runWindows);// switch qua từng tab window
            String currentWin = driver.getTitle();// mỗi lần swtich qua lấy title của tab đó
            if (currentWin.equals(title)) { // Nếu title giống với title expect thì dừng lại
                break;
            }
        }
    }
    // Đóng hết tất cả các tab phụ quay về tab gốc
    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) { // tham số truyền vào driver là driver của trình duyệt,parentID của tab hiện tại
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

}
