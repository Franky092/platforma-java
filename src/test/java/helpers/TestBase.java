package helpers;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriver;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {
    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    static void openPage() {
        step("Открыть главную страницу 'platforma'", () ->
                open(config.getBaseUrl()));
    }

    @BeforeAll
    static void driverConfigure() {
        WebDriver.configure();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
