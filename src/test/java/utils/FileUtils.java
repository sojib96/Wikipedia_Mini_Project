package utils;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;

import static aquality.selenium.browser.AqualityServices.getBrowser;

@UtilityClass
public class FileUtils {

    @Step("Verifying download file exist in the local folder")
    public boolean isFileExist(String file) {
        return (Boolean) (getBrowser().executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"" + file + "\"}}"));
    }
}
