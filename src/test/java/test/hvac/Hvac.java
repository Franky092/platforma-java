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

public class Hvac extends TestBase {
    AuthPage authPage = new AuthPage();
    PortfolioPage portfolioPage = new PortfolioPage();
    ProjectsPage projectsPage = new ProjectsPage();
    ProjectPage projectPage = new ProjectPage();
    LayoutsPage layoutsPage = new LayoutsPage();
    TopologiesPage topologiesPage = new TopologiesPage();
    TopologiesTreePage topologiesTreePage = new TopologiesTreePage();
    LayoutPage layoutPage = new LayoutPage();
    SpaceplanningPage spaceplanningPage = new SpaceplanningPage();
    ArchitecturePage architecturePage = new ArchitecturePage();
    StructurePage structurePage = new StructurePage();
    ArchitectureTwoPage architectureTwoPage = new ArchitectureTwoPage();
    HvacPage hvacPage = new HvacPage();


    @Nested
    class HvacTests {

        // Добавляем метод источника данных
        static Stream<Arguments> topologiesProvider() {
            return Stream.of(
//                    Arguments.of(Topologies.Num124, List.of("Вариант 124-1-1-0"))
                    Arguments.of(Topologies.Num128, List.of("Вариант 128-1-1-1")),
                    Arguments.of(Topologies.Num128, List.of("Вариант 128-1-1-0")) //Пример других значений
            );
        }

        @Owner("Maksim Sidelnikov")
        @Severity(SeverityLevel.NORMAL)
        @DisplayName("Проход до HVAC")
        @ParameterizedTest(name = "на Мопе {0} и {1}")
        @MethodSource("topologiesProvider")
        void goToHvac(Topologies topologies, List<String> variants) {
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

            step("Выбор набора квартир ", () -> {
                topologiesTreePage.chooseVariantApartment();
            });

            step("Выбор варианта расположения квартир ", () -> {
                topologiesTreePage.chooseLocationVariantApartment();
            });

            step("Выбор доступных вариантов расположения квартир ", () -> {
                topologiesTreePage.chooseVariants(variants);
            });

            step("Нажать на кнопку 'Просмотр варианта' ", () -> {
                topologiesTreePage.clickButtonViewVariant();
            });

            step("Нажать на кнопку передать вариант в модуль", () -> {
                layoutPage.clickButtonNextModule();
            });
            step("Выбрать ОПР", () -> {
                layoutPage.clickButtonSpacePlanning();
            });
            step("Нажать на кнопку передать вариант в модуль", () -> {
                spaceplanningPage.clickButtonNextModule();
            });
            step("Выбрать АР", () -> {
                spaceplanningPage.clickButtonArchitecture();
            });
            step("Нажать на кнопку передать вариант в модуль", () -> {
                architecturePage.clickButtonNextModule();
            });
            step("Выбрать КР", () -> {
                architecturePage.clickButtonStructure();
            });
            step("Нажать кнопку Сгенерировать", () -> {
                structurePage.clickButtonGeneration();
            });
            step("Выбрать вариант", () -> {
                structurePage.clickVariant();
            });
            step("Нажать на кнопку просмотр варианта", () -> {
                structurePage.clickButtonViewVariant();
            });
            step("Нажать на кнопку передать вариант в модуль", () -> {
                structurePage.clickButtonNextModule();
            });

            step("Выбрать АР2", () -> {
                structurePage.clickButtonArchitectureTwo();
            });
            step("Нажать на кнопку передать вариант в модуль", () -> {
                architectureTwoPage.clickButtonNextModule();
            });
            step("Нажать на кнопку передать вариант в модуль", () -> {
                architectureTwoPage.clickButtonHvac();
            });
            step("Проверяем, что мы на странице HVAC", () -> {
                hvacPage.checkHvacTitle();
            });
            step("Проверяем, что нет ошибок", () -> {
                hvacPage.assertNoErrorDialogPresent();
            });
        }

        @Owner("Maksim Sidelnikov")
        @Severity(SeverityLevel.NORMAL)
        @DisplayName("Проход до HVAC")
        @Test()
        void downloadIFC() {
        }
    }
}