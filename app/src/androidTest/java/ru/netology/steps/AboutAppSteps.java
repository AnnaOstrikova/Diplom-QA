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
import android.content.Intent;
import androidx.test.espresso.intent.Intents;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.element.NewsElement;
import ru.netology.element.WaitElement;

public class AboutAppSteps {

    private final NewsElement newsElement = new NewsElement();
    private final WaitElement waitElement = new WaitElement();

    public void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
        waitElement.waitUntilElement(R.id.main_menu_image_button);
        onView(newsElement.getNewsElementsButtonMainMenu())
                .perform(click());
    }

    public void clickButtonAbout() {
        Allure.step("Нажать на кнопку О приложении");
        waitElement.waitUntilElement(android.R.id.title);
        onView(getAboutElementButtonAbout())
                .perform(click());
    }

    public void clickPrivacyPolicy() {
        Allure.step("Нажать на ссылку Политика конфиденциальности");

        String uriPrivacyPolicy = "https://vhospice.org/#/privacy-policy/";
        Intents.init();
        onView(withId(R.id.about_privacy_policy_value_text_view)).perform(click());
        intended(allOf(hasData(uriPrivacyPolicy), hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }

    public void clickTermsOfUse() {
        Allure.step("Нажать на ссылку Пользовательское соглашение");

        String uriPrivacyPolicy = "https://vhospice.org/#/terms-of-use";
        Intents.init();
        onView(withId(R.id.about_terms_of_use_value_text_view)).perform(click());
        intended(allOf(hasData(uriPrivacyPolicy), hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }

    public void clickButtonBack() {
        Allure.step("Нажать на кнопку Назад");
        waitElement.waitUntilElement(R.id.about_back_image_button);
        onView(getAboutElementButtonBack())
                .perform(click());;
    }

    public void displayingNewsPage() {
        Allure.step("Открывается страница Новости");
        waitElement.waitUntilElement(R.id.container_list_news_include_on_fragment_main);
        onView(getNewsPage())
                .check(matches(isDisplayed()));
    }
}
