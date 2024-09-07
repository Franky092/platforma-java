package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://stage.app.platforma.build/portfolio/ea7e476c-2e10-4090-9848-ff3389504266/a9e58ddc-c7fa-4c49-a249-6ea3bc291004
public class ArchitecturePage {

    //Для теста
    private final SelenideElement title = $x("//div[text()='Модели и расчёты']");
    private final SelenideElement buttonNextModule = $("div[data-appearance='primary'] span");
    private final SelenideElement buttonStructure = $x("//button[text()=' КР ']");


    public void getTitle(){
        title.shouldBe(visible);
    }

    public void clickButtonNextModule(){
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6));
        sleep(2000);
        buttonNextModule.click();
    }

    public void clickButtonStructure(){
        buttonStructure.click();
    }
}