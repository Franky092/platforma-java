package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HvacPage {

    public final SelenideElement tuidialog = $("tui-dialog");

    public SelenideElement hvacTitle = $x("//div[text()=\"Вариант ОВиК\"]");

    public void assertNoErrorDialogPresent() {
        tuidialog.shouldNotBe(visible, Duration.ofMinutes(2));
    }

    public void checkHvacTitle() {
        hvacTitle.shouldBe(visible, Duration.ofMinutes(2));
    }
}