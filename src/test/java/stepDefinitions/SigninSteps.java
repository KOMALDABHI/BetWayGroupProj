package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninSteps {
    WebDriver driver;

    @Given("I am on scores-fixtures page")
    public void i_am_on_scores_fixtures_page() {
        driver.get("https://www.bbc.co.uk/sport/football/scores-fixtures");
        String Title=driver.getTitle();
        System.out.println("page title"+Title);
    }

    @Given("I navigate to login page")
    public void i_navigate_to_login_page() {
        driver.findElement(By.id("idcta-username")).click();
    }

    @When("I attempt to login with correct {string} and incorrect {string}")
    public void i_attempt_to_login_with_correct_and_incorrect(String userName, String pwd) {
            driver.findElement(By.id("user-identifier-input")).sendKeys(userName);
            driver.findElement(By.id("password-input")).sendKeys(pwd);
            driver.findElement(By.id("submit-button")).click();

    }
    @Then("my login attempt should fail with wrong password {string}")
    public void my_login_attempt_should_fail_with_wrong_password(String errMsg) {
       String ActErrMsg=driver.findElement(By.xpath("//p[@class='form-message__text']")).getText();
        Assert.assertEquals(errMsg,ActErrMsg);

    }
    @When("I attempt to login with incorrect {string} and correct {string}")
    public void i_attempt_to_login_with_incorrect_and_correct(String userName, String pwd) {
        driver.findElement(By.id("user-identifier-input")).sendKeys(userName);
        driver.findElement(By.id("password-input")).sendKeys(pwd);
        driver.findElement(By.id("submit-button")).click();

    }
    @Then("my login attempt should fail with wrong username {string}")
    public void my_login_attempt_should_fail_with_wrong_username(String errMsg) {
        String ActErrMsg=driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(errMsg,ActErrMsg);

    }
    @When("I attempt to login with incorrect {string} and incorrect {string}")
    public void i_attempt_to_login_with_incorrect_and_incorrect(String userName, String pwd) {
        driver.findElement(By.id("user-identifier-input")).sendKeys(userName);
        driver.findElement(By.id("password-input")).sendKeys(pwd);
        driver.findElement(By.id("submit-button")).click();
    }
    @Then("my login attempt should fail with wrong username and password {string}")
    public void my_login_attempt_should_fail_with_wrong_username_and_password(String errMsg) {

    }


}
