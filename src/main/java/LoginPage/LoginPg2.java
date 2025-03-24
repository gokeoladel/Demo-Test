package LoginPage;

import library.Constants;
import library.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static library.locators.*;

public class LoginPg2 {
    private WebDriver driver;

    // Constructor to initialize WebDriver
   public LoginPg2(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }

   public void loginToSauceDemo(String username, String password){
       driver.findElement(USERNAME_FIELD).clear();
       driver.findElement(USERNAME_FIELD).sendKeys(Constants.USERNAME);
       driver.findElement(PASSWORD_FIELD).clear();
       driver.findElement(PASSWORD_FIELD).sendKeys(Constants.PASSWORD);
   }

   public void login_button(){
       driver.findElement(LOGIN_BUTTON).click();
   }
}
