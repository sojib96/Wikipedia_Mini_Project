package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DownloadPage;
import pages.SearchResultPage;
import utils.FileUtils;
import utils.SettingsTestData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import java.io.File;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class WikipediaTest extends BaseTest {
    private final SearchResultPage searchResultPage = new SearchResultPage();
    private final DownloadPage downloadPage = new DownloadPage();
    private File downloadedFile;

    @Test(description = "Test search functionality for {0}", dataProvider = "inputStringData", dataProviderClass = SettingsTestData.class)
    @Feature("Search Functionality")
    @Story("File Download from Search Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that a user can search for a term, navigate to the download page, and successfully download a file.")
    public void wikipediaTest(String inputString) {
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main Page is not displayed yet");
        mainPage.inputTextAndClickSubmitButton(inputString);
        searchResultPage.clickToolMenuButton();
        searchResultPage.clickDownloadLink();
        downloadPage.clickDownloadButton();
        downloadedFile = new File(getBrowser().getDownloadDirectory() + File.separator + downloadPage.getFileName());
        Assert.assertTrue(FileUtils.isFileExist(downloadedFile), "File does not exist!");
    }

    @AfterMethod
    public void deleteFile() {
        FileUtils.deleteFileIfExist(downloadedFile);
    }
}

