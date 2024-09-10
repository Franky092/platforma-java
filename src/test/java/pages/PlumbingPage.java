package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = about:blank
public class PlumbingPage {
    private final SelenideElement PlumbingTitle = $x("//div[text()='Вариант ВК']");



    public void chekTitilePlumbing() {
        PlumbingTitle.shouldBe(visible, Duration.ofMinutes(2));
    }
}