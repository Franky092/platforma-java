package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class TopologiesTreePage {



    private final SelenideElement variantApartment = $x("//span[text()='Набор квартир' and text()=' 1 ']");
    private final SelenideElement LocationVariantApartment = $x("//span[text()='Вариант расположения квартир' and text()=' 1 ']");
    private final SelenideElement variant = $x("//span[text()='Вариант 128-1-1-0']");
    private final SelenideElement ButtonViewVariant = $x("//span[text()=' Просмотр варианта ']");

    public void chooseVariantApartment(List<String> variantsApartment) {
        for (String variantApartment : variantsApartment) {
            $x(String.format("//span[text()='Набор квартир' and text()=' %s ']", variantApartment)).click();
        }
    }

    public void chooseLocationVariantApartment() {
        LocationVariantApartment.click();
    }
    public void chooseVariant() {
        variant.click();
    }

    public TopologiesTreePage chooseVariants(List<String> variants) {
        for (String variant : variants) {
            $x(String.format("//span[text()='%s']", variant)).click();
        }
        return this;
    }

    public void clickButtonViewVariant() {
        ButtonViewVariant.click();
    }
}
