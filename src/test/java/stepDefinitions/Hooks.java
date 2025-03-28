package stepDefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.YamlReader;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {

    private static final boolean IS_BROWSER_HEADLESS = false;

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.headless = IS_BROWSER_HEADLESS;
    }

    @AfterAll
    public static void cleanup() {
        Selenide.closeWebDriver();
    }
}
