package createCampaign;

import POMs.CreationCampaign;
import POMs.Home;
import POMs.Login;
import Utils.InitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CreateCampaignTest extends InitDriver {

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
        Assert.assertTrue(creationCampaign.titleExist());
    }

    @Test(priority = 3, dependsOnMethods = "createCampaignScreen")
    public void selectCampaignObjective () {

    }

    @AfterClass()
    void end() {
        System.out.println("End of " + this.getClass().getSimpleName() + " test class");
        driver.close();
    }
}

