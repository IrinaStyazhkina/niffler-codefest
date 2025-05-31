package utils;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.remote.SupportsContextSwitching;

import static com.codeborne.selenide.Selenide.webdriver;
import static condition.WebViewAppear.webViewAppear;

public class DriverContext {

    public enum WebView {
        WEBVIEW("WEBVIEW_ru.niffer_android"), WEBVIEW_chrome("WEBVIEW_chrome");

        public final String name;

        WebView(String name) {
            this.name = name;
        }
    }

    public static void switchToWebView(WebView webView) {
        webdriver().shouldHave(webViewAppear(webView));
        SupportsContextSwitching driver = (SupportsContextSwitching) WebDriverRunner.getWebDriver();
        driver.context(webView.name);
    }

    public static void switchToNative() {
        SupportsContextSwitching driver = (SupportsContextSwitching)  WebDriverRunner.getWebDriver();
        driver.context("NATIVE_APP");
    }
}
