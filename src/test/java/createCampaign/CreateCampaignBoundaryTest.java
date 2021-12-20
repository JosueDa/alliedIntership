package createCampaign;

import POMs.CreationCampaign;
import POMs.Home;
import POMs.Login;
import Utils.InitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class CreateCampaignBoundaryTest extends InitDriver {

    Login login;
    Home home;
    CreationCampaign creationCampaign;
    String pass="";
    String email="";
    String OTP="942758";
    File image1 = new File("C:\\Users\\josue\\Documents\\Intership\\src\\test\\java\\files\\1.jpg");
    File image2 = new File("C:\\Users\\josue\\Documents\\Intership\\src\\test\\java\\files\\2.jpg");

    @Test(priority = 1)
    public void Login() {
        driver.get("http://web-app-lb-534600123.us-east-2.elb.amazonaws.com/login");
        login= new Login(driver,wait);
        login.clickLoginButton();
        login.clickSignInButton();
        login.enterEmail(email);
        login.enterPass(pass);
        login.clickFacebookLoginButton();
        login.enterOTP(OTP);
        login.clickCheckpointSubmitButton();
        login.clickCheckpointSubmitButton();
        home= new Home(driver,wait);
        Assert.assertTrue(home.titleExist());
    }

    @Test(priority = 2, dependsOnMethods = "Login")
    public void createCampaignScreen() {
        home.clickDropdownButton();
        home.clickDropdownOptionButton();
        home.clickHamburgerButton();
        home.clickCreateCampaignButton();
        creationCampaign=new CreationCampaign(driver,wait);
        Assert.assertTrue(creationCampaign.mainTitleExist());
   }

    @Test(priority = 3, dependsOnMethods = "createCampaignScreen")
    public void selectCampaignObjective() {
        creationCampaign.clickCampaignObjectiveDropdown("Generación de clientes potenciales");
        Assert.assertTrue(creationCampaign.titleExist("Ubicaciones en plataforma Facebook"));
    }

    @Test(priority = 4, dependsOnMethods = "selectCampaignObjective")
    public void selectPlatformLocations() {
        creationCampaign.clickAllLocationsPlatformsOptions();
        Assert.assertTrue(creationCampaign.titleExist("Producto"));
    }

    @Test(priority = 5, dependsOnMethods = "selectPlatformLocations")
    public void selectProductAndAssets() {
        creationCampaign.clickSelectProductDropdown("Producto Generico");
        creationCampaign.clickAdAccount("Aly-Ai");
        creationCampaign.clickFanPageDropdown("Personal | Digital Derma");
        //a form selection is missing
        Assert.assertTrue(creationCampaign.titleExist("Nombre de Campaña (Opcional)"));
    }

    @Test(priority = 6, dependsOnMethods = "selectProductAndAssets")
    public void fillOptionalName() {
        Assert.assertTrue(creationCampaign.enterOptionalNameInput("TestName"));
    }

    @Test(priority = 7, dependsOnMethods = "fillOptionalName")
    public void fillThreeMainText() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(creationCampaign.enterMainTextInput("Main test text minimum thirty characters "));
        creationCampaign.clickAddMainTextInput();
        soft.assertTrue(creationCampaign.enterSecondMainTextInput("Second main test text minimum thirty characters "));
        creationCampaign.clickAddMainTextInput();
        soft.assertTrue(creationCampaign.enterThirdMainTextInput("Third main test text minimum thirty characters "));
        soft.assertAll();
    }

    @Test(priority = 8, dependsOnMethods = "fillThreeMainText")
    public void fillThreeAdTitles() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(creationCampaign.enterTitleInput("First ad title 10 characters minimum"));
        creationCampaign.clickAddTitleInput();
        soft.assertTrue(creationCampaign.enterSecondTitleInput("Second ad title 10 characters minimum"));
        creationCampaign.clickAddTitleInput();
        soft.assertTrue(creationCampaign.enterThirdTitleInput("Third ad title 10 characters minimum"));
        soft.assertAll();
    }

    @Test(priority = 9, dependsOnMethods = "fillThreeAdTitles")
    public void selectCallAction() {
        creationCampaign.clickCallActionDropdown("Cotizar");
        Assert.assertTrue(creationCampaign.titleExist("Programar duración de la campaña"));
    }

    @Test(priority =10, dependsOnMethods = "selectCallAction")
    public void campaignDuration() {
        Assert.assertEquals(creationCampaign.getDifferenceBetweenDates(),2);
    }

    @Test(priority =11, dependsOnMethods = "campaignDuration")
    public void websiteLinkAndBudget() {
        creationCampaign.enterLinkInput("www.aly-ai.com");
        creationCampaign.enterBudgetInput("7");
        Assert.assertTrue(creationCampaign.titleExist("Lugares"));
    }

    @Test(priority =12, dependsOnMethods = "websiteLinkAndBudget")
    public void addLocation () {
        creationCampaign.clickCountryOption();
        creationCampaign.enterPlacesInput("Guatemala");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("Guatemala");
        creationCampaign.clickAddPlacesButton();

        creationCampaign.clickRegionButton();
        creationCampaign.enterPlacesInput("Colombia");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("Santander");
        creationCampaign.clickAddPlacesButton();

        creationCampaign.clickCityOption();
        creationCampaign.enterPlacesInput("Tokio");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("Minato");
        creationCampaign.clickAddPlacesButton();

        creationCampaign.clickCodeButton();
        creationCampaign.enterPlacesInput("28001");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("España");
        creationCampaign.clickAddPlacesButton();

        creationCampaign.clickAllPlacesButton();
        creationCampaign.enterPlacesInput("Honduras");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("La Paz");
        creationCampaign.clickAddPlacesButton();
    }

    @Test(priority =13, dependsOnMethods = "addLocation")
    public void segmentationFields () {
        creationCampaign.clickBehaviourOption();
        creationCampaign.clickSegmentationDropdown("Viajeros frecuentes");
        creationCampaign.clickAddSegmentationButton();
        Assert.assertTrue(creationCampaign.titleExist("Viajeros frecuentes"));

        creationCampaign.clickLifeEventOption();
        creationCampaign.clickSegmentationDropdown("Recién casados (1 año)");
        creationCampaign.clickAddSegmentationButton();
        Assert.assertTrue(creationCampaign.titleExist("Recién casados (1 año)"));

        creationCampaign.clickIndustryOption();
        creationCampaign.clickSegmentationDropdown("Negocios y finanzas");
        creationCampaign.clickAddSegmentationButton();
        Assert.assertTrue(creationCampaign.titleExist("Negocios y finanzas"));

        creationCampaign.clickFamilyStatusOption();
        creationCampaign.clickSegmentationDropdown("Padres (todos)");
        creationCampaign.clickAddSegmentationButton();
        Assert.assertTrue(creationCampaign.titleExist("Padres (todos)"));

        creationCampaign.clickSentimentalSituationOption();
        creationCampaign.clickSegmentationDropdown("Soltero (a)");
        creationCampaign.clickAddSegmentationButton();
        Assert.assertTrue(creationCampaign.titleExist("Soltero (a)"));

        creationCampaign.clickEducationOption();
        creationCampaign.clickSegmentationDropdown("Estudios universitarios en curso");
        creationCampaign.clickAddSegmentationButton();
        Assert.assertTrue(creationCampaign.titleExist("Estudios universitarios en curso"));
    }

    @Test(priority =14, dependsOnMethods = "addLocation")
    public void ageAndUploadFiles (){
        creationCampaign.enterAgeRange("20","40");
        creationCampaign.clickFemaleGenderOption();
        creationCampaign.uploadFile(image1.getAbsolutePath());
        //creationCampaign.clickCampaignCreationButton();
    }

    @AfterClass()
    void end() {
        System.out.println("End of " + this.getClass().getSimpleName() + " test class");
        driver.close();
    }
}

