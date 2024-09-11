package helpers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Visible;
import com.codeborne.selenide.ex.FileNotDownloadedError;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import jdk.dynalink.beans.StaticClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class Attach {
    private static final SelenideElement om = $x("//div[text()='Объектная модель']");
    private static final SelenideElement diagnisticFloor = $x("//div[text()='Диагностический IFC (Этаж)']");
    private static final SelenideElement diagnisticFloors = $x("//div[text()='Диагностический IFC (Здание)']");
    public static final SelenideElement dialogCloseButton = $("button.t-close");
    private static final int MAX_ATTEMPTS = 3;

    public static void getOm() throws FileNotDownloadedError {
        int attempt = 0;
        boolean fileDownload = false;
        if (dialogCloseButton.is(visible, Duration.ofSeconds(5))) {
            dialogCloseButton.click();
        }
        while (!fileDownload) {
            attempt++;
            try {
                File file = om.download(DownloadOptions.using(FOLDER).withTimeout(60000));
                // Проверка, что файл не пустой
                if (file.length() > 0) {
                    Allure.addAttachment(file.getName(), "application/octet-stream", new FileInputStream(file), "json");
                    fileDownload = true; // Файл успешно загружен и не пустой
                } else {
                    System.out.println("Файл пустой, пробуем снова...");
                    file.delete(); // Удаляем пустой файл перед повторной попыткой
                }
            } catch (FileNotDownloadedError | FileNotFoundException e) {
                System.out.println("Не удалось скачать файл");
            };
            if (attempt >= MAX_ATTEMPTS) {
                throw new RuntimeException("Файл не удалось скачать после " + MAX_ATTEMPTS + " попыток.");
            }
        }
    }

    public static void getFloorIfc() throws FileNotDownloadedError {
        int attempt = 0;
        boolean fileDownload = false;
        if (dialogCloseButton.is(visible, Duration.ofSeconds(5))) {
            dialogCloseButton.click();
        }
        while (!fileDownload) {
            attempt++;
            try {
                File file = diagnisticFloor.download(DownloadOptions.using(FOLDER).withTimeout(30000));
                // Проверка, что файл не пустой
                if (file.length() > 0) {
                    Allure.addAttachment(file.getName(), "application/octet-stream", new FileInputStream(file), "json");
                    fileDownload = true; // Файл успешно загружен и не пустой
                } else {
                    System.out.println("Файл пустой, пробуем снова...");
                    file.delete(); // Удаляем пустой файл перед повторной попыткой
                    sleep(30000);
                }
            } catch (FileNotDownloadedError | FileNotFoundException e) {
                System.out.println("Не удалось скачать файл");
            };
            if (attempt >= MAX_ATTEMPTS) {
                throw new RuntimeException("Файл не удалось скачать после " + MAX_ATTEMPTS + " попыток.");
            }
        }
    }
    public static void getFloorsIfc() throws FileNotDownloadedError {
        int attempt = 0;
        boolean fileDownload = false;
        if (dialogCloseButton.is(visible, Duration.ofSeconds(5))) {
            dialogCloseButton.click();
        }
        while (!fileDownload) {
            attempt++;
            try {
                File file = diagnisticFloors.download(DownloadOptions.using(FOLDER).withTimeout(30000));
                // Проверка, что файл не пустой
                if (file.length() > 0) {
                    Allure.addAttachment(file.getName(), "application/octet-stream", new FileInputStream(file), "json");
                    fileDownload = true; // Файл успешно загружен и не пустой
                } else {
                    System.out.println("Файл пустой, пробуем снова...");
                    file.delete(); // Удаляем пустой файл перед повторной попыткой
                    sleep(30000);
                }
            } catch (FileNotDownloadedError | FileNotFoundException e) {
                System.out.println("Не удалось скачать файл");
            };
            if (attempt >= MAX_ATTEMPTS) {
                throw new RuntimeException("Файл не удалось скачать после " + MAX_ATTEMPTS + " попыток.");
            }
        }
    }

    @Attachment(value = "URL", type = "text/uri-list")
    public static String geturl() {
        return WebDriverRunner.url();
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl()
                + "' type='video/mp4'></video></body></html>";
    }

    public static URL getVideoUrl() {
        String videoUrl = "http://127.0.0.1:4444/video/" + sessionId() + ".mp4";
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}