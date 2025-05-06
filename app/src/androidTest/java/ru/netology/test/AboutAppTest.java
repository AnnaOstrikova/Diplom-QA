package ru.netology.test;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.element.AuthElement;
import ru.netology.steps.AboutAppSteps;
import ru.netology.steps.AuthSteps;


@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("О приложении")

public class AboutAppTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorizationCheck() {
        AuthSteps.autorization();
    }

    @AfterClass
    public static void exit() {
        AuthElement.clickButtonExit(AuthElement.getAuthorizationElementsButtonExit());
        AuthSteps.clickButtonLogOut();
    }

    //  Тест-кейс №68 - Открытие ссылки Политика конфиденциальности.
    @Test
    @Story("Тест-кейс №68")
    @Description("Открытие ссылки Политика конфиденциальности")
    public void openingLinkPrivacyPolicy() {
        AboutAppSteps.clickButtonMainMenu();
        AboutAppSteps.clickButtonAbout();
        AboutAppSteps.clickPrivacyPolicy();
    }

    //  Тест-кейс №69 - Открытие ссылки Пользовательское соглашение.
    @Test
    @Story("Тест-кейс №69")
    @Description("Открытие ссылки Пользовательское соглашение")
    public void openingLinkTermsOfUse() {
        AboutAppSteps.clickButtonMainMenu();
        AboutAppSteps.clickButtonAbout();
        AboutAppSteps.clickTermsOfUse();
    }

    // Тест-кейс №70 - Выход со страницы через кнопку Назад
    @Test
    @Story("Тест-кейс №70")
    @Description("Выход со страницы через кнопку Назад")
    public void exitViaBackButton() {
        AboutAppSteps.clickButtonMainMenu();
        AboutAppSteps.clickButtonAbout();
        AboutAppSteps.clickButtonBack();
        AboutAppSteps.displayingNewsPage();
    }
}
