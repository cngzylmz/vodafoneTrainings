package vodafoneTrainings2.src.test.java;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import vodafoneTrainings2.src.main.java.WebSteps;
import vodafoneTrainings2.src.main.java.pages.BasePage;

import static org.testng.Assert.fail;

public class MySteps extends BasePage {
    WebSteps websteps;

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) websteps.driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.embed(screenshot, "image/png");
        }
        websteps.driver.quit();
    }

    @Before
    public void beforeScenario() {
        System.out.println("*************Before Scenario***********");
    }

    @When("^I see (.*) page$")
    public void seePage(String page) {

        websteps.seePage(page);
    }

    @When("^I see (.*) element$")
    public void seeElement(String element) {

        websteps.findElement(element).isDisplayed();
    }

    @When("^I initialize (chrome|firefox) driver$")
    public void initializeChromeDriver(String browser) {
        websteps = new WebSteps();
        websteps.initializeDriver(browser);
    }

    @When("^I go to \"([^\"]*)\" url$")
    public void gotoURL(String url) {
        websteps.openUrl(url);
    }

    @When("^I wait (.*) element (\\d+) seconds$")
    public void waitElement(String element, int timeout) throws InterruptedException {
        websteps.waitElement(element, timeout);
    }

    @When("^(?:I )?click element: (\\w+(?: \\w+)*)")
    public void clickElement(String element) {
        try {
            WebElement object = websteps.findElement(element);
            if (object != null) {
                object.click();
                System.out.println("Clicked on object-->" + element);
            } else {
                System.out.println("Could not click on object-->" + element);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @When("^(?:I )?check expected basket count: (\\d+)$")
    public void checkBasket(int count) {
        WebElement object = websteps.findElement("basket item count");
        if (object != null) {
            if (!object.getText().equals(String.valueOf(count))) {
                fail("Expected count : " + count + " actual count : " + object.getText());
            }
        }
    }

    @When("^(?:I )?check expected product quantity: (\\d+)$")
    public void checkQuantity(int count) {
        WebElement object = websteps.findElement("basket item quantity");
        if (object != null) {
            if (!object.getAttribute("value").equals(String.valueOf(count))) {
                fail("Expected count : " + count + " actual count : " + object.getText());
            }
        }
    }

    @When("^I enter \"([^\"]*)\" text to (.*) text area$")
    public void enterText(String text, String element) throws InterruptedException {
        WebElement object;
        object = websteps.findElement(element);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

    @When("^(?:I )?wait for (\\d+) seconds?$")
    public void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (Exception e) {
            fail();
        }
    }

    @When("^I send text \"([^\"]*)\" to  \"([^\"]*)\" element$")
    public void sendText(String value, String element) {
        websteps.enterText(value, element);
    }

    @When("^(?:I )?focus (.*) element and click (.*) element$")
    public void mouseHover(String focus, String click) {
        try {
            Thread.sleep(1000);
            Actions actions = new Actions(websteps.driver);
            WebElement f;
            WebElement c;
            f = websteps.findElement(focus);
            c = websteps.findElement(click);
            actions.moveToElement(f).perform();
            Thread.sleep(500);
            actions.click(c).perform();
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}