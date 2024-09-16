package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://stage.app.platforma.build/portfolio/ea7e476c-2e10-4090-9848-ff3389504266/a9e58ddc-c7fa-4c49-a249-6ea3bc291004/layout
public class LayoutsPage {

    private final SelenideElement layoutOption = $$(".cell__action.ng-star-inserted").first();

    public void chooseLayoutOption()
    {
        layoutOption.click();
    }
}