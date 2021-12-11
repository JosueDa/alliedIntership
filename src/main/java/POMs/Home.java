package POMs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

    @FindBy(className = "css-1wy0on6")
    protected WebElement dropdownButton;

    @FindBy(xpath = "//*[contains(text(),'2020-11-28')]")
    protected WebElement dropdownOptionButton;

    @FindBy(xpath = "//header//button[contains(@class, 'MuiButtonBase-root')][2]")
    protected WebElement hamburgerButton;

    @FindBy(id = "createAdMenuItem")
    protected WebElement createCampaignButton;

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
        wait.until(ExpectedConditions.visibilityOf(dropdownButton));
        this.dropdownButton.click();
    }

    public void clickDropdownOptionButton() {
        wait.until(ExpectedConditions.visibilityOf(dropdownOptionButton));
        this.dropdownOptionButton.click();
    }

    public void clickHamburgerButton() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerButton));
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",hamburgerButton);
    }

    public void clickCreateCampaignButton() {
        wait.until(ExpectedConditions.visibilityOf(createCampaignButton));
        wait.until(ExpectedConditions.elementToBeClickable(createCampaignButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",createCampaignButton);
    }

    public boolean titleExist(){
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return  titleText.isDisplayed();
    }

}
