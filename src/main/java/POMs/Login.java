package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    @FindBy(className = "MuiButton-label")
    protected WebElement loginButton;

    @FindBy(className = "auth0-lock-social-button-text")
    protected WebElement signInButton;

    @FindBy(id = "email")
    protected WebElement emailInput;

    @FindBy(id = "pass")
    protected WebElement passInput;

    @FindBy(id = "loginbutton")
    protected WebElement facebookLoginButton;

    @FindBy(id = "approvals_code")
    protected WebElement approvalsCodeInput;

    @FindBy(id = "checkpointSubmitButton")
    protected WebElement checkpointSubmitButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public Login(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        this.loginButton.click();
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        this.signInButton.click();
    }

    public void clickFacebookLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(facebookLoginButton));
        this.facebookLoginButton.click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void enterPass(String pass) {
        wait.until(ExpectedConditions.visibilityOf(passInput));
        passInput.sendKeys(pass);
    }

    public void enterOTP(String OTP) {
        wait.until(ExpectedConditions.visibilityOf(approvalsCodeInput));
        approvalsCodeInput.sendKeys(OTP);
    }

    public void clickCheckpointSubmitButton() {
        try{
            this.checkpointSubmitButton.click();
        }catch (Exception e){
            System.out.println("the second checkpoint was not necessary");
        }
    }

}
