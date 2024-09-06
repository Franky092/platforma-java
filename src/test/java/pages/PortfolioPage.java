package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://dev.app.platforma.build/portfolio
public class PortfolioPage {


    private final SelenideElement portfolioCard = $("[automation-id='portfolio-list_item']:nth-of-type(2)");
    private final SelenideElement layoutOption = $(".cell__action.ng-star-inserted");
    private final SelenideElement topologies = $x("//span[text()='Форма МОП 128']");


    public void enterPortfolio() {
        portfolioCard.click();
    }

}