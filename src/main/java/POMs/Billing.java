package POMs;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Billing {

    @FindBy(xpath = "//*[contains(text(),'Billing')]")
    protected WebElement titleText;

    @FindBy(xpath = "//*[text()='Activo']")
    protected WebElement activeSubscriptionLabel;

    @FindBy(xpath = "//*[contains(text(),'Cancelar Suscripción')]")
    protected WebElement cancelSubscriptionButton;

    @FindBy(xpath = "(//*[text()='Seleccionar'])[1]")
    protected WebElement selectFirstProductButton;

    @FindBy(xpath = "//*[text()='Proceder a pago']")
    protected WebElement proceedPaymentButton;

    @FindBy(xpath = "(//*[contains(@class, 'card-ui-component-field')])[1]")
    protected WebElement cardNumberInput;

    @FindBy(xpath = "(//*[contains(@class, 'card-ui-component-field')])[2]")
    protected WebElement cardNameInput;

    @FindBy(id = "card-ui-component-ddl-expiry-year")
    protected WebElement expireYearSelect;

    @FindBy(id = "card-ui-component-ddl-expiry-month")
    protected WebElement expireMonthSelect;

    @FindBy(id = "codigoccv")
    protected WebElement CCVInput;

    @FindBy(id = "acceptCheck")
    protected WebElement acceptCheck;

    @FindBy(id = "card-ui-component-btn-confirm")
    protected WebElement confirmButton;

    @FindBy(xpath = "//*[contains(text(),'Aceptar')]")
    protected WebElement acceptCancelSubscription;

    private WebDriver driver;
    private WebDriverWait wait;

    public Billing(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public boolean titleExist(String titleText){
        for (int i=0;i<5;i++){
            WebElement title = driver.findElement(By.xpath("//*[contains(text(),'"+titleText+"')]"));
            if (title.isDisplayed()){
                return true;
            }else {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean mainTitleExist(){
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return  titleText.isDisplayed();
    }

    public boolean clickFirstProduct(){
        for (int i=0;i<3;i++){
            if (selectFirstProductButton.isDisplayed()){
                wait.until(ExpectedConditions.elementToBeClickable(selectFirstProductButton));
                ((JavascriptExecutor)driver).executeScript("arguments[0].click()",selectFirstProductButton);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
            }
        }
        return false;
    }

    public boolean clickProceedToPay(){
        for (int i=0;i<2;i++){
            if (proceedPaymentButton.isDisplayed()){
                wait.until(ExpectedConditions.elementToBeClickable(proceedPaymentButton));
                ((JavascriptExecutor)driver).executeScript("arguments[0].click()",proceedPaymentButton);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
            }
        }
        return false;
    }

    public void enterCardNumber(String number){
        if (!cardNumberInput.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        cardNumberInput.sendKeys(number);
    }

    public void enterCardName(String name){
        if (!cardNameInput.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        cardNameInput.sendKeys(name);
    }

    public void enterExpireMonth(int index){
        if (!expireMonthSelect.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        Select selectMonth = new Select(expireMonthSelect);
        selectMonth.selectByIndex(index);
    }

    public void enterExpireYear(int index){
        if (!expireYearSelect.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        Select selectYear = new Select(expireYearSelect);
        selectYear.selectByIndex(index);
    }

    public void enterCCVCode(String code){
        if (!CCVInput.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        CCVInput.sendKeys(code);
    }

    public void clickAcceptCheck(){
        if (!acceptCheck.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",acceptCheck);
    }

    public boolean confirmButtonExist(){
        if (!confirmButton.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        return confirmButton.isDisplayed();
    }

    public void clickConfirmPayment(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",confirmButton);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean subscriptionCancellationValidation(){
        if (!cancelSubscriptionButton.isDisplayed()) ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
        return activeSubscriptionLabel.isDisplayed() && cancelSubscriptionButton.isDisplayed();
    }

    public void clickCancellationSubscription(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",cancelSubscriptionButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",acceptCancelSubscription);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
