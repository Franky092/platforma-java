package test.architectureTwo;

import helpers.Attach;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import helpers.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;
import test.Topologies;


import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class artwo extends TestBase {
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

    // Добавляем метод источника данных
    static Stream<Arguments> topologiesProvider() {
        return Stream.of(
                Arguments.of(Topologies.Num124, List.of("Вариант 124-1-1-0"),List.of("1")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-1-1-0"),List.of("1")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-1-1-1"),List.of("1")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-1-1-2"),List.of("1")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-1-1-3"),List.of("1")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-2-1-0"),List.of("2")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-2-1-1"),List.of("2")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-2-1-2"),List.of("2")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-2-1-3"),List.of("2")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-3-1-0"),List.of("3")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-3-1-1"),List.of("3")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-3-1-2"),List.of("3")),
                Arguments.of(Topologies.Num128, List.of("Вариант 128-3-1-3"),List.of("3")),
                Arguments.of(Topologies.Num122, List.of("Вариант 122-1-1-0"),List.of("1")),
                Arguments.of(Topologies.Num126, List.of("Вариант 126-1-1-0"),List.of("1")),
                Arguments.of(Topologies.Num61, List.of("Вариант 61-1-1-0"),List.of("1"))
        );
    }

    @Owner("Maksim Sidelnikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проход до АР2")
    @ParameterizedTest(name = "на Мопе {0} и {1}, набор квартир {2}")
    @MethodSource("topologiesProvider")
    void goToHvac(Topologies topologies, List<String> variants, List<String> variantsApartment) {
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

        step ("Переход к модулю КЗ", () -> {
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
                topologiesTreePage.chooseVariantApartment(variantsApartment);
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
        });

        step("Переход в модуль ОПР", () -> {
            step("Нажать на кнопку передать вариант в модуль", () -> {
                layoutPage.clickButtonNextModule();
            });
            step("Выбрать ОПР", () -> {
                layoutPage.clickButtonSpacePlanning();
            });
            step("Проверить, что мы находимся в модуле ОПР", () -> {spaceplanningPage.checkSpacePlanningTitle();});
        });

        step("Переход в модуль АР", () -> {
            step("Нажать на кнопку передать вариант в модуль", () -> {
                spaceplanningPage.clickButtonNextModule();
            });
            step("Выбрать АР", () -> {
                spaceplanningPage.clickButtonArchitecture();
            });
            step("Проверить, что мы находимся в модуле АР", () -> {architecturePage.checkArchitectureTitle();});
        });

        step("Переход в модуль КР", () -> {
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
            step("Проверить, что мы находимся в модуле КР", () -> {structurePage.checkStructureTitle();});
            step("Скачать OМ-КР",()->{
                step("Скачиваем файл ОМ-КР", Attach::getOm);
            });
        });

        step("Переход в модуль АР2", () -> {
            step("Нажать на кнопку передать вариант в модуль", () -> {
                structurePage.clickButtonNextModule();
            });
            step("Выбрать АР2", () -> {
                structurePage.clickButtonArchitectureTwo();
            });
            step("Проверить, что мы находимся в модуле АР", () -> {
                architectureTwoPage.checkArchitectureTwoTitle();}
            );
            step("Скачать OМ-АР2", Attach::getOm);
        });
    }
}
