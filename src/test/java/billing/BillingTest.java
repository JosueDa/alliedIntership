package billing;

import POMs.Billing;
import POMs.DownloadCSV;
import POMs.Home;
import POMs.Login;
import Utils.InitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BillingTest extends InitDriver {

    Login login;
    Home home;
    Billing billing;
    String pass="morales12345";
    String email="josuemorales123@gmail.com";
    String OTP="667883";
    String cardNumber="4916155306410884";
    String cardName="Name Test";
    String CVV="230";

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
        home.clickPhotoButton();
        home.clickBillingButton();
        billing= new Billing(driver,wait);
        Assert.assertTrue(billing.mainTitleExist());
   }

    @Test(priority = 2, dependsOnMethods = "Login")
    public void setProduct() {
        billing.clickFirstProduct();
        billing.clickProceedToPay();
        Assert.assertTrue(billing.titleExist("Detalles de Tarjeta"));
    }

    @Test(priority = 3, dependsOnMethods = "setProduct")
    public void setData() {
        billing.enterCardNumber(cardNumber);
        billing.enterCardName(cardName);
        billing.enterExpireMonth(3);
        billing.enterExpireYear(5);
        billing.enterCCVCode(CVV);
        billing.clickAcceptCheck();
        Assert.assertTrue(billing.confirmButtonExist());
        billing.clickConfirmPayment();
    }

    @AfterClass()
    void end() {
        System.out.println("End of " + this.getClass().getSimpleName() + " test class");
        driver.close();
    }
}