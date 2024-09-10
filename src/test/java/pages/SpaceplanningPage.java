package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.model.Status;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://stage.app.platforma.build/portfolio/ea7e476c-2e10-4090-9848-ff3389504266/a9e58ddc-c7fa-4c49-a249-6ea3bc291004/hvac/db5bbaf6-ff38-4f57-9d02-39a90bc8684a/variants/c6c92a1f-83ca-4dbf-90c2-8a457d3d73bd
public class SpaceplanningPage {


    //Для теста
    private final SelenideElement buttonNextModule = $("div[data-appearance='primary'] span");
    private final SelenideElement buttonArchitecture = $x("//button[text()=' АР ']");
    public SelenideElement spacePlanningTitle = $x("//div[text()=\"Вариант ОПР\"]");




    public void checkSpacePlanningTitle() {
        spacePlanningTitle.shouldBe(visible, Duration.ofMinutes(3));
    }

    public void clickButtonNextModule(){
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6));
        buttonNextModule.click();
    }

    public void clickButtonArchitecture(){
        buttonArchitecture.click();
    }
}