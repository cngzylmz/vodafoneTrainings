package vodafoneTrainings2.src.main.java.pages;

import org.openqa.selenium.WebElement;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class BasePage {
    public Dictionary<String, WebElement> pageElements;
    public Dictionary<String, WebElement> commonElements;

    public BasePage() {

        this.pageElements = new Hashtable<>();
        this.commonElements = new Hashtable<>();

    }
}