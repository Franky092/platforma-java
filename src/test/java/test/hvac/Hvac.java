package test.hvac;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import helpers.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;


import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class Hvac extends TestBase{
     AuthPage authPage = new AuthPage();
     PortfolioPage portfolioPage= new PortfolioPage();
     ProjectsPage projectsPage= new ProjectsPage();
     ProjectPage projectPage= new ProjectPage();
     LayoutsPage layoutsPage= new LayoutsPage();
     TopologiesPage topologiesPage= new TopologiesPage();
     TopologiesTreePage topologiesTreePage = new TopologiesTreePage();
     LayoutPage layoutPage = new LayoutPage();
     SpaceplanningPage spaceplanningPage = new SpaceplanningPage();
     ArchitecturePage architecturePage = new ArchitecturePage();
     StructurePage structurePage = new StructurePage();
     ArchitectureTwoPage architectureTwoPage = new ArchitectureTwoPage();
     HvacPage hvacPage = new HvacPage();

    // Добавляем метод источника данных
    static Stream<Arguments> topologiesProvider() {
        return Stream.of(
                Arguments.of(Topologies.Num124),
                Arguments.of(Topologies.Num128) // Пример других значений
        );
    }

    @Owner("Maksim Sidelnikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("выбор 128 топологии")
    @ParameterizedTest(name = "Выбран моп {0}")
    @MethodSource("topologiesProvider")
    void gotopologies(Topologies topologies) {
        step("Авторизация", () -> {
            step("Ввод Email", () -> {
                authPage.enterEmail();
            });
            step("Ввод пароля", () -> {
                authPage.enterPassword();
            });

            step("Нажатие на чекбокс 'Запомнить меня'", () -> {
                authPage.clickRememberMe();
            });

            step("Нажатие на кнопку 'Войти'", () -> {
                authPage.clickSignInButton();
            });
        });

        step("Выбор портфеля", () -> {
            portfolioPage.enterPortfolio();
        });

        step("Переход к проекту Сидельников", () -> {
            projectsPage.goToProjectSidelnikov();
        });

        step("Выбор планировки", () -> {
            projectPage.chooseLayout();
        });

        step("Выбор опции планировки", () -> {
            layoutsPage.chooseLayoutOption();
        });

        step("Выбор топологии: " + topologies, () -> {
            topologiesPage.chooseTopologiess(topologies);
        });
    }
}