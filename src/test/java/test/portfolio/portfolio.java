package test.portfolio;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import helpers.TestBase;
import pages.PortfolioPage;
import pages.AuthPage;

import static io.qameta.allure.Allure.step;

public class portfolio extends TestBase{
     PortfolioPage portfolioPage= new PortfolioPage();
     AuthPage authPage = new AuthPage();

    @Test
    @Owner("Maksim Sidelnikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("выбор 128 топологии")
    public void gotopologies() {
        authPage.enterEmail();
        authPage.enterPassword();
        authPage.clickRememberMe();
        authPage.clickSignInButton();
        portfolioPage.enterPortfolio();
        portfolioPage.goPortfolioSidelnikov();
        portfolioPage.chooseLayout();
        portfolioPage.chooseLayoutOption();
        portfolioPage.chooseTopologies();

    }


}