package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;

public class SearchResultPage extends Form {
    private final IButton toolMenuButton = getElementFactory().getButton(By.id("vector-page-tools-dropdown"), "Tools menu button");
    private final ILink downloadLink = getElementFactory().getLink(By.id("coll-download-as-rl"), "Download Link");

    public SearchResultPage() {
        super(By.id("ca-nstab-main"), "Article");
    }

    @Step("Click on the Tools menu button")
    public void clickToolMenuButton() {
        toolMenuButton.click();
        AllureUtils.attachButtonActionDetails("Tools menu button clicked.");
    }

    @Step("Click on the Download link")
    public void clickDownloadLink() {
        downloadLink.click();
        AllureUtils.attachLinkActionDetails("Download link clicked.");
    }
}
