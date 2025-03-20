package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
    public static WebDriver launchBrowser(String browser){
        if(browser.equalsIgnoreCase("Edge"){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }else if(browser.equalsIgnoreCase("Mozilla")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else{
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    }
}
