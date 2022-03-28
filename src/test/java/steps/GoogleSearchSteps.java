package steps;

import controllers.google.GoogleController;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Action;
import utils.WebDriverFactory;

public class GoogleSearchSteps {

    private static final Logger LOGGER = LogManager.getLogger(GoogleSearchSteps.class);
    private Action actions;
    private GoogleController googleController;

    @Before("@google")
    public void setUp() {
        LOGGER.info("Before hook for google feature");
        actions = new Action(WebDriverFactory.getWebDriver());
        googleController = new GoogleController(actions);
    }

    @Given("the user navigates to {string}")
    public void theUserNavigatesTo(String url){
        googleController.navigateToHomePage(url);
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchString) {
        googleController.searchFor(searchString);
        googleController.waitForSearchResults();
    }

    @Then("the user navigates to the firs result")
    public void theUserNavigatesToTheFirsResult() throws InterruptedException {
        googleController.selectFirstResult();
        Thread.sleep(10000);
    }
}
