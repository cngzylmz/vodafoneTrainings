package cucumber.src.main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Hashtable;

public class Banner extends BasePage {

    @FindBy(id = "cartItemCount")
    private WebElement basketItemCount;
    @FindBy(id = "shoppingCart")
    private WebElement shoppingCart;
    @FindBy(xpath = "//*[@data-test-id=\"dropdown-toggle\"]")
    private WebElement selectLocationButton;
    @FindBy(css = ".shipping-Select-fake_input")
    private WebElement locationList;
    @FindBy(css = ".css-wk2u0a")
    private WebElement locationSearch;
    @FindBy(xpath = "//*[.='İstanbul']")
    private WebElement locationIstanbul;
    @FindBy(xpath = "//div[contains(text(),'Konum değiştirildi')]")
    private WebElement locationSelectedAlert;
    @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-input']")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@class='SearchBoxOld-buttonContainer']")
    private WebElement searchButton;

    public Hashtable<String, WebElement> bannerElements;

    public Banner(WebDriver driver) {
        super();

        PageFactory.initElements(driver, this);
        this.bannerElements = new Hashtable<>();
        bannerElements.put("basket item count", basketItemCount);
        bannerElements.put("basket button", shoppingCart);

        bannerElements.put("select location button", selectLocationButton);
        bannerElements.put("location list", locationList);
        bannerElements.put("location search", locationSearch);
        bannerElements.put("istanbul", locationIstanbul);
        bannerElements.put("location selected alert", locationSelectedAlert);

        bannerElements.put("search input box", searchInput);
        bannerElements.put("search button", searchButton);

        this.pageElements = bannerElements;
    }


}
