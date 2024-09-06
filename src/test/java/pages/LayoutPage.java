package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = about:blank
public class LayoutPage {

    //Для теста
    private final SelenideElement title = $x("//div[text()='Модели и расчёты']");


    public void getTitle(){
        title.shouldBe(visible);
    }
}