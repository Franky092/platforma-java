package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://stage.app.platforma.build/portfolio/ea7e476c-2e10-4090-9848-ff3389504266/a9e58ddc-c7fa-4c49-a249-6ea3bc291004
public class ArchitecturePage {

    //Для теста
    private final SelenideElement title = $x("//div[text()='Модели и расчёты']");
    private final SelenideElement buttonNextModule = $("div[data-appearance='primary'] span");
    private final SelenideElement buttonStructure = $x("//button[text()=' КР ']");
    public SelenideElement architectureTitle = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle2 = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle3 = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle4 = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle5 = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle6 = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle7 = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle8 = $x("//div[text()=\"Вариант АР\"]");
    public SelenideElement architectureTitle9 = $x("//div[text()=\"Вариант АР\"]");
    private final SelenideElement buttonStructure2 = $x("//button[text()=' КР ']");


    public void getTitle(){
        title.shouldBe(visible);
    }

    public void clickButtonNextModule(){
        buttonNextModule.shouldBe(visible, Duration.ofMinutes(6));
        buttonNextModule.click();
    }

    public void clickButtonStructure(){
        buttonStructure.click();
    }

    public void checkArchitectureTitle() {
        architectureTitle.shouldBe(visible, Duration.ofMinutes(2));
    }
}