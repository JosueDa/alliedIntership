package DownloadReports;

import POMs.DownloadCSV;
import POMs.Home;
import POMs.Login;
import Utils.InitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DownloadCSVTest extends InitDriver {

    Login login;
    Home home;
    DownloadCSV downloadCSV;
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

    @Test(priority = 1, dependsOnMethods = "Login")
    public void downloadCSVScreen() {
        home.clickDropdownButton();
        home.clickDropdownOptionButton();
        home.clickPhotoButton();
        home.clickCreateCampaignButton();
        downloadCSV= new DownloadCSV(driver,wait);
        Assert.assertTrue(downloadCSV.titleExist());
   }

    @Test(priority = 2, dependsOnMethods = "Login")
    public void setDates() {
        downloadCSV.setStartDate("5");
        downloadCSV.setEndDate("20");
    }

    @Test(priority = 3, dependsOnMethods = "Login")
    public void selectCompany() {
        downloadCSV.clickSendButton();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(downloadCSV.downloadCSVButtonExist());
        soft.assertTrue(downloadCSV.downloadCSVImagesButtonExist());
    }

    @Test(priority = 4, dependsOnMethods = "selectCompany")
    public void setNameAndDownload() {
        downloadCSV.enterFileNameInput("File TestName");
        downloadCSV.clickDownloadCSVImagesButton();
        downloadCSV.clickDownloadCSVButton();
    }

    @AfterClass()
    void end() {
        System.out.println("End of " + this.getClass().getSimpleName() + " test class");
        driver.close();
    }
}