package pageobjects.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.exceptions.ActionsException;


public class GoogleHomePage {
    private Action actions;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public GoogleHomePage(Action actions) {
        this.actions = actions;
        PageFactory.initElements(actions.getDriver(), this);
    }

    public boolean isInputVisible() {
        return actions.isElementVisible(searchInput, 10);
    }

    public void searchFor(String searchString) throws ActionsException {
        this.actions.sendText(searchInput, searchString);
        this.actions.click(searchButton);
    }

}
