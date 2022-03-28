package pageobjects.automationpractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Action;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private Action action;

    @FindAll(
            @FindBy(css = "div#center_column span")
    )
    List<WebElement> accountSections;



    public AccountPage(Action action) {
        this.action = action;
        PageFactory.initElements(action.getDriver(), this);
    }

    public int getAccountsSectionCount() {
        return accountSections.size();
    }

    public List<String> getAccountsSectionsTitles() {
        List<String> accountsListTitles = new ArrayList<>();

        for (WebElement e : accountSections) {
            accountsListTitles.add(e.getText());
        }

        return accountsListTitles;
    }

}
