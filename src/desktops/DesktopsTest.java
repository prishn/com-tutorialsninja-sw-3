package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 *
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */
public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    // * 1.Test name verifyProductArrangeInAlphaBeticalOrder()
    public void verifyProductArrangeInAlphaBeticalOrder(){
        // * 1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        // * 1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        // * 1.3 Select Sort By position "Name: Z to A"
        selectByVisibleFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        // * 1.4 Verify the Product will arrange in Descending order.
        assertEqualsMethod("Incorrect order", "Name (Z - A)",
                By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"));
//
        //manageElementList(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"),"Name (Z - A)" );
        //manageElementList(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC']"), "Name (A - Z)");
    }
    @Test
    //Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessFully() {
        // * 2.1 Mouse hover on Currency Dropdown and click
        mouseHoverToElementAndClick(By.xpath("//i[@class='fa fa-caret-down']"));

        // * 2.2 Mouse hover on £Pound Sterling and click
        mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='£Pound Sterling']"));

        // * 2.3 Mouse hover on Desktops Tab.
        mouseHoverToElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        // * 2.4 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        // * 2.5 Select Sort By position "Name: A to Z"
        selectByVisibleFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        // * 2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//img[@title='HP LP3065']"));

        // * 2.7 Verify the Text "HP LP3065"
        assertEqualsMethod("Incorrect Text", "HP LP3065", By.xpath("//h1[normalize-space()='HP LP3065']"));

        // * 2.8 Select Delivery Date "2024-11-27"
//        clearTextField(By.xpath("//input[@id='input-option225']"));
//        sendTextToElement(By.xpath("//input[@id='input-option225']"), "2024-11-27");
        String year = "2024";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//span[@class = 'input-group-btn']//button[@class = 'btn btn-default']")); // open the calendar
        while (true) {
            //inspect April 2021
            String monthYear = getTextFromElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'picker-switch']"));
            System.out.println(monthYear);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'next']"));
            }
        }
        // Select the date
        List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

        // * 2.9.Enter Qty "1” using Select class.
        clearTextField(By.className("form-control"));
        sendTextToElement(By.className("form-control"), "1");

        // * 2.10 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));

        // * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        assertEqualsMethod("Incorrect Message", "Success: You have added HP LP3065 to your shopping cart!\n×",
                By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        // * 2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // * 2.13 Verify the text "Shopping Cart  (1.00kg)"
        assertEqualsMethod("Wrong Text", "Shopping Cart  (1.00kg)",
                By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        // * 2.14 Verify the Product name "HP LP3065"
        assertEqualsMethod("Incorrect Product Name", "HP LP3065",
                By.xpath("(//a[contains(text(),'HP LP3065')])[2]"));

        // * 2.15 Verify the Delivery Date "2023-11-27"
        assertEqualsMethod("Incorrect Date", "Delivery Date:2023-11-27",
                By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"));

        // * 2.16 Verify the Model "Product 21"
        assertEqualsMethod("Incorrect Model", "Product 21", By.xpath("//td[normalize-space()='Product 21']"));

        // * 2.17 Verify the Total "£74.73"
        assertEqualsMethod("Incorrect Price", "£74.73", By.xpath("(//td[contains(text(),'£74.73')])[4]"));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
