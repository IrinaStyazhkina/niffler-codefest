import { test, expect } from '../fixtures/login.fixture';

test.describe('Авторизаиция', () => {
    test('Успешный логин в мобильном браузере', async ({page, request}) => {
            await page.goto(
                'https://auth.niffler-stage.qa.guru/oauth2/authorize?response_type=code&client_id=mobile-client&scope=openid&redirect_uri=app://ru.niffler_android/callback&code_challenge=U7zqOYMwH35wG00z670ECYr5QLAlGUCbQ1f288B9fl0&code_challenge_method=S256');
            await page.waitForLoadState('networkidle');
            await page.locator("[id='username']").fill('stage');
            await page.locator("[id='password']").fill('12345');

            await Promise.all([
                page.waitForRequest((request) =>
                    request.url().includes("app://ru.niffler_android/callback?code=")
                ),
                page.locator("[id='login-button']").tap()
            ]);
    });

    test('Вход в кабинет с валидным токеном', async ({page, mockJSBridgeAuthToken}) => {
        await mockJSBridgeAuthToken();
        await page.goto('https://niffler-stage.qa.guru');
        await expect(page.locator("[id='legend-container']")).toBeVisible();
    });
});
