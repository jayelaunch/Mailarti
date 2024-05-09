package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    WebDriver driver;

    // Constructor to initialize the driver and Page Factory
    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Define WebElement locators using @FindBy annotation
    @FindBy(name = "first_name")
    private WebElement inputfname;

    @FindBy(name = "last_name")
    private WebElement inputmname;

    @FindBy(name = "email")
    private WebElement inputemail;

    @FindBy(name = "phone")
    private WebElement inputphone;

    @FindBy(name = "password")
    private WebElement inputpassword;

    @FindBy(name = "confirm_password")
    private WebElement inputrepassword;

    @FindBy(xpath = "(//button[normalize-space()='Register'])")
    private WebElement clicksubmitButton;

    // Methods to interact with the elements
    public void enterTextInTextBox1(String text) {
        inputfname.sendKeys(text);
    }

    public void enterTextInTextBox2(String text) {
        inputmname.sendKeys(text);
    }

    public void enterTextInTextBox4(String text) {
        inputemail.sendKeys(text);
    }

    public void enterTextInPhone(String text) {
        inputphone.sendKeys(text);
    }

    public void enterTextInTextBox5(String text) {
        inputpassword.sendKeys(text);
    }

    public void enterTextInTextBox6(String text) {
        inputrepassword.sendKeys(text);
    }

    public void clickSubmitButton() {
        clicksubmitButton.click();
    }
}

