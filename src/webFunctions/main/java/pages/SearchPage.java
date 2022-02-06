package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Hashtable;

public class SearchPage extends BasePage {
    public Hashtable<String, WebElement> searchResultsElements;

    @FindBy(xpath = "//div[contains(text(),'Selpak')]")
    WebElement toilerPaperBrand;
    @FindBy(xpath = "//div[@class='horizontalSortingBar-toggle']")
    WebElement orderProduct;
    @FindBy(xpath = "//div[.='En Çok Satanlar']")
    WebElement orderBestseller;
    @FindBy(xpath = "//li[@class='productListContent-item'][1]")
    WebElement firstProduct;
    @FindBy(xpath = "//button[@data-test-id='product-info-button']")
    WebElement addToBasket;

    public SearchPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.searchResultsElements = new Hashtable<>();

        searchResultsElements.put("toilet paper brand", toilerPaperBrand);
        searchResultsElements.put("order product", orderProduct);
        searchResultsElements.put("order best seller", orderBestseller);
        searchResultsElements.put("first product", firstProduct);
        searchResultsElements.put("add to basket", addToBasket);

        this.pageElements = searchResultsElements;
    }
}