package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class betWaySteps {

    WebDriver driver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("User is on scores-fixtures page")
    public void user_is_on_scores_fixtures_page() {
        driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
        driver.manage().window().maximize();
        String Title = driver.getTitle();
        System.out.println("page title" + Title);
    }

    @Then("User gets all team names with a match today")
    public void user_gets_all_team_names_with_a_match_today() {

        List<WebElement> teams = driver.findElements(By.className("sp-c-fixture__team-name-wrap"));
        if (teams.size() > 0) {
            for (WebElement element : teams) {
                System.out.println("Team name:" + element.getText());
            }
        } else {
            System.out.println("No teams found");
        }
    }

    // search steps
    @When("User enter text {string} in search textbox")
    public void user_enter_text_in_search_textbox(String string) {
        System.out.println("String from feature file" + string);
        driver.findElement(By.id("orb-search-q")).sendKeys(string);
    }

    @When("User click on search button")
    public void user_click_on_search_button() {
        driver.findElement(By.className("se-searchbox__submit")).click();
    }

    @Then("User should see the corresponding articles related to sports")
    public void user_should_see_the_corresponding_articles_related_to_sports() {
        List<WebElement> results = driver.findElements(By.xpath("//ul[@role='list']//div[contains(@class,'Promo')]"));
        if (results.size() > 0) {
            System.out.println("user get the related articles");
        }
    }

    @Then("Output the first heading and the last heading returned on the page")
    public void output_the_first_heading_and_the_last_heading_returned_on_the_page() {
        List<WebElement> results = driver.findElements(By.xpath("//ul[@role='list']//div[contains(@class,'Promo')]"));
        System.out.println("First result..." + results.get(0).getText());
        System.out.println("Last result..." + results.get(results.size() - 3).getText());
    }

    // sign in steps
    @Given("I am on scores-fixtures page")
    public void i_am_on_scores_fixtures_page() {
        driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
        String Title = driver.getTitle();
        System.out.println("page title" + Title);
    }

    @Given("I navigate to login page")
    public void i_navigate_to_login_page() throws InterruptedException {
        driver.findElement(By.id("idcta-username")).click();
        Thread.sleep(3000);
    }

    @When("I attempt to login with correct {string} and incorrect {string}")
    public void i_attempt_to_login_with_correct_and_incorrect(String userName, String pwd) {
        driver.findElement(By.id("user-identifier-input")).sendKeys(userName);
        driver.findElement(By.id("password-input")).sendKeys(pwd);
        driver.findElement(By.id("submit-button")).click();

    }

    @Then("my login attempt should fail with wrong password {string}")
    public void my_login_attempt_should_fail_with_wrong_password(String errMsg) {
        String ActErrMsg = driver.findElement(By.xpath("//body")).getText();
        Assert.assertTrue(ActErrMsg.contains(errMsg));
    }

    @When("I attempt to login with incorrect {string} and correct {string}")
    public void i_attempt_to_login_with_incorrect_and_correct(String userName, String pwd) {
        driver.findElement(By.id("user-identifier-input")).sendKeys(userName);
        driver.findElement(By.id("password-input")).sendKeys(pwd);
        driver.findElement(By.id("submit-button")).click();

    }

    @Then("my login attempt should fail with wrong username {string}")
    public void my_login_attempt_should_fail_with_wrong_username(String errMsg) {
        String ActErrMsg = driver.findElement(By.xpath("//body")).getText();
        Assert.assertTrue(ActErrMsg.contains(errMsg));

    }

    @After
    public void tearDown() {
        driver.close();
    }


}
