import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        tags = "",
        plugin = {"pretty","html:target/cucumber-report",
                "timeline:test-output-thread/"}
)
public class TestRunner
{

}