package cucumber.src.test.java;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="training/src/cucumber/src/test/resources/features",
        plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",

                "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", "junit:target/cucumber- results.xml"},
        tags={"@cngz"}
)

public class Runner {

}