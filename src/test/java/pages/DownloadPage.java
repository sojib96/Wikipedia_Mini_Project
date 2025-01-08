package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.AllureUtils;

public class DownloadPage extends Form {
    private final ILabel fileName = getElementFactory().getLabel(By.className("mw-electronpdfservice-selection-label-desc"), "File name");
    private final IButton downloadButton = getElementFactory().getButton(By.className("oo-ui-labelElement-label"), "Download button");

    public DownloadPage() {
        super(By.id("ca-sitesupport"), "Download as PDF");
    }

    @Step("Get the name of the file displayed on the Download page")
    public String getFileName() {
        String name = fileName.getText();
        AllureUtils.attachFileNameToReport(name);
        return name;
    }

    @Step("Click the 'Download' button")
    public void clickDownloadButton() {
        downloadButton.click();
    }
}
