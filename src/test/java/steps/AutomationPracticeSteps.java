package steps;

import controllers.automationpractice.AutomationPracticeController;
import controllers.google.GoogleController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Action;
import utils.WebDriverFactory;

import java.util.List;
import java.util.Map;

public class AutomationPracticeSteps {
    private static final Logger LOGGER = LogManager.getLogger(AutomationPracticeSteps.class);
    private AutomationPracticeController automationPracticeController;
    private Action actions;

    @Before("@automation_practice")
    public void setup() {
        LOGGER.info("Before hook for google feature");
        actions = new Action(WebDriverFactory.getWebDriver());
        automationPracticeController = new AutomationPracticeController(actions);
    }

    @Given("the user has already logged in to the application")
    public void theUserHasAlreadyLoggedInToTheApplication(DataTable dataTable) {

        List<Map<String, String>> credentials = dataTable.asMaps();
        String username = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");

        WebDriverFactory.getWebDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        automationPracticeController.login(username, password);

    }

    @Given("the user is on the Accounts page")
    public void theUserIsOnTheAccountsPage() throws InterruptedException {
        Thread.sleep(30000);
    }

    @When("the user gets the title of the page")
    public void theUserGetsTheTitleOfThePage() {
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
    }
}
