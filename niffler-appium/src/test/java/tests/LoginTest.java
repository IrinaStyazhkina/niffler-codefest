package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import utils.DriverContext;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.cssSelector;
import static utils.DriverContext.WebView.WEBVIEW;
import static utils.DriverContext.WebView.WEBVIEW_chrome;

public class LoginTest extends BaseTest{

    static {
        Configuration.timeout = 8000;
    }

    @Test
    void successLoginViaCustomTabsTest() {
        step("Кликаем на кнопку Log in", () -> {
            $(id("ru.niffer_android:id/buttonLogin")).click();
        });
        DriverContext.switchToWebView(WEBVIEW_chrome);
        step("Авторизуемся внутри Chrome Custom Tabs", () -> {
            $(cssSelector("input[name='username']")).val("stage");
            $(cssSelector("input[name='password']")).val("12345");
            $(cssSelector("button[type='submit']")).click();
        });
        DriverContext.switchToNative();
        step("Проверяем, что мы снавигировались внутрь приложения", () -> {
            $(id("ru.niffer_android:id/main_page")).shouldBe(visible);
            $(id("ru.niffer_android:id/profile_item")).shouldBe(visible);
        });
        DriverContext.switchToWebView(WEBVIEW);
        step("Проверяем загруженный внутри Webview контент", () -> {
            $(cssSelector("#period")).shouldBe(visible);
        });
    }
}
