package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * <p>
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * <p>
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */
public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    // * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        // * 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        clickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        Thread.sleep(2000);
        // * 1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        selectMenu("Show AllDesktops");
        Thread.sleep(2000);
        // * 1.3 Verify the text ‘Desktops’
        assertEqualsMethod("Incorrect Text", "Desktops", By.xpath("//h2[normalize-space()='Desktops']"));
    }

    @Test
    // * 2.verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        // * 2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        // * 2.3 Verify the text ‘Laptops & Notebooks’
        assertEqualsMethod("IncorrectText", "Laptops & Notebooks",
                By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
    }

    @Test
    // * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        // * 3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Components']"));
        clickOnElement(By.xpath("//a[normalize-space()='Components']"));

        // * 3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

        // * 3.3 Verify the text ‘Components’
        assertEqualsMethod("Incorrect components", "Components",
                By.xpath("//h2[normalize-space()='Components']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
