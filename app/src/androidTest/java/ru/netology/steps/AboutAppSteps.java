package ru.netology.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.element.AboutAppElement.getAboutElementButtonAbout;
import static ru.netology.element.AboutAppElement.getAboutElementButtonBack;
import static ru.netology.element.AboutAppElement.getNewsPage;
import static ru.netology.element.NewsElement.getNewsElementsButtonMainMenu;
import static ru.netology.element.WaitElement.waitFor;
import static ru.netology.element.WaitElement.waitUntilElement;

import android.content.Intent;
import android.os.SystemClock;

import androidx.test.espresso.intent.Intents;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AboutAppSteps {
    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
        waitUntilElement(R.id.main_menu_image_button);
        waitFor(2);
        onView(getNewsElementsButtonMainMenu())
                .perform(click());
    }

    public static void clickButtonAbout() {
        Allure.step("Нажать на кнопку О приложении");
        waitUntilElement(android.R.id.title);
        onView(getAboutElementButtonAbout())
                .perform(click());
    }

    public static void clickPrivacyPolicy() {
        Allure.step("Нажать на ссылку Политика конфиденциальности");

        String uriPrivacyPolicy = "https://vhospice.org/#/privacy-policy/";
        Intents.init();
        onView(withId(R.id.about_privacy_policy_value_text_view)).perform(click());
        SystemClock.sleep(3000);
        intended(allOf(hasData(uriPrivacyPolicy), hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }

    public static void clickTermsOfUse() {
        Allure.step("Нажать на ссылку Пользовательское соглашение");

        String uriPrivacyPolicy = "https://vhospice.org/#/terms-of-use";
        Intents.init();
        onView(withId(R.id.about_terms_of_use_value_text_view)).perform(click());
        SystemClock.sleep(3000);
        intended(allOf(hasData(uriPrivacyPolicy), hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }

    public static void clickButtonBack() {
        Allure.step("Нажать на кнопку Назад");
        waitUntilElement(R.id.about_back_image_button);
        onView(getAboutElementButtonBack())
                .perform(click());;
    }

    public static void displayingNewsPage() {
        Allure.step("Открывается страница Новости");
        waitUntilElement(R.id.container_list_news_include_on_fragment_main);
        waitFor(3);
        onView(getNewsPage())
                .check(matches(isDisplayed()));
    }
}
