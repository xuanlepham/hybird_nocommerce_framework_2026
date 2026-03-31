package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.HomePageUi;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    // Hàm khởi tạo (Contrusctor function)
    // 1- Cùng tên với Class
    // 2- Không kiểu trả về (Data Type)
    // 3- Chạy đầu tiên khi Class này được gọi (new HomePageObject)
    // 4- Có tham số hoặc không
    // 5- Không tự define hàm khởi tạo thì JVM sẽ tự tạo mặc định 1 hàm khởi tạo rỗng
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToRegisterLink() {
        onlyWaitForElementClickable(driver,HomePageUi.REGISTER_LINK,15);
        clickToElement(driver,HomePageUi.REGISTER_LINK);
    }



    public void clickToMyAccountLink() {
        onlyWaitForElementClickable(driver,HomePageUi.MY_ACCOUNT_LINK,15);
        clickToElement(driver,HomePageUi.MY_ACCOUNT_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        onlyWaitForElementVisible(driver,HomePageUi.MY_ACCOUNT_LINK,15);
        return isControlDisplayed(driver, HomePageUi.MY_ACCOUNT_LINK);
    }
}
