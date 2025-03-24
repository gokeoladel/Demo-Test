package LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class BaseUtil {
    protected WebDriver driver;

    public BaseUtil(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @FindBy(id = "user-name")
    WebElement USERNAME_FD;
    @FindBy(id = "password")
    WebElement PASSWORD_FD;

    public static final By LOGIN_BUTTON = By.id("login-button");
    public void clickLogin(){
        driver.findElement(LOGIN_BUTTON);
    }

    public void waitForUrlContains(String productUrl, By element_locator){
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(productUrl));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.or(ExpectedConditions.urlContains(productUrl),
                ExpectedConditions.visibilityOfElementLocated(element_locator)));
//        driver.findElement(LOGIN_BUTTON);
    }


}
