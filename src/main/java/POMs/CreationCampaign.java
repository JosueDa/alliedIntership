package POMs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreationCampaign {


    @FindBy(xpath = "//*[contains(text(),'Creación de Campañas')]")
    protected WebElement titleText;

    @FindBy(className = "css-1hwfws3")
    protected WebElement campaignObjectiveDropdown;

    @FindBy(xpath = "//*[contains(text(),'Generación de clientes potenciales')]")
    protected WebElement potentialCustomersOption;

    private WebDriver driver;
    private WebDriverWait wait;

    public CreationCampaign(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public boolean titleExist(){
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return  titleText.isDisplayed();
    }

}
