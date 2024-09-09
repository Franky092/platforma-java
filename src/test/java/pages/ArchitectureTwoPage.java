package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = about:blank
public class ArchitectureTwoPage {


    //Для теста
    private final SelenideElement title = $x("//div[text()='Модели и расчёты']");
    private final SelenideElement buttonNextModule = $("div[data-appearance='primary'] span");
    private final SelenideElement buttonHvac = $x("//button[text()=' ОВиК ']");
    public SelenideElement architectureTwoTitle = $x("//div[text()=\"Вариант АР 2\"]");



    public void getTitle(){
        title.shouldBe(visible);
    }

    public void clickButtonNextModule(){
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6));
        buttonNextModule.click();
    }

    public void clickButtonHvac(){
        buttonHvac.click();
    }

    public void checkArchitectureTwoTitle() {
        architectureTwoTitle.shouldBe(visible, Duration.ofMinutes(2));
    }
}