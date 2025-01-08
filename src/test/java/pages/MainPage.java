package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final ITextBox searchBoxInputField = getElementFactory().getTextBox(By.id("searchInput"), "Search Box input field");
    private final IButton searchButton = getElementFactory().getButton(By.xpath("//*[@id='search-form']//button"), "Search button");

    public MainPage() {
        super(By.id("search-form"), "Wikipedia");
    }

    @Step("Input text '{input}' into the search box and click the Submit button")
    public void inputTextAndClickSubmitButton(String input) {
        clearAndTypeSearchBox(input);
        clickSearchButton();
    }

    @Step("Clear and type '{input}' into the search box")
    private void clearAndTypeSearchBox(String input) {
        searchBoxInputField.clearAndTypeSecret(input);
    }

    @Step("Click the search button")
    private void clickSearchButton() {
        searchButton.click();
    }
}

