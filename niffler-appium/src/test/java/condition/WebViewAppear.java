package condition;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.ObjectCondition;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebDriver;
import utils.DriverContext;

import java.util.Set;

public class WebViewAppear implements ObjectCondition<WebDriver> {

    private final DriverContext.WebView webView;

    public static WebViewAppear webViewAppear(DriverContext.WebView webView) {
        return new WebViewAppear(webView);
    }

    private WebViewAppear(DriverContext.WebView webView) {
        this.webView = webView;
    }

    @Override
    public String description() {
        return "should have webview";
    }

    @Override
    public String negativeDescription() {
        return "should not have webview";
    }

    @Override
    public CheckResult check(WebDriver webDriver) {
        Set<String> contextHandles = ((SupportsContextSwitching) webDriver).getContextHandles();
        contextHandles.forEach(System.out::println);
        int count = contextHandles.size();
        boolean present = contextHandles.contains(webView.name);
        return result(webDriver, count > 1 && present, String.valueOf(count));
    }

    @Override
    public String expectedValue() {
        return webView.name;
    }

    @Override
    public String describe(WebDriver webDriver) {
        return "webdriver";
    }
}
