package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.util.Random;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;

import config.WebDriverConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;


public class AuthPage {

    public static Creds config = ConfigFactory.create(Creds.class, System.getProperties());

    private final SelenideElement emailField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement rememberMeCheckbox = $("#rememberMe");
    private final SelenideElement signInButton = $("#kc-login");
    private final SelenideElement signUpButton = $x("//a[normalize-space(text()) = 'Зарегистрироваться']");
    private final SelenideElement forgetPasswordButton = $x("//a[normalize-space(text()) = 'Забыли пароль?']");
    private final SelenideElement currentLanguage = $("#kc-current-locale-link");
    private final SelenideElement ruLanguage = $x("//a[normalize-space(text()) = 'Русский']");
    private final SelenideElement engLanguage = $x("//a[normalize-space(text()) = 'English']");
    private final SelenideElement authForm = $(".login-pf-page .card-pf");
    private final SelenideElement inputError = $("#input-error");
    private final SelenideElement mainPageHeader = $(".content .header"); // временно, удалить позже

    // Ожидание загрузки формы авторизации
    public void waitForFormLoaded() {
        authForm.shouldBe(Condition.visible);
    }

    // Ввод email
    public void enterEmail() {
        emailField.setValue(config.MAIN_USERNAME());
    }

    // Ввод username
    public void enterUsername() {
        emailField.setValue(config.MAIN_USERNAME());
    }

    // Ввод пароля
    public void enterPassword() {
        passwordField.setValue(config.MAIN_PASSWORD());
    }

    // Клик по чекбоксу "Запомнить меня"
    public void clickRememberMe() {
        rememberMeCheckbox.click();
    }

    // Клик по кнопке входа
    public void clickSignInButton() {
        signInButton.click();
    }

    // Ввод фейкового email
    public void enterFakeEmail() {
        emailField.setValue(generateFakeEmail());
    }

    // Ввод фейкового пароля
    public void enterFakePassword() {
        passwordField.setValue(generateFakePassword());
    }

    // Переход на страницу регистрации
    public void goToRegistrationPage() {
        signUpButton.click();
    }

    // Переключение языка на русский
    public void switchLanguageToRu() {
        currentLanguage.click();
        ruLanguage.click();
    }

    public void getMainPageHeader() {
        mainPageHeader.shouldBe(visible);
    }

    // Генерация фейкового email
    private String generateFakeEmail() {
        return "user" + new Random().nextInt(1000) + "@testAutomation.com";
    }

    // Генерация фейкового пароля
    private String generateFakePassword() {
        return new Random().ints(10, 33, 122)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
