package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://dev.app.platforma.build/portfolio
public class PortfolioPage {


    private final SelenideElement portfolioCard = $("[automation-id='portfolio-list_item']:nth-of-type(2)");
    private final SelenideElement projectSidelnikov = $x("//div[text()='Сидельников']");
    private final SelenideElement layout = $x("//a[@ng-reflect-router-link='layout']");
    private final SelenideElement layoutOption = $(".cell__action.ng-star-inserted");
    private final SelenideElement topologies = $("a[ng-reflect-router-link='dd4ff442-95fc-4abb-b0f0-051a7d']");


    public void enterPortfolio() {
        portfolioCard.click();
    }


    public void goPortfolioSidelnikov() {
        projectSidelnikov.click();
    }

    public void chooseLayout() {
        layout.click();
    }

    public void chooseLayoutOption()
    {
        layoutOption.click();
    }

    public void  chooseTopologies() {
        topologies.click();
    }
}