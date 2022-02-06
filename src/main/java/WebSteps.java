import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;
import pages.Banner;
import pages.BasketPage;
import pages.LoginPage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class WebSteps implements MainSteps {
    public WebDriver driver;
    public BasePage basePage;

    public void initializeDriver(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
    }

    public void seePage(String pageName) {
        switch (pageName) {
            case "banner":
                basePage = new Banner(driver);
                break;
            case "basket":
                basePage = new BasketPage(driver);
                break;
            case "search results":
                basePage = new SearchPage(driver);
                break;
            case "login":
                basePage = new LoginPage(driver);
                break;
            default:
                break;
        }
    }

    public void openUrl(String url) {
        this.driver.navigate().to(url);
        System.out.println(url + " address was reached.");
    }

    public WebElement findElement(String element) {
        try {
            WebElement object;
            object = basePage.pageElements.get(element);
            if (object == null) {
                object = basePage.commonElements.get(element);
            }
            System.out.println("Object found : " + element);
            return object;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail("Element is not found! =>" + element);
            return null;
        }
    }

    public WebElement waitElement(String element, int timeout) throws InterruptedException {
        WebElement object;
        for (int i = 0; i < timeout; i++) {
            try {
                object = findElement(element);
                if (object != null) {
                    return object;
                } else {
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Assert.fail("Waiting element is not found!");
        return null;
    }


    public void enterText(String text, String element) {
        WebElement object;
        object = findElement(element);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

}
