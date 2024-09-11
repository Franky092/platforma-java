package helpers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Visible;
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

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class Attach {
    private static final SelenideElement om = $x("//div[text()='Объектная модель']");
    private static final SelenideElement pngs = $("[id*=downloadButton]");
    private static final SelenideElement diagnisticFloor = $x("//div[text()='Диагностический IFC (Этаж)']");
    private static final SelenideElement diagnisticFloors = $x("//div[text()='Диагностический IFC (Здание)']");
    public static SelenideElement tuidialog = $("h3");
    public static SelenideElement tuidialogclose = $("button.t-close");
    static int retryCount = 0;
    static int maxRetries = 4;
    static boolean fileDownloaded = false;

    public static void getOm() throws FileNotFoundException {
        while (!fileDownloaded && retryCount < maxRetries) {
            try {
                File report = om.download(DownloadOptions.using(FOLDER).withTimeout(60000));
                Allure.addAttachment(report.getName(), "application/octet-stream", new FileInputStream(report), "json");
                fileDownloaded = true;
            } catch (Error e) {
                System.out.println("Can't download");
            }
            retryCount++;
            if (retryCount >= maxRetries) {
                throw new RuntimeException("EROOOOOOOOOOOOOOOOOOR");
            }
        }
    }

    public static void getFloorIfc() throws FileNotFoundException {
        File report = diagnisticFloor.download(DownloadOptions.using(FOLDER).withTimeout(60000));
        Allure.addAttachment(report.getName(), "application/octet-stream", new FileInputStream(report), "json");
    }

    public static void getFloorsIfc() throws FileNotFoundException {
        File report = diagnisticFloors.download(DownloadOptions.using(FOLDER).withTimeout(60000));
        Allure.addAttachment(report.getName(), "application/octet-stream", new FileInputStream(report), "json");
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