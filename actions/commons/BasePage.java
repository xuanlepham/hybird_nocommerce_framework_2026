package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class BasePage {
//    private WebDriver driver;

    // Biến global (private chỉ dùng trong class) sinh ra trong phạm vi Class
    private String fullName;

    // Biến sinh ra trong tham số của hàm vẫn là biến local (cục bộ)
    public String getFullname() {
        // Biến local (cục bộ chỉ dùng trong class)
        String fullName = null; // Biến sinh ra trong thân hàm

        // Trong phạm vi khối lệnh ( block code)

        for (int i = 0; i < 10; i++) {// biến cục bộ
            int n = 1; // biến cục bộ
            if (n > 0) {
                int x = 10;// biến cục bộ
            }

        }
        return this.fullName; // dùng this. để sử dụng biến global
    }


    protected void clickToElement(WebDriver driver) {
        driver.findElement(By.xpath("")).click();
    }

    public String getElementText(WebDriver driver) {
        return driver.findElement(By.xpath("")).getText();

    }

    public void sendkeyElement(WebDriver driver, String valueSendkey) {
        driver.findElement(By.xpath("")).sendKeys(valueSendkey);

    }

    public boolean isElementDisplay(WebDriver driver) {
        return driver.findElement(By.xpath("")).isDisplayed();
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // new lên không khai báo biến
    public Alert waitAlertPresences(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.alertIsPresent());
    }

    // new lên không khai báo biến và sử dụng code riêng k dùng hàm
    public void acceptAlerts(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.alertIsPresent()).accept();
    }

    // hàm trong hàm
    public void acceptAlert(WebDriver driver) {
        waitAlertPresences(driver).accept();
    }


    public void cancelAlert(WebDriver driver) {
        waitAlertPresences(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitAlertPresences(driver).getText();
    }

    public void sendkeyAlert(WebDriver driver, String valueAlert) {
        waitAlertPresences(driver).sendKeys(valueAlert);
    }

    public Set<String> getWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public String getWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    //switchToWindowByID dùng cho trường hợp mở 2 tab
    public void switchToWindowByID(WebDriver driver, String parentID) { // tham số truyền vào driver là driver của trình duyệt,parentID của tab hiện tại
        Set<String> allWindows = driver.getWindowHandles(); // Lấy tất cả các tab windows hiện có
        for (String runWindows : allWindows) { // duyệt qua từng tab window
            if (!runWindows.equals(parentID)) { // Nếu tab window hiện tại không trùng với id của tab tab gốc
                driver.switchTo().window(runWindows);// chuyển thao tác element qua tab mới
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

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }


    public void clickToElemetn(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void sendkeyToElemetn(WebDriver driver, String locator, String valueKeysToSend) {
        getElement(driver, locator).sendKeys(valueKeysToSend);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMutiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    // Dùng cho dropdown thường. item luôn visible ( hiển thị )
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSecond(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }
    // Dùng java script để scroll đến item

    public void selectItemInCustomDropdowns(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        driver.findElement(By.xpath(parentLocator)).click();
        sleepInSecond(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSecond(2);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }
    }

    public void selectItemInCustomDropdownTextInvisibel(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        driver.findElement(By.xpath(parentLocator)).click(); // Click vào locator cha chứa dropdown
        sleepInSecond(2);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> allItems = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator))
        ); // lấy tất cả các element con trong list element con
        sleepInSecond(2);
        boolean isFound = false;
        for (WebElement item : allItems) { // duyệt qua tất cả các item trong list
            // Lấy text bằng JS (handle invisible) ***
            String text = (String) js.executeScript(
                    "return arguments[0].textContent;", item
            );
            // Nếu text(***) khác null và bằng với text của item mong muốn lấy
            if (text != null && text.trim().equalsIgnoreCase(expectedItem)) {
                // scroll tới item
                js.executeScript("arguments[0].scrollIntoView(true);", item);
                // click bằng JS (tránh lỗi click thường)
                js.executeScript("arguments[0].click();", item);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new RuntimeException("Không tìm thấy item: " + expectedItem);
        }
    }

    public void sleepInSecond(long timeInsecond) {
        try {
            Thread.sleep(timeInsecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String textValue) {
        return getElement(driver, locator).getAttribute(textValue);
    }

    public String getCSSVlaue(WebDriver driver, String locator, String textValue) {
        return getElement(driver, locator).getCssValue(textValue);
    }

    public String getHexaColorByRgbaColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isControlEnable(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    // hàm check vào checkbox hoặc radio nếu chưa được chọn
    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }


    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void switchToIframeIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public void switchToIframeName(WebDriver driver, String iframeVlaue) {
        driver.switchTo().frame(iframeVlaue);
    }

    public void switchToIframElement(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToIframeElement(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(locator))
        );
        driver.switchTo().frame(iframe);
    }

    // điều hướng về frame gốc
    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Switch về frame cha
    public void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public void leftClickToElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
      new Actions(driver).click(element).perform();
    }
    public void leftClickToElement2(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver, locator)).perform();
    }
    public void leftClickToElement3(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        new Actions(driver).click(element).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }


    public void doubleClickToElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public void dragAndDrop(WebDriver driver,  String sourceLocator, String targetLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sourceLocator)));
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(targetLocator)));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().perform();
    }

    public void senkeyToElement(WebDriver driver, String locator, Keys key) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.sendKeys(element, key).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    public void uploadSingleFile(WebDriver driver, String locator, String filePath) {
        WebElement uploadElement = getElement(driver,locator);
        uploadElement.sendKeys(filePath);
    }

    public void uploadMultipleFiles(WebDriver driver, String locator, String... filePaths) {
        WebElement uploadElement = getElement(driver,locator);
        StringBuilder allFiles = new StringBuilder();
        for (String file : filePaths) {
            allFiles.append(file).append("\n");
        }
        uploadElement.sendKeys(allFiles.toString().trim());
    }

    public Object executeJavascriptToBrowser(WebDriver driver, String script){
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        return  js.executeScript(script);
    }

    public Object executeJavascriptToElement(WebDriver driver, String script,WebElement element){
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        return  js.executeScript(script,element);
    }

    public void scrollToBottomPage(WebDriver driver){
        executeJavascriptToBrowser(driver,"window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToElementByJS(WebDriver driver,WebElement valueElement ){
        executeJavascriptToElement(driver,"arguments[0].scrollIntoView(true);",valueElement);
    }

    public void highlightElement(WebDriver driver, WebElement valueElement ){
        executeJavascriptToElement(driver,"arguments[0].style.border='3px solid red'",valueElement);
    }

    public void removeAttributeOfElement(WebDriver driver, WebElement element, String attribute) {
        executeJavascriptToElement(driver, "arguments[0].removeAttribute('" + attribute + "');", element);
    }
    public boolean checkImageLoaded(WebDriver driver, WebElement image) {
        return (Boolean) executeJavascriptToElement(driver,
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                image);
    }
    public String verifyTextInnerText(WebDriver driver, WebElement element) {
        return (String) executeJavascriptToElement(driver,
                "return arguments[0].innerText;",
                element);
    }

    public String getElementValidationMessage(WebDriver driver, WebElement element) {
        return (String) executeJavascriptToElement(driver,
                "return arguments[0].validationMessage;",
                element);
    }

    public void checkUncheckCheckboxByJS(WebDriver driver, WebElement element, boolean isChecked) {
        boolean checked = (Boolean) executeJavascriptToElement(driver,
                "return arguments[0].checked;", element);

        if (checked != isChecked) {
            executeJavascriptToElement(driver, "arguments[0].click();", element);
        }
    }



}
