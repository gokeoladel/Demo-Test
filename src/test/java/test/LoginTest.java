package test;

import LoginPage.LoginPart3;
import LoginPage.LoginPg2;
import LoginPage.Pages;
import junit.framework.Assert;
import library.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static LoginPage.BaseUtil.LOGIN_BUTTON;
import static library.locators.INVENTORY_PAGE;

public class LoginTest {
    WebDriver driver;

@Before
    public void openBrowser(){
        driver = library.Browsers.launchBrowser("Edge");
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

@Test
public void optionTwoLoginTest() {
    LoginPg2 login2 = new LoginPg2(driver);
    login2.loginToSauceDemo(Constants.USERNAME, Constants.PASSWORD);
    login2.login_button();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains("inventory.html"));

    String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl, actualUrl);
}


@Test
public void optionThreeLogin() {
    LoginPart3 login3 = new LoginPart3(driver);
    login3.saucelogin(Constants.USERNAME, Constants.PASSWORD);
    login3.clickLogin();
//    login3.waitForUrlContains("inventory", By.xpath("#login_button_container h3"));
    login3.waitForUrlContains(Constants.PRODUCTPAGEURL, INVENTORY_PAGE);

//    String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
    String actualUrl = driver.getCurrentUrl();
//    Assert.assertEquals(expectedUrl, actualUrl);
    Assert.assertEquals(Constants.EXPECTED_URL, actualUrl);

}



}
