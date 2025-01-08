package utils;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static io.qameta.allure.Allure.addAttachment;

@UtilityClass
public class AllureUtils {

    @Step("Attach details of the button action to the report: {details}")
    public void attachButtonActionDetails(String details) {
        addAttachment("Button Action", details);
    }

    @Step("Attach details of the link action to the report: {details}")
    public void attachLinkActionDetails(String details) {
        addAttachment("Link Action", details);
    }

    @Step("Attach file name '{fileName}' to the report")
    public void attachFileNameToReport(String fileName) {
        addAttachment("File Name", fileName);
    }

    @Step("Log browser details: {details}")
    public void logBrowserDetails(String details) {
        attachBrowserInfo();
    }

    @Step("Attach browser and environment information to the report")
    private void attachBrowserInfo() {
        String browserName = getBrowser().getDriver().getCapabilities().getBrowserName();
        String browserVersion = getBrowser().getDriver().getCapabilities().getBrowserVersion();
        String envUrl = SettingsTestData.getEnvData().getHost();

        addAttachment("Browser Info",
                String.format("Browser: %s\nVersion: %s\nEnvironment URL: %s", browserName, browserVersion, envUrl));
    }
}