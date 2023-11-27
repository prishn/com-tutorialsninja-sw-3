package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in it’.
 */
public class Utility extends BaseTest {
    /**
     * This method will click on any element what ever locator you pass it
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will get the title of the page
     */
    public String getTitle(String text) {
        driver.getTitle();
        return text;
    }

    /**
     * This method will clear the text field
     */
    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }

    /**
     * This method will send text to the elements
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will get size from element
     */
    public void getSizeFromElement(By by) {
        driver.findElement(by).getSize();
    }

    /**
     * This method will verify the expected and actual result
     */
    public void assertEqualsMethod(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(" ", expected, actual);
    }

    //************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept the alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss the alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from the alert
     */
    public void getTextFromAlert() {
        driver.switchTo().alert().getText();

    }

    /**
     * This method will send text the alert
     */
    public String sendTextToAlert(String key) {
        driver.switchTo().alert().sendKeys(key);
        return key;
    }

    //************************* Select class Methods *****************************************************

    /**
     * This method will select the value from dropdown menu
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method will select the index from dropdown menu
     */
    public void selectByIndexFromDropDown(By by, int value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(value);
    }

    /**
     * This method will select visible text from dropdown menu
     */

    public void selectByVisibleFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select all the options from dropdown menu
     */

    public void selectByAllOptionsFromDropDown(By by) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allSelectOptions = select.getAllSelectedOptions();
    }

    /**
     * This method will find the list of WebElements
     */
    public List<WebElement> findElementsList(By by) {
        return driver.findElements(by);
    }

    /**
     * This method will find one WebElement
     */

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }


//************************* Action class Methods *****************************************************

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will use to hover mouse on element and click on it.
     */

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        // actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by1)).click().build().perform();
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        // * 1.2 This method should click on the menu whatever name is passed as parameter.
        WebElement menuList = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }

    public void manageElementList(By by, String text) {
        List<WebElement> manageList = driver.findElements(by);
        for (WebElement element : manageList) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }
}






