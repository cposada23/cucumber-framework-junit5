package pageobjects.automationpractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.exceptions.ActionsException;

public class LoginPage {

    private Action action;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    WebElement submitButton;

    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPasswordLink;

    public LoginPage(Action action) {
        this.action = action;
        PageFactory.initElements(action.getDriver(), this);
    }


    public String getLoginPageTitle() {
        return this.action.getDriver().getTitle();
    }

    public boolean isForgotPasswordLinkVisible() {
        return this.action.isElementVisible(forgotPasswordLink);
    }

    public void enterUsername(String username) throws ActionsException {
        this.action.sendText(emailInput, username);
    }

    public void enterPassword(String password) throws ActionsException {
        this.action.sendText(passwordInput, password);
    }

    public void clickOnLogin() throws ActionsException {
        this.action.click(submitButton);
    }

    public void doLogin(String username, String password) throws ActionsException {
        enterUsername(username);
        enterPassword(password);
        clickOnLogin();
    }
}
