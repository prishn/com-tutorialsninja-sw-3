package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * <p>
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        // * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));


        // * 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        // * 1.3 Select Sort By "Price (High > Low)"
        selectByVisibleFromDropDown(By.xpath("(//select[@id='input-sort'])[1]"), "Price (High > Low)");

        // * 1.4 Verify the Product price will arrange in High to Low order.
        assertEqualsMethod("Incorrect order", "Price (High > Low)",
                By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC']"));
    }

    @Test
    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        // * 2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        // * 2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        // * 2.3 Select Sort By "Price (High > Low)"
        selectByVisibleFromDropDown(By.xpath("(//select[@id='input-sort'])[1]"), "Price (High > Low)");

        // * 2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        // * 2.5 Verify the text “MacBook”
        assertEqualsMethod("Incorrect Text", "MacBook", By.xpath("//h1[normalize-space()='MacBook']"));

        //Changing currency
        mouseHoverToElement(By.xpath("//span[text()='Currency']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[text()='Currency']"));
        Thread.sleep(1000);
        //Mouse hover on £Pound Sterling and click
        mouseHoverToElement(By.xpath("//button[text()='£Pound Sterling']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[text()='£Pound Sterling']"));

        // * 2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        // * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertEqualsMethod("Incorrect Message", "Success: You have added MacBook to your shopping cart!\n×",
                By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        // * 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // * 2.9 Verify the text "Shopping Cart"
        assertEqualsMethod("Wrong Text", "Shopping Cart  (0.00kg)",
                By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        // * 2.10 Verify the Product name "MacBook"
        assertEqualsMethod("Incorrect Product Name", "MacBook",
                By.xpath("(//a[contains(text(),'MacBook')])[2]"));

        // * 2.11 Change Quantity "2"
        clearTextField(By.xpath("//input[@class='form-control']"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@class='form-control']"), "2");

        // * 2.12 Click on “Update” Tab
        clickOnElement(By.xpath("(//button[@type='submit'])[1]"));

        // * 2.13 Verify the message “Success: You have modified your shopping cart!”
        assertEqualsMethod("Incorrect Message", "Success: You have modified your shopping cart!\n×",
                By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Thread.sleep(2000);

        // * 2.14 Verify the Total £737.45
        assertEqualsMethod("Incorrect Total", "£737.45",
                By.xpath("(//td[contains(text(),'£737.45')])[3]"));
        Thread.sleep(2000);

        // * 2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        // * 2.16 Verify the text “Checkout”
        assertEqualsMethod("Incorrect Text", "Checkout",
                By.xpath("//h1[normalize-space()='Checkout']"));
        Thread.sleep(2000);
        // * 2.17 Verify the Text “New Customer”
        assertEqualsMethod("Incorrect Text", "New Customer",
                By.xpath("//h2[normalize-space()='New Customer']"));
        Thread.sleep(2000);

        // * 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(2000);
        // * 2.19 Click on “Continue” tab
        clickOnElement(By.cssSelector("#button-account"));

        // * 2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Robert");
        sendTextToElement(By.id("input-payment-lastname"), "Jackson");
        sendTextToElement(By.id("input-payment-email"), "robert_jackson@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "07896542365");
        sendTextToElement(By.id("input-payment-address-1"), "Harry Porter Road");
        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.name("postcode"), "HP5 2PH");
        selectByVisibleFromDropDown(By.id("input-payment-country"), "United Kingdom");
        selectByVisibleFromDropDown(By.id("input-payment-zone"), "Derbyshire");

        // * 2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        // * 2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Leave it by door please");

        // * 2.23 Check the Terms & Conditions check box
        clickOnElement(By.cssSelector("input[value='1'][name='agree']"));

        // * 2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        // * 2.25 Verify the message “Warning: Payment method required!”
        assertEqualsMethod("Incorrect warning message", "Warning: Payment method required!\n×",
                By.xpath("//div[@class ='alert alert-danger alert-dismissible']"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
