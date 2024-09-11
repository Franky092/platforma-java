package pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StructurePage {


    //Для теста
    private final SelenideElement title = $x("//div[text()='Модели и расчёты']");
    private final SelenideElement buttonNextModule = $("div[data-appearance='primary'] span");
    private final SelenideElement buttonViewVariant = $("div[data-appearance='primary'] span");
    private final SelenideElement buttonGeneration = $("div[data-appearance='primary'] span");
    private final SelenideElement variant = $("div.t-content div.content .props");
    private final SelenideElement buttonArchitectureTwo = $x("//button[text()=' АР 2 ']");
    public SelenideElement structureTitle = $x("//div[text()=\"Задание КР 1\"]");
    public final SelenideElement dialogCloseButton = $("button.t-close");


    public void getTitle() {
        title.shouldBe(visible);
    }

    public void clickButtonNextModule() {
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6));
        buttonNextModule.click();
    }

    public void clickButtonArchitectureTwo() {
        buttonArchitectureTwo.click();
    }

    public void clickButtonGeneration() {
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6));
        sleep(2000);
        buttonNextModule.click();
    }

    public void clickButtonViewVariant() {
        buttonViewVariant.click();
    }

    public void clickVariant() {
        variant.shouldBe(visible, Duration.ofMinutes(6)).click();
    }

    public void checkStructureTitle() {
        structureTitle.shouldBe(visible, Duration.ofMinutes(2));
    }


    public void checkErrors() {
        step("Проверка наличия ошибок на странице", () -> {
            if (dialogCloseButton.is(visible, Duration.ofMinutes(1))) {
                dialogCloseButton.click();
            }
        });
    }
}