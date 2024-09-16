package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://stage.app.platforma.build/portfolio/ea7e476c-2e10-4090-9848-ff3389504266
public class ProjectsPage {

    private final SelenideElement projectSidelnikov = $x("//div[text()='Проект для тестирования']");


    public void goToProjectSidelnikov() {
        projectSidelnikov.click();
    }

}