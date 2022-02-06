package cucumber.src.main.java;

import org.openqa.selenium.WebElement;

import java.io.IOException;

public interface MainSteps {

    public void initializeDriver(String browser);

    public void seePage(String page);

    public void openUrl(String url);

    public WebElement findElement(String element);

    public WebElement waitElement(String element, int timeout) throws InterruptedException, IOException;

    public void enterText(String text, String element);
}
