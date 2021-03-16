package StepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src\\test\\resources\\features\\buymeat.feature",
        glue = "StepDefinitions",
        monochrome = true,
        tags = "@smoke",
        plugin = {"pretty", "html:target/HtmlReports/htmlresults.html"

        }
)


public class TestRunner {
}
