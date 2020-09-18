package base;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BaseActions extends PageObject {


    @Step("Executing hover action")
    public void hover(String element) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement((WebElement) By.xpath(element)).build().perform();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Executing getURL action")
    public void getURL(String url) {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().get(url);
    }

    public void loadpage(String propertiesname) {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().get(System.getProperty(propertiesname));
    }

    @Step("Executing click action")
    public void click(String element) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            getDriver().findElement(By.xpath(String.valueOf(element))).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Executing clickJS action")
    public void clickJS(String element) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element1 = getDriver().findElement(By.xpath(element));
        try {
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 20);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element1));
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Executing doubleclick action")
    public void doubleclick(String element) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            Actions actions = new Actions(getDriver());
            actions.doubleClick((WebElement) By.xpath(element));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Executing entertext action")
    public void entertext(String element, String text) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clearText(element);
        try {
            getDriver().findElement(By.xpath(element)).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Executing entertext action")
    public void fileUpload(String element, String path) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            getDriver().findElement(By.xpath(element)).sendKeys(path);
            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Step("Executing entertextJS action")
    public void entertextJS(String element, String text) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clearText(element);
        WebElement element1 = getDriver().findElement(By.xpath(element));
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].value='" + text + "';", element1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Executing clearText action")
    public void clearText(String element) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            getDriver().findElement(By.xpath(element)).clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Executing verifyelementvisible action")
    public boolean verifyelementvisible(String element) throws IOException {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 20);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        try {
            return getDriver().findElement(By.xpath(element)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Step("Executing getPageTitle action")
    public String getPageTitle() {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return getDriver().getTitle();
    }

    @Step("Executing getCurrentURL action")
    public String getCurrentURL() {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            return getDriver().getCurrentUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Step("Executing closeBrowser action")
    public void closeBrowser() {
        getDriver().quit();
    }

    public String removeCurrencySymbol(String element) {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String replace = getDriver().findElement(By.xpath(element)).getText();
        return replace.replace("", "");
    }

    @Step("Executing dateSelectorJS action")
    public void dateSelectorJS(String element, String dateVal) {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element1 = getDriver().findElement(By.xpath(element));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute('value','" + dateVal + "');", element1);
    }

    @Step("Executing getWindowHandles action")
    public Set<String> getWindowHandles() {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return getDriver().getWindowHandles();
    }

    @Step("Executing getWindowHandle action")
    public String getWindowHandle() {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return getDriver().getWindowHandle();
    }

    @Step("Executing navigate to ${url} action")
    public void navigate_action(String url) {
        getDriver().navigate().to(url);
    }


    @Step("Executing element visibility action")
    public boolean element_visible(String element) {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        boolean elementvisible = getDriver().findElement(By.xpath(element)).isDisplayed();
        return elementvisible;
    }

    @Step("Executing list of webelement")
    public List<WebElement> webElementList(String element) {
        List<WebElement> webElementList = getDriver().findElements(By.id(element));
        return webElementList;
    }

    @Step("Executing drop down text select from list")
    public void listOf_dropdown_values_select(String element, String text_to_select) {
        WebElement selectElement = getDriver().findElement(By.xpath(element));
        Select select = new Select(selectElement);
        select.selectByVisibleText(text_to_select);
    }

    @Step("Executing new tab action")
    public void new_tab(String url) {
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().get(url);
    }

    @Step("Executing switch to Old tab ")
    public void switch_to_parent_tab() {
        ArrayList<String> tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
    }

    @Step("Executing switch to new tab")
    public void switch_to_child_tab() {
        ArrayList<String> tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    @Step("Executing click action with angular wait")
    public void click_action_with_angular_wait(String element) throws IOException {
        waitForAngularRequestsToFinish();
        clearText(element);
        clickJS(element);
    }

    @Step("Executing enter text action with angular wait")
    public void enter_text_with_angular_wait(String element, String text) throws IOException {
        waitForAngularRequestsToFinish();
        clearText(element);
        entertextJS(element, text);
    }

    @Step("Executing step to check whether field is readable")
    public boolean check_field_readonly(String element) {
        WebElement readOnly = getDriver().findElement(By.xpath(element));
        Assert.assertTrue("Element ReadOnly", readOnly.getAttribute("readonly").equals("true"));
        return true;
    }

    @Step("Executing page source action")
    public boolean getPageSourceAction(String text) {
        return getDriver().getPageSource().contains(text);
    }

    @Step("Quit browser action")
    public void quit_browser() {
        getDriver().quit();
    }

    @Step("Executing getText action")
    public String getText(String element) {
        WebElement element1 = getDriver().findElement(By.xpath(element));
        return element1.getText();
    }

    @Step("Switch to Iframe to 0 Index")
    public void switch_to_desired_Iframe() {
        getDriver().switchTo().frame(0);
    }

    @Step("Switch to default Iframe")
    public void switch_to_default_Iframe() {
        getDriver().switchTo().defaultContent();
    }

    @Step("Verifying whether button is enabled")
    public boolean verify_button_enabled(String element) {
        return getDriver().findElement(By.xpath(element)).isEnabled();
    }
}
