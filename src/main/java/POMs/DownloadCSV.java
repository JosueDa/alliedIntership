package POMs;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DownloadCSV {

    @FindBy(xpath = "(//*[contains(@class, 'MuiIconButton-label')])[3]")
    protected WebElement endDate;

    @FindBy(xpath = "(//*[contains(@class, 'MuiIconButton-label')])[2]")
    protected WebElement startDate;

    @FindBy(xpath = "//*[contains(text(),'Descarga de CSV')]")
    protected WebElement titleText;

    @FindBy(xpath = "(//*[contains(@class, 'MuiSvgIcon-root')])[6]")
    protected WebElement nextDateButton;

    @FindBy(xpath = "(//*[contains(@class, 'MuiSvgIcon-root')])[5]")
    protected WebElement prevDateButton;

    @FindBy(xpath = "(//*[contains(@class, 'css-1hwfws3')])[2]")
    protected WebElement companyInput;

    @FindBy(xpath = "//*[text()='Enviar']")
    protected WebElement sendButton;

    @FindBy(xpath = "//input[@placeholder='Nombre del Archivo']")
    protected WebElement fileNameInput;

    @FindBy(xpath = "//a[text()='Descargar CSV de Imágenes']")
    protected WebElement downloadCSVImagesButton;

    @FindBy(xpath = "//a[text()='Descargar CSV']")
    protected WebElement downloadCSVButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public DownloadCSV(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public boolean titleExist(String titleText){
        WebElement title = driver.findElement(By.xpath("//*[contains(text(),'"+titleText+"')]"));
        for (int i=0;i<5;i++){
            if (title.isDisplayed()){
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,15)");
            }
        }
        return false;
    }

    public boolean dateExist(String month, String year){
        try {
            boolean answer= driver.findElement(By.xpath("//*[contains(text(),'"+month+" "+year+"')]")).isDisplayed();
            return answer;
        }catch (Exception e){

        }
        return false;
    }
    public void setEndDate(String day) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(endDate));
        endDate.click();
        nextDateButton.click();
        nextDateButton.click();
        WebElement dayElement=driver.findElement(By.xpath("(//*[text()='"+day+"'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(dayElement));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",dayElement);
    }

    public void setStartDate(String day) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        startDate.click();
        prevDateButton.click();
        prevDateButton.click();
        WebElement dayElement=driver.findElement(By.xpath("(//*[text()='"+day+"'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(dayElement));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",dayElement);
    }

    public boolean titleExist(){
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return  titleText.isDisplayed();
    }


    public void clickCompanyDropdown(String optionString) {
        wait.until(ExpectedConditions.visibilityOf(companyInput));
        this.companyInput.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        option.click();
    }

    public boolean allOptionExist(){
        try {
            driver.findElement(By.xpath("//*[text()='All/Todos']"));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean clickCompanyDropdownByCoordinates() {
        wait.until(ExpectedConditions.visibilityOf(companyInput));
        Actions builder = new Actions(driver);
        int count=0;
        for (int i=0;i<=20;i++){
            companyInput.click();
            builder.sendKeys(Keys.TAB).build().perform();
            if (allOptionExist()){
                for (int j=0; j<count;j++){
                    companyInput.click();
                    builder.sendKeys(Keys.TAB).build().perform();
                }
                return true;
            }
            count++;
        }
        return false;
    }

    public void clickSendButton() {
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        this.sendButton.click();
    }

    public void enterFileNameInput(String name) {
        wait.until(ExpectedConditions.visibilityOf(fileNameInput));
        fileNameInput.sendKeys(name);
    }

    public void clickDownloadCSVImagesButton() {
        wait.until(ExpectedConditions.visibilityOf(downloadCSVImagesButton));
        this.downloadCSVImagesButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean downloadCSVImagesButtonExist() {
        wait.until(ExpectedConditions.visibilityOf(downloadCSVImagesButton));
        return downloadCSVImagesButton.isDisplayed();
    }

    public void clickDownloadCSVButton() {
        wait.until(ExpectedConditions.visibilityOf(downloadCSVButton));
        this.downloadCSVButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean downloadCSVButtonExist() {
        wait.until(ExpectedConditions.visibilityOf(downloadCSVButton));
        return downloadCSVButton.isDisplayed();
    }
}
