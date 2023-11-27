package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.UUID;

/**
 * Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 * <p>
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 * 1.1 Click on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
 * 1.3 Verify the text “Register Account”.
 * <p>
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 * 2.1 Click on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
 * 2.3 Verify the text “Returning Customer”.
 * <p>
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 * 3.1 Click on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button
 * 3.12 Verify the message “Your Account Has Been Created!”
 * 3.13 Click on Continue button
 * 3.14 Click on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 * <p>
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 * 4.1 Click on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Clickr on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */
public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {

        // * 1.2 This method should click on the options whatever name is passed as parameter.
        List<WebElement> topMenuNames = driver.findElements((By.xpath("//ul[@class = 'list-inline']//a")));
        for (WebElement names : topMenuNames) {
            System.out.println(names.getText());
            if (names.getText().equalsIgnoreCase(option)) {
                names.click();
                break;
            }
        }
    }

    @Test
    // * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        // * 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);
        // * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(2000);
        // * 1.3 Verify the text “Register Account”.
        assertEqualsMethod("Incorrect Option", "Register Account",
                By.xpath("//h1[normalize-space()='Register Account']"));

    }

    @Test
    // * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        // * 2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);
        // * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(2000);

        // * 2.3 Verify the text “Returning Customer”.
        assertEqualsMethod("Incorrect Text", "Returning Customer",
                By.xpath("//h2[normalize-space()='Returning Customer']"));
    }

    @Test
    //Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        // * 3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);

        // * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(2000);

        // * 3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"), "Robert");

        // * 3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"), "Jackson");

        // * 3.5 Enter Email
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("input-email"), randomEmail);

        // * 3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"), "07896542365");

        // * 3.7 Enter Password
        sendTextToElement(By.id("input-password"), "12345678");

        // * 3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "12345678");
        Thread.sleep(2000);

        // * 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

        // * 3.10 Click on Privacy Policy check box
        clickOnElement(By.cssSelector("input[value='1'][name='agree']"));

        // * 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        // * 3.12 Verify the message “Your Account Has Been Created!”
        assertEqualsMethod("Incorrect message", "Your Account Has Been Created!",
                By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

        // * 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        // * 3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        // * 3.16 Verify the text “Account Logout”
        assertEqualsMethod("Incorrect Text", "Logout", By.xpath("//a[normalize-space()='Logout']"));

        // * 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    //Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        // * 4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(2000);

        // * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        // * 4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "robert_jackson@gmail.com");

        // * 4.5 Enter Password
        sendTextToElement(By.id("input-password"), "12345678");

        // * 4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        Thread.sleep(2000);

        // * 4.7 Verify text “My Account”
        assertEqualsMethod("Incorrect Text", "My Account", By.xpath("//h2[normalize-space()='My Account']"));
        Thread.sleep(2000);

        // * 4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        Thread.sleep(2000);

        // * 4.10 Verify the text “Account Logout”
        assertEqualsMethod("Incorrect Text", "Logout", By.xpath("//a[normalize-space()='Logout']"));

        // * 4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    private static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }

}

