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

public class CreateCampaignTest extends InitDriver {

    Login login;
    Home home;
    CreationCampaign creationCampaign;
    String pass="";
    String email="";
    String OTP="";
    File image1 = new File("src/test/java/files/1.jpg");

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
        home.clickHamburgerButton();
        home.clickCreateCampaignButton();
        creationCampaign=new CreationCampaign(driver,wait);
        Assert.assertTrue(creationCampaign.mainTitleExist());
   }

    @Test(priority = 3, dependsOnMethods = "createCampaignScreen")
    public void selectCampaignObjective() {
        creationCampaign.clickCampaignObjectiveDropdown();
        Assert.assertTrue(creationCampaign.titleExist("Ubicaciones en plataforma Facebook"));
    }

    @Test(priority = 4, dependsOnMethods = "selectCampaignObjective")
    public void selectPlatformLocations() {
        creationCampaign.clickNewsSectionFacebookOption();
        Assert.assertTrue(creationCampaign.titleExist("Producto"));
    }

    @Test(priority = 5, dependsOnMethods = "selectPlatformLocations")
    public void selectProductAndAssets() {
        creationCampaign.clickSelectProductDropdown();
        creationCampaign.clickAdAccount();
        creationCampaign.clickFanPageDropdown();
        //a form selection is missing
        Assert.assertTrue(creationCampaign.titleExist("Nombre de Campaña (Opcional)"));
    }

    @Test(priority = 6, dependsOnMethods = "selectProductAndAssets")
    public void fillDataInputs() {
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(creationCampaign.enterOptionalNameInput("TestName"));
        soft.assertTrue(creationCampaign.enterMainTextInput("Main test text minimum thirty characters "));
        soft.assertTrue(creationCampaign.enterTitleInput("Title test"));
        soft.assertTrue(creationCampaign.enterDescriptionInput("Test description"));
        soft.assertAll();
    }

    @Test(priority = 7, dependsOnMethods = "fillDataInputs")
    public void selectCallAction() {
        creationCampaign.clickCallActionDropdown("Cotizar");
        Assert.assertTrue(creationCampaign.titleExist("Programar duración de la campaña"));
    }

    @Test(priority =8, dependsOnMethods = "selectCallAction")
    public void campaignDuration() {
        Assert.assertEquals(creationCampaign.getDifferenceBetweenDates(),2);
    }

    @Test(priority =9, dependsOnMethods = "campaignDuration")
    public void websiteLinkAndBudget() {
        creationCampaign.enterLinkInput("www.aly-ai.com");
        creationCampaign.enterBudgetInput("3");
        Assert.assertTrue(creationCampaign.titleExist("Lugares"));
    }

    @Test(priority =10, dependsOnMethods = "websiteLinkAndBudget")
    public void addPlaceValidation () {
        creationCampaign.clickCountryOption();
        creationCampaign.enterPlacesInput("Guatemala");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("Guatemala");
        creationCampaign.clickAddPlacesButton();
        Assert.assertTrue(creationCampaign.titleExist("Guatemala"));
    }

    @Test(priority =11, dependsOnMethods = "addPlaceValidation")
    public void segmentationFields () {
        creationCampaign.clickBehaviourOption();
        creationCampaign.clickSegmentationDropdown("Viajeros frecuentes");
        creationCampaign.clickAddSegmentationButton();
        Assert.assertTrue(creationCampaign.titleExist("Viajeros frecuentes"));
    }

    @Test(priority =12, dependsOnMethods = "segmentationFields")
    public void ageAndUploadFiles () {
        creationCampaign.enterAgeRange("20","40");
        creationCampaign.uploadFile(image1.getAbsolutePath());
        Assert.assertTrue(creationCampaign.titleExist(image1.getName()));
        //creationCampaign.clickCampaignCreationButton();
    }

    @AfterClass()
    void end() {
        System.out.println("End of " + this.getClass().getSimpleName() + " test class");
        driver.close();
    }
}

