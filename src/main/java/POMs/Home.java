package POMs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

    @FindBy(className = "css-1wy0on6")
    protected WebElement dropdownButton;

    @FindBy(xpath = "//header//button[contains(@class, 'MuiButtonBase-root')][2]")
    protected WebElement hamburgerButton;

    @FindBy(xpath = "//header//button[contains(@class, 'MuiButtonBase-root')][3]")
    protected WebElement photoButton;

    @FindBy(id = "createAdMenuItem")
    protected WebElement createCampaignButton;

    @FindBy(id = "billingPageId")
    protected WebElement billingButton;

    @FindBy(xpath = "//*[contains(text(),'Negocio Administrador')]")
    protected WebElement titleText;

    private WebDriver driver;
    private WebDriverWait wait;

    public Home(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void clickDropdownButton() {
        Actions builder = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(dropdownButton));
        this.dropdownButton.click();
        builder.sendKeys(Keys.TAB).build().perform();
    }

    public void clickHamburgerButton() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerButton));
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",hamburgerButton);
    }

    public void clickPhotoButton() {
        wait.until(ExpectedConditions.visibilityOf(photoButton));
        wait.until(ExpectedConditions.elementToBeClickable(photoButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",photoButton);
    }

    public void clickCreateCampaignButton() {
        wait.until(ExpectedConditions.visibilityOf(createCampaignButton));
        wait.until(ExpectedConditions.elementToBeClickable(createCampaignButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",createCampaignButton);
    }

    public void clickBillingButton() {
        wait.until(ExpectedConditions.visibilityOf(billingButton));
        wait.until(ExpectedConditions.elementToBeClickable(billingButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",billingButton);
    }

    public boolean titleExist(){
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return  titleText.isDisplayed();
    }

}
