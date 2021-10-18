package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageSteps {
    WebDriver driver;

    @When("User enter text {string} in search textbox")
    public void user_enter_text_in_search_textbox(String string) {
        System.out.println("String from feature file"+string);
        driver.findElement(By.id("orb-search-q")).sendKeys(string);
    }

    @When("User click on search button")
    public void user_click_on_search_button() {
        driver.findElement(By.id("orb-search-button")).click();
    }

    @Then("User should see the corresponding articles related to sports")
    public void user_should_see_the_corresponding_articles_related_to_sports() {
        List<WebElement> results = driver.findElements(By.xpath("//ul[@role='list']//div[contains(@class,'Promo')]"));
        if (results.size() > 0) {
            for (WebElement element : results) {
                System.out.println("Team name:" + element.getText());
            }
        }
    }
    @Then("Output the first heading and the last heading returned on the page")
    public void output_the_first_heading_and_the_last_heading_returned_on_the_page() {
       List<WebElement> results =  driver.findElements(By.xpath("//ul[@role='list']//div[contains(@class,'Promo')]"));
        System.out.println("First result"+results.get(0).getText());
       System.out.println("Last result"+results.get(results.size()-1).getText());
    }

}
