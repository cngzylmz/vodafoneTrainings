package vodafoneTrainings2.src.main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Hashtable;

public class LoginPage extends BasePage {

    public Hashtable<String, WebElement> loginElements;

    @FindBy(id = "txtEmail")
    private WebElement emailInput;
    @FindBy(xpath = "//*[contains(text(),'Üye olmadan devam et')]")
    private WebElement continueWithoutLogin;

    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.loginElements = new Hashtable<>();

        loginElements.put("continue without login", continueWithoutLogin);
        loginElements.put("email address without login", emailInput);

        this.pageElements = loginElements;
    }
}
