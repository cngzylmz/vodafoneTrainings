package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Hashtable;

public class BasketPage extends BasePage {

    public Hashtable<String, WebElement> basketElements;

    @FindBy(id = "basket-item-count")
    WebElement basketItemCount;
    @FindBy(id = "continue_step_btn")
    WebElement finishShopping;
    @FindBy(xpath = "//input[@name='quantity']")
    WebElement basketItemQuantity;
    @FindBy(css = "delete_all_2uTds")
    WebElement deleteSelectedProducts;
    @FindBy(css = "red_3m-Kl")
    WebElement deleteSelectedProductsApprove;

    public BasketPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.basketElements = new Hashtable<>();
        basketElements.put("basket item count", basketItemCount);
        basketElements.put("basket item quantity", basketItemQuantity);
        basketElements.put("finish shopping", finishShopping);

        basketElements.put("delete all selected products", deleteSelectedProducts);
        basketElements.put("delete selected products approve", deleteSelectedProductsApprove);

        this.pageElements = basketElements;
    }
}
