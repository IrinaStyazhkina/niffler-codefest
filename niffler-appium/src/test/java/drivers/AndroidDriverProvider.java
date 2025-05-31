package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.URI;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class AndroidDriverProvider implements WebDriverProvider {

    private static final ClassLoader cl = AndroidDriverProvider.class.getClassLoader();

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options()
                .merge(capabilities)
                .setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName("Pixel 9 Pro API 35")
                .setPlatformVersion("15.0")
                .setAppPackage("ru.niffer_android")
                .setAppActivity("ru.niffer_android.ui.auth.StartActivity")
                .setChromedriverExecutable("/opt/homebrew/bin/chromedriver")
                .setApp(cl.getResource("app-stage-debug.apk").getPath());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private URL getAppiumServerUrl() {
        try {
            return new URI("http://localhost:4723/wd/hub").toURL();
        } catch (Exception e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }
}
