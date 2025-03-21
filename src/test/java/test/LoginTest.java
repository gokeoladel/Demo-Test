package test;

import LoginPage.Pages;
import junit.framework.Assert;
import library.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    WebDriver driver;

@Before
    public void openBrowser(){
        driver = library.Browsers.launchBrowser("firefox");
        driver.get(Constants.URL);
}
@After
public void tearDown(){
    driver.quit();
}

@Test
    public void loginWithValidUser() throws InterruptedException {
        Pages login = new Pages(driver);
        login.demoSiteLogin(Constants.USERNAME,Constants.PASSWORD);
        login.clickLoginButton();
        Thread.sleep(2000);

        String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
        String actualUrl = driver.getCurrentUrl();
//    Assert.assertTrue(expectedUrl,actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
}


@Test
    public void loginWithInValidUser(){
        Pages elogin = new Pages(driver);
//        elogin.demoSiteLogin();
        elogin.demoSiteLogin(Constants.USERNAME,Constants.ERRORPASS);
        elogin.clickLoginButton();

    String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
    String actualUrl = driver.getCurrentUrl();
//        Assert.assertFalse();
    Assert.assertEquals(expectedUrl,actualUrl);


}


}
