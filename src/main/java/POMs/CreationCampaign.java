package POMs;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreationCampaign {

    @FindBy(xpath = "//*[contains(text(),'Objetivos de campaña disponibles')]")
    protected WebElement campaignObjectiveDropdown;

    @FindBy(xpath = "//*[contains(text(),'Sección de Noticias de Facebook')]")
    protected WebElement newSectionFacebookOption;

    @FindBy(xpath = "//*[contains(text(),'En artículos')]")
    protected WebElement articlesFacebookOption;

    @FindBy(xpath = "//*[contains(text(),'Facebook Marketplace')]")
    protected WebElement marketplaceFacebookOption;

    @FindBy(xpath = "//*[contains(text(),'Secciones de videos de Facebook')]")
    protected WebElement videosFacebookOption;

    @FindBy(xpath = "//*[contains(text(),'Historias de Facebook')]")
    protected WebElement storiesFacebookOption;

    @FindBy(xpath = "//*[contains(text(),'Resultados de la búsqueda de Facebook')]")
    protected WebElement resultsFacebookOption;

    @FindBy(xpath = "//*[contains(text(),'Noticias de Instagram')]")
    protected WebElement newsInstagramOption;

    @FindBy(xpath = "//*[contains(text(),'Historias de Instagram')]")
    protected WebElement storiesInstagramOption;

    @FindBy(xpath = "//*[contains(text(),'Sección “Explorar” de Instagram')]")
    protected WebElement exploreInstagramOption;

    @FindBy(xpath = "//*[contains(text(),'Seleccione un Producto')]")
    protected WebElement selectProductDropdown;

    @FindBy(xpath = "//*[contains(text(),'Creación de Campañas')]")
    protected WebElement title;

    @FindBy(xpath = "//*[contains(text(),'Seleccione Cuenta Publicitaria')]")
    protected WebElement addAccountDropdown ;

    @FindBy(xpath = "//*[contains(text(),'Seleccione una Página de Facebook')]")
    protected WebElement fanPageDropdown ;

    @FindBy(xpath = "//*[contains(text(),'Seleccione Formulario Instantáneo')]")
    protected WebElement formsDropdown ;

    @FindBy(xpath = "//*[contains(text(),'Mujeres')]")
    protected WebElement femaleGender ;

    @FindBy(id = "CampaignNametextfield0")
    protected WebElement optionalNameInput;

    @FindBy(id = "CuerposaddButton")
    protected WebElement addMainText;

    @FindBy(id = "Cuerpostextfield0")
    protected WebElement mainTextInput;

    @FindBy(id = "Cuerpostextfield1")
    protected WebElement mainTextInput2;

    @FindBy(id = "Cuerpostextfield2")
    protected WebElement mainTextInput3;

    @FindBy(id = "TítulosaddButton")
    protected WebElement addtitleInput;

    @FindBy(id = "Títulostextfield0")
    protected WebElement titleInput;

    @FindBy(id = "Títulostextfield1")
    protected WebElement titleInput2;

    @FindBy(id = "Títulostextfield2")
    protected WebElement titleInput3;

    @FindBy(id = "descriptiontextfield0")
    protected WebElement descriptionInput;

    @FindBy(xpath = "//*[contains(text(),'Seleccione una Llamada a la acción')]")
    protected WebElement callActionDropdown;

    @FindBy(id = "CreateAdDatePicker-startDate")
    protected WebElement startDate;

    @FindBy(id = "CreateAdDatePicker-endDate")
    protected WebElement endDate;

    @FindBy(id = "Linkstextfield0")
    protected WebElement linkInput;

    @FindBy(id = "Link_Preview")
    protected WebElement linkPreviewInput;

    @FindBy(id = "Presupuestotextfield0")
    protected WebElement budgetInput;

    @FindBy(xpath = "(//input[@placeholder='Buscar...'])[1]")
    protected WebElement placesInput;

    @FindBy(xpath = "//*[contains(text(),'País')]")
    protected WebElement countryOption;

    @FindBy(xpath = "//*[contains(text(),'Región')]")
    protected WebElement regionOption;

    @FindBy(xpath = "//*[contains(text(),'Ciudad')]")
    protected WebElement cityOption;

    @FindBy(xpath = "//*[contains(text(),'Código Postal')]")
    protected WebElement codeOption;

    @FindBy(xpath = "//*[contains(text(),'Todos')]")
    protected WebElement allPlacesOption;

    @FindBy(xpath = "(//*[contains(text(),'Buscar')])[1]")
    protected WebElement searchPlacesButton;

    @FindBy(xpath = "(//*[contains(text(),'Agregar')])[1]")
    protected WebElement addPlacesButton;

    @FindBy(xpath = "(//*[contains(text(),'Agregar')])[2]")
    protected WebElement addPSegmentationButton;

    @FindBy(xpath = "//div[contains(text(),'Segmentación por Lugar')]")
    protected WebElement placesDropdown;

    @FindBy(xpath = "//*[contains(text(),'Aceptar')]")
    protected WebElement acceptPlacesButton;

    @FindBy(xpath = "//*[contains(text(),'Comportamientos')]")
    protected WebElement behaviourOption;

    @FindBy(xpath = "//*[contains(text(),'Eventos de Vida')]")
    protected WebElement lifeEventOption;

    @FindBy(xpath = "//*[contains(text(),'Industrias')]")
    protected WebElement industryOption;

    @FindBy(xpath = "//*[contains(text(),'Estatus Familiar')]")
    protected WebElement familyStatusOption;

    @FindBy(xpath = "//*[contains(text(),'Situaciones Sentimentales')]")
    protected WebElement sentimentalSituationOption;

    @FindBy(xpath = "//*[contains(text(),'Educación')]")
    protected WebElement educationOption;

    @FindBy(xpath = "(//*[contains(text(),'Select...')])[2]")
    protected WebElement segmentationDropdown;

    @FindBy(id = "react-select-23-input")
    protected WebElement startAgeInput;

    @FindBy(id = "react-select-24-input")
    protected WebElement endAgeInput;

    @FindBy(id = "inputTest")
    protected WebElement uploadFile;

    @FindBy(xpath = "//*[contains(text(),'Crear Campaña')]")
    protected WebElement campaignCreationButton;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[1]")
    protected WebElement emptyProductError;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[2]")
    protected WebElement emptyAdminAccountError;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[3]")
    protected WebElement minimumCharactersMainTextError;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[4]")
    protected WebElement minimumCharactersTitleError;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[5]")
    protected WebElement emptyCallActionError;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[6]")
    protected WebElement emptyURLError;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[7]")
    protected WebElement emptyBudgetError;

    @FindBy(xpath = "(//*[contains(@style,'color: red')])[8]")
    protected WebElement emptyLocationError;

    private WebDriver driver;
    private WebDriverWait wait;

    public CreationCampaign(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public boolean mainTitleExist(){
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.isDisplayed();
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

    public void clickCampaignObjectiveDropdown(String optionString) {
        wait.until(ExpectedConditions.visibilityOf(campaignObjectiveDropdown));
        this.campaignObjectiveDropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();
    }

    public void clickNewsSectionFacebookOption() {
        wait.until(ExpectedConditions.visibilityOf(newSectionFacebookOption));
        this.newSectionFacebookOption.click();
    }

    public void clickAllLocationsPlatformsOptions() {
        wait.until(ExpectedConditions.visibilityOf(newSectionFacebookOption));
        this.newSectionFacebookOption.click();
        this.articlesFacebookOption.click();
        this.marketplaceFacebookOption.click();
        this.videosFacebookOption.click();
        this.storiesFacebookOption.click();
        this.resultsFacebookOption.click();
        this.newsInstagramOption.click();
        this.storiesInstagramOption.click();
        this.exploreInstagramOption.click();
    }


    public void clickSelectProductDropdown(String optionString) {
        wait.until(ExpectedConditions.visibilityOf(selectProductDropdown));
        this.selectProductDropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        option.click();
    }

    public void clickAdAccount (String optionString) {
        wait.until(ExpectedConditions.visibilityOf(addAccountDropdown));
        this.addAccountDropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        option.click();
    }

    public void clickFanPageDropdown(String optionString) {
        wait.until(ExpectedConditions.visibilityOf(fanPageDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(fanPageDropdown));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.fanPageDropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        option.click();
    }

    public boolean enterOptionalNameInput(String name){
        for (int i=0;i<2;i++){
            if (optionalNameInput.isDisplayed()){
                optionalNameInput.sendKeys(name);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public boolean enterMainTextInput(String text){
        for (int i=0;i<2;i++){
            if (mainTextInput.isDisplayed()){
                mainTextInput.sendKeys(text);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public boolean enterSecondMainTextInput(String text){
        for (int i=0;i<2;i++){
            if (mainTextInput2.isDisplayed()){
                mainTextInput2.sendKeys(text);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
            }
        }
        return false;
    }

    public boolean enterThirdMainTextInput(String text){
        for (int i=0;i<2;i++){
            if (mainTextInput3.isDisplayed()){
                mainTextInput3.sendKeys(text);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
            }
        }
        return false;
    }
    public void clickAddMainTextInput(){
        addMainText.click();
    }

    public boolean enterTitleInput(String title){
        for (int i=0;i<2;i++){
            if (titleInput.isDisplayed()){
                titleInput.sendKeys(title);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public boolean enterSecondTitleInput(String title){
        for (int i=0;i<2;i++){
            if (titleInput2.isDisplayed()){
                titleInput2.sendKeys(title);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
            }
        }
        return false;
    }
    public boolean enterThirdTitleInput(String title){
        for (int i=0;i<2;i++){
            if (titleInput3.isDisplayed()){
                titleInput3.sendKeys(title);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
            }
        }
        return false;
    }

    public void clickAddTitleInput(){
        addtitleInput.click();
    }

    public boolean enterDescriptionInput(String description){
        for (int i=0;i<2;i++){
            if (descriptionInput.isDisplayed()){
                descriptionInput.sendKeys(description);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public void clickCallActionDropdown(String optionString) {
        wait.until(ExpectedConditions.visibilityOf(callActionDropdown));
        this.callActionDropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();
    }

    public int getDifferenceBetweenDates(){
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaInicio = date.parse(startDate.getAttribute("value"));
            Date fechaFinal = date.parse(endDate.getAttribute("value"));
            int milisecondsByDay = 86400000;
            int dias = (int) ((fechaFinal.getTime()-fechaInicio.getTime()) / milisecondsByDay);
            return dias;
        } catch (ParseException e) {
            return 0;
        }
    }

    public boolean enterLinkInput(String link){
        for (int i=0;i<2;i++){
            if (linkInput.isDisplayed()){
                linkInput.sendKeys(link);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public boolean enterBudgetInput(String budget){
        for (int i=0;i<2;i++){
            if (budgetInput.isDisplayed()){
                budgetInput.sendKeys(budget);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public boolean clickCountryOption(){
        for (int i=0;i<2;i++){
            if (countryOption.isDisplayed()){
                countryOption.click();
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public boolean enterPlacesInput(String place){
        for (int i=0;i<2;i++){
            if (placesInput.isDisplayed()){
                placesInput.sendKeys(place);
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public void clickSearchPlacesButton(){
        searchPlacesButton.click();
    }

    public void clickAddPlacesButton(){
        addPlacesButton.click();
    }

    public void clickPlacesDropdown(String optionString) {
        wait.until(ExpectedConditions.elementToBeClickable(placesDropdown));
        this.placesDropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();
    }

    public boolean clickCityOption(){
        for (int i=0;i<2;i++){
            if (cityOption.isDisplayed()){
                cityOption.click();
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }


    public void clickRegionButton(){
        regionOption.click();
    }

    public void clickCodeButton(){
        codeOption.click();
    }

    public void clickAllPlacesButton(){
        allPlacesOption.click();
    }

    public void clickAcceptPlacesButton(){
        acceptPlacesButton.click();
    }

    public boolean clickBehaviourOption(){
        for (int i=0;i<2;i++){
            if (behaviourOption.isDisplayed()){
                behaviourOption.click();
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public void clickLifeEventOption(){
        lifeEventOption.click();
    }

    public void clickIndustryOption(){
        industryOption.click();
    }

    public void clickSentimentalSituationOption(){
        sentimentalSituationOption.click();
    }

    public void clickFamilyStatusOption(){
        familyStatusOption.click();
    }

    public void clickEducationOption(){
        educationOption.click();
    }

    public void clickSegmentationDropdown(String optionString) {
        for (int i=0;i<5;i++){
            if (!segmentationDropdown.isDisplayed()){
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,30)");
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.segmentationDropdown.click();
        WebElement option = driver.findElement(By.xpath("//*[contains(text(),'"+optionString+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();
    }

    public void clickAddSegmentationButton(){
        addPSegmentationButton.click();
    }

    public boolean  enterAgeRange(String start, String end){
        for (int i=0;i<2;i++){
            if (startAgeInput.isDisplayed()){
                startAgeInput.sendKeys(start);
                startAgeInput.sendKeys(Keys.TAB);
                endAgeInput.sendKeys(end);
                endAgeInput.sendKeys(Keys.TAB);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public void uploadFile(String path){
        if (!uploadFile.isDisplayed())((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
        uploadFile.sendKeys(path);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean clickCampaignCreationButton(){
        for (int i=0;i<5;i++){
            if (campaignCreationButton.isDisplayed()){
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
                campaignCreationButton.click();
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public boolean clickFemaleGenderOption(){
        for (int i=0;i<3;i++){
            if (femaleGender.isDisplayed()){
                femaleGender.click();
                return true;
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return false;
    }

    public String productErrorExist(){
        for (int i=0;i<3;i++){
            if (emptyProductError.isDisplayed()){
                return emptyProductError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

    public String adminAccountErrorExist(){
        for (int i=0;i<3;i++){
            if (emptyAdminAccountError.isDisplayed()){
                return emptyAdminAccountError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

    public String mainTextErrorExist(){
        for (int i=0;i<3;i++){
            if (minimumCharactersMainTextError.isDisplayed()){
                return minimumCharactersMainTextError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

    public String titleErrorExist(){
        for (int i=0;i<3;i++){
            if (minimumCharactersTitleError.isDisplayed()){
                return minimumCharactersTitleError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

    public String callActionErrorExist(){
        for (int i=0;i<3;i++){
            if (emptyCallActionError.isDisplayed()){
                return emptyCallActionError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

    public String URLErrorExist(){
        for (int i=0;i<3;i++){
            if (emptyURLError.isDisplayed()){
                return emptyURLError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

    public String budgetErrorExist(){
        for (int i=0;i<3;i++){
            if (emptyBudgetError.isDisplayed()){
                return emptyBudgetError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

    public String locationErrorExist(){
        for (int i=0;i<3;i++){
            if (emptyLocationError.isDisplayed()){
                return emptyLocationError.getText();
            }else {
                ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
            }
        }
        return "Error";
    }

}
