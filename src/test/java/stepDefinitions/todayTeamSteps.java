package stepDefinitions;

import base.baseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Properties;

public class todayTeamSteps {

    WebDriver driver;


    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("User is on scores-fixtures page")
    public void user_is_on_scores_fixtures_page() {
       // driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
        driver.get("https://www.bbc.co.uk/search?q=sports");
        String Title=driver.getTitle();
        System.out.println("page title"+Title);
    }

    @Then("User gets all team names with a match today")
    public void user_gets_all_team_names_with_a_match_today() {

       // List<WebElement> results = driver.findElements(By.tagName("//ul[@role='list']/li"));
        List<WebElement> results =  driver.findElements(By.xpath("//ul[@role='list']//div[contains(@class,'Promo')]"));

        System.out.println("First result"+results.get(0).getText());

        System.out.println("Last result"+results.get(results.size()-1).getText());






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



}
