package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import test.hvac.Topologies;

// page_url = https://stage.app.platforma.build/portfolio/ea7e476c-2e10-4090-9848-ff3389504266/a9e58ddc-c7fa-4c49-a249-6ea3bc291004
public class TopologiesPage {

    private final SelenideElement topologies = $x("//span[text()='Форма МОП 128']");
    public void  chooseTopologies() {
        topologies.click();
    }

    public TopologiesPage chooseTopologiess(Topologies topologies) {
        $(byText((topologies.getDesc()))).click();
        return this;
    }

}
