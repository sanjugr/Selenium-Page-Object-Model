package testcases;

import base.SeleniumBase;
import org.testng.annotations.Test;
import pageobjects.LandingPageObject;
import pageobjects.LoginPageObject;

public class LoginTest extends SeleniumBase {

    @Test
    public void loginTestFromExcel() throws Exception {
        LandingPageObject landing = new LandingPageObject(driver);

        System.out.println(landing.getLandingPageTitle());
        landing.navigateToLoginPage();

        LoginPageObject loginPage = new LoginPageObject(driver);

        String userName = excel.getCellData(1,0);
        String password = excel.getCellData(1,1);
        System.out.println("userName -> " + userName);
        System.out.println("password -> " + password);

        loginPage.login(userName, password);
    }
}

