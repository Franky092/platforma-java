package test.auth;

import config.WebDriverConfig;
import io.qameta.allure.Owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import pages.AuthPage;

import helpers.TestBase;

import static io.qameta.allure.Allure.step;

public class auth extends TestBase{
    AuthPage authPage = new AuthPage();

    @Test
    @Owner("Maksim Sidelnikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Авторизация под зарегистрированным пользователем, используя email")
    public void AuthLoginWithRegisteredUserUsingEmail() {
        step("Вводи почты",() -> authPage.enterEmail());
//        authPage.enterEmail();
        authPage.enterPassword();
        authPage.clickRememberMe();
        authPage.clickSignInButton();

        authPage.getMainPageHeader();

    }


}
