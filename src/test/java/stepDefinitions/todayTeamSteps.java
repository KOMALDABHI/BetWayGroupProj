package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class todayTeamSteps {

    WebDriver driver;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("User is on scores-fixtures page")
    public void user_is_on_scores_fixtures_page() {
        driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
       // driver.get("https://www.bbc.co.uk/search?q=sports");
        String Title=driver.getTitle();
        System.out.println("page title"+Title);
    }

    @Then("User gets all team names with a match today")
    public void user_gets_all_team_names_with_a_match_today() {

        List<WebElement> teams = driver.findElements(By.className("sp-c-fixture__team-name-wrap"));
        if(teams.size()>0){
            for(WebElement element:teams){
                System.out.println("Team name:"+element.getText());
            }
        }
        else {
            System.out.println("No teams found");
        }



    }
    @After
    public  void tearDown()
    {
        driver.close();
    }


}
