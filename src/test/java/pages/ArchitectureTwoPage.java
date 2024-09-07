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


    public void getTitle(){
        title.shouldBe(visible);
    }

    public void clickButtonNextModule(){
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6));
        sleep(2000);
        buttonNextModule.click();
    }

    public void clickButtonHvac(){
        buttonHvac.click();
    }
}