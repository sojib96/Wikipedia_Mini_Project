package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import com.google.gson.Gson;
import models.*;
import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    public final String RESOURCES_PATH = "src/test/resources/";
    public final String TEST_DATA_PATH = RESOURCES_PATH + "testdata/";
    private final String INPUT_STRING_DATA_PATH = TEST_DATA_PATH + "testData.json";
    private final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final Gson GSON = new Gson();

    @Step("Retrieve environment configuration data")
    public EnvData getEnvData() {
        String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
        return deserializeJson(envConfigPath, EnvData.class);
    }

    @Step("Get current environment from configuration file")
    private String getCurrentEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }

    @Step("Retrieve input string data from test data JSON")
    @DataProvider(name = "inputStringData")
    public static Object[][] getInputStringData() {
        TestData testData = deserializeJson(INPUT_STRING_DATA_PATH, TestData.class);

        Object[][] data = new Object[testData.getInputString().size()][1];
        for (int i = 0; i < testData.getInputString().size(); i++) {
            data[i][0] = testData.getInputString().get(i);
        }
        return data;
    }

    @Step("Deserialize JSON file from path: {filePath}")
    private <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error("Settings file %s not found or incorrect. Error msg: %s".formatted(filePath, e));
            throw new RuntimeException(e);
        }
    }
}
