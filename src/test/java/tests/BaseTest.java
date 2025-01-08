package tests;

import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Step;
import pages.MainPage;
import utils.AllureUtils;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    protected final MainPage mainPage = new MainPage();

    @BeforeMethod
    @Step("Test setup: Maximizing browser and navigating to the environment URL")
    public void setup() {
        AllureUtils.logBrowserDetails("Starting browser setup.");
        getBrowser().maximize();
        getBrowser().goTo(SettingsTestData.getEnvData().getHost());
    }

    @AfterMethod
    @Step("Test teardown: Closing the browser if it is started")
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            AllureUtils.logBrowserDetails("Browser is still active. Proceeding to quit.");
            getBrowser().quit();
        } else {
            AllureUtils.logBrowserDetails("Browser is not active. Skipping quit operation.");
        }
    }
}
