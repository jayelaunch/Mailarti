package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignUp;

public class testSignUp {
    public WebDriver driver;


    @BeforeTest
    public void setUp() {
        // Set up the WebDriver and open the web page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mailarti.elaunchinfotech.in/register");

        // Initialize the Page Object

    }

    @Test
    public void fillFormAndSubmit() {

        SignUp page = new SignUp(driver);
        // Perform actions using Page Object methods
        page.enterTextInTextBox1("Jay");
        page.enterTextInTextBox2("Patel");
        page.enterTextInTextBox4("jayatel161@gmail.com");
        page.enterTextInPhone("9876543210");
        page.enterTextInTextBox5("Michi@786");
        page.enterTextInTextBox6("Michi@786");
        page.clickSubmitButton();

        // Add assertions or verification steps as needed
    }

    @AfterTest
    public void cleanUp() {
        //driver.quit();

    }

    // Clean up resources in the @AfterTest method
}

