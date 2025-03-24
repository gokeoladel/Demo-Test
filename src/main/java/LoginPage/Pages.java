package LoginPage;

import library.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {
    private WebDriver driver;

    public Pages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "user-name")
    WebElement username;
    @FindBy (id = "password")
    WebElement password;
    By loginButton = By.id("login-button");

    public void demoSiteLogin(String uname, String paword){
        username.clear();
        username.sendKeys(uname);
        username.clear();
        password.sendKeys(paword);
//        password.sendKeys();
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

}
