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

public class CreateCampaignErrorHandlingTest extends InitDriver {

    Login login;
    Home home;
    CreationCampaign creationCampaign;
    String pass="";
    String email="";
    String OTP="";

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
        creationCampaign.clickNewsSectionFacebookOption();
        Assert.assertTrue(creationCampaign.titleExist("Producto"));
    }

    @Test(priority = 4, dependsOnMethods = "selectCampaignObjective")
    public void missingProductErrorExist() {
        creationCampaign.clickCampaignCreationButton();
        Assert.assertEquals(creationCampaign.productErrorExist(),"Seleccione un Producto");
        System.out.println("Error obtenido al no ingresar un producto: "+creationCampaign.productErrorExist());
    }

    @Test(priority = 5, dependsOnMethods = "selectCampaignObjective")
    public void missingAdminAccountErrorExist() {
        Assert.assertEquals(creationCampaign.adminAccountErrorExist(),"Seleccione una Cuenta Administradora");
        System.out.println("Error obtenido al no ingresar una cuenta adinistradora: "+creationCampaign.adminAccountErrorExist());
    }

    @Test(priority = 6, dependsOnMethods = "selectCampaignObjective")
    public void minimumMainTextErrorExist() {
        Assert.assertEquals(creationCampaign.mainTextErrorExist(),"30 Caracteres Mínimo");
        System.out.println("Error obtenido al no ingresar un Texto Principal: "+creationCampaign.mainTextErrorExist());
    }

    @Test(priority = 7, dependsOnMethods = "selectCampaignObjective")
    public void minimumTitleErrorExist() {
        Assert.assertEquals(creationCampaign.titleErrorExist(),"10 Caracteres Mínimo");
        System.out.println("Error obtenido al no ingresar un título: "+creationCampaign.titleErrorExist());
    }

    @Test(priority = 8, dependsOnMethods = "selectCampaignObjective")
    public void missingCallActionErrorExist() {
        Assert.assertEquals(creationCampaign.callActionErrorExist(),"Seleccione una Llamada a la acción");
        System.out.println("Error obtenido al no ingresar una llamada de acción: "+creationCampaign.callActionErrorExist());
    }

    @Test(priority = 9, dependsOnMethods = "selectCampaignObjective")
    public void minimumURLErrorExist() {
        Assert.assertEquals(creationCampaign.URLErrorExist(),"Debe de ingresar una URL válida");
        System.out.println("Error obtenido al no ingresar un URL: "+creationCampaign.URLErrorExist());
    }

    @Test(priority = 10, dependsOnMethods = "selectCampaignObjective")
    public void emptyBudgetErrorExist() {
        Assert.assertEquals(creationCampaign.budgetErrorExist(),"Debe de ingresar un valor numérico válido");
        System.out.println("Error obtenido al no ingresar un presupuesto: "+creationCampaign.budgetErrorExist());
    }

    @Test(priority = 11, dependsOnMethods = "selectCampaignObjective")
    public void minimumBudgetErrorExist() {
        creationCampaign.enterBudgetInput("1");
        Assert.assertEquals(creationCampaign.budgetErrorExist(),"Debe de ingresar un valor mayor a 3(el mínimo es 1 diario)");
        System.out.println("Error obtenido al no ingresar un presupuesto menor al necesario: "+creationCampaign.budgetErrorExist());
    }

    @Test(priority = 12, dependsOnMethods = "selectCampaignObjective")
    public void missingLocationErrorExist() {
        Assert.assertEquals(creationCampaign.locationErrorExist(),"Favor Ingrese una Locación");
        System.out.println("Error obtenido al no ingresar una ubicación: "+creationCampaign.locationErrorExist());
    }

    @Test(priority =13, dependsOnMethods = "missingLocationErrorExist")
    public void placeHierarchyValidation () {
        creationCampaign.clickCountryOption();
        creationCampaign.enterPlacesInput("Guatemala");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("Guatemala");
        creationCampaign.clickAddPlacesButton();
        creationCampaign.clickCityOption();
        creationCampaign.enterPlacesInput("Guatemala");
        creationCampaign.clickSearchPlacesButton();
        creationCampaign.clickPlacesDropdown("Ciudad de Guatemala");
        creationCampaign.clickAddPlacesButton();
        Assert.assertTrue(creationCampaign.titleExist("No se agregará ya que se tiene seleccionado el país completo"));
        System.out.println("Validación de jerarquía al seleccionar el lugar correcta");
        creationCampaign.clickAcceptPlacesButton();
    }

    @AfterClass()
    void end() {
        System.out.println("End of " + this.getClass().getSimpleName() + " test class");
        driver.close();
    }
}

