package controllers.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pageobjects.automationpractice.LoginPage;
import utils.Action;

public class AutomationPracticeController {

    private static final Logger LOGGER = LogManager.getLogger(AutomationPracticeController.class);
    private LoginPage loginPage;
    Action actions;

    public AutomationPracticeController(Action actions) {
          this.actions = actions;
          this.loginPage = new LoginPage(actions);
    }

    public void login(String username, String password) {
        try {
            LOGGER.info(String.format("Login with username: %s and password: %s", username, password));
            loginPage.doLogin(username, password);
        }catch (Exception e) {
            LOGGER.error("Error while doing the login", e);
            Assertions.fail(e);
        }
    }
}
