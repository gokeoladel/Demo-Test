package LoginPage;

import library.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static library.Constants.PRODUCTPAGEURL;
import static library.locators.INVENTORY_PAGE;

public class LoginPart3 extends BaseUtil{
    public LoginPart3(WebDriver driver){
        super(driver);
    }

    public void saucelogin(String username, String password){
        USERNAME_FD.sendKeys(username);
        PASSWORD_FD.sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(LOGIN_BUTTON).click();
        waitForUrlContains(PRODUCTPAGEURL,INVENTORY_PAGE);
//        waitForElement(element_locator);
    }
//    public void ForUrlContains(String productUrl){
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(productUrl));
//    }



}

