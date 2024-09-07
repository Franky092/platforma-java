package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = about:blank
public class LayoutPage {

    //Для теста
    private final SelenideElement title = $x("//div[text()='Модели и расчёты']");
    private final SelenideElement buttonNextModule = $("div[data-appearance='primary'] span");
    private final SelenideElement buttonSpacePlanning = $x("//button[text()=' ОПР ']");


    public void getTitle(){
        title.shouldBe(visible);
    }

    public void clickButtonNextModule(){
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6)).click();
    }

    public void clickButtonSpacePlanning(){
        buttonSpacePlanning.click();
    }
}