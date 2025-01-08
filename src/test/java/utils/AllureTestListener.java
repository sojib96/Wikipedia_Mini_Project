package utils;
import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {

    @Attachment(value = "{0}", type = "image/png", fileExtension = ".png")
    public byte[] attachScreenshot(ITestResult result) {
        return AqualityServices.getBrowser().getScreenshot();
    }

    public void onTestFailure(ITestResult result) {
        attachScreenshot(result);
    }
}
