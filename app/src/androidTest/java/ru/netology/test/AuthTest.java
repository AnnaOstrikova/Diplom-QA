package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.element.AuthElement;
import ru.netology.element.WaitElement;
import ru.netology.steps.AuthSteps;


@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Авторизация пользователя")

public class AuthTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    private final AuthSteps authSteps = new AuthSteps();
    private final AuthElement authElement = new AuthElement();
    private final WaitElement waitElement = new WaitElement();

    @Before
    public void setUp() {
        if (!authElement.waitForSplashScreen(3000).checkAuthorizationIsDisplayed()) {
                /*onView(withId(R.id.authorization_image_button)).check(matches(isDisplayed()));
                onView(withText("Log out")).check(matches(isDisplayed()));*/
            authSteps.clickButtonExit(authElement.getAuthorizationElementsButtonExit());
            authSteps.clickButtonLogOut();
        }
    }

    //  Тест-кейс №1 - Авторизация зарегистрированного пользователя.
    @Test
    @Story("Тест-кейс №1")
    @Description("Авторизация зарегистрированного пользователя")
    public void successfulAuthorization() {
        authSteps.clickLoginField();
        authSteps.clickPasswordField();
        authSteps.clickButton(authElement.getAutorizationElementsButton());
        authElement.waitForMainScreen(2000).checkDashboardIsDisplayed();
    }

//  Тест-кейс №2 - Авторизация незарегистрированного пользователя.

    @Test
    @Story("Тест-кейс №2")
    @Description("Авторизация незарегистрированного пользователя (неверный логин и пароль)")
    public void unsuccessfulAuthorization() {
        authSteps.clickLoginFieldWrong();
        authSteps.clickPasswordFieldWrong();
        authSteps.clickButton(authElement.getAutorizationElementsButton());
        onView(withText("Wrong login or password")) // Неверный логин или пароль
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));

    }

    //  Тест-кейс №3 - Авторизация незарегистрированного пользователя (с пустым логином)
    @Test
    @Story("Тест-кейс №3")
    @Description("Авторизация незарегистрированного пользователя (с пустым логином)")
    public void loginFieldIsEmpty() {
        authSteps.clickPasswordField();
        authSteps.clickButton(authElement.getAutorizationElementsButton());
        onView(withText("Login and password cannot be empty")) // Логин и пароль не могут быть пустыми
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }


    //  Тест-кейс №4 - Авторизация незарегистрированного пользователя (с пустым паролем).
    @Test
    @Story("Тест-кейс №4")
    @Description("Авторизация незарегистрированного пользователя (с пустым паролем)")
    public void passwordFieldIsEmpty() {
        authSteps.clickLoginField();
        authSteps.clickButton(authElement.getAutorizationElementsButton());
        onView(withText("Login and password cannot be empty")) // Логин и пароль не могут быть пустыми
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №5 - Авторизация пользователя без ввода логина и пароля
    @Test
    @Story("Тест-кейс №5")
    @Description("Авторизация пользователя без ввода логина и пароля")
    public void loginAndPasswordEmpty() {
        authSteps.clickButton(authElement.getAutorizationElementsButton());
        onView(withText("Login and password cannot be empty")) // Логин и пароль не могут быть пустыми
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №6 - Выход из учетной записи пользователя
    @Test
    @Story("Тест-кейс №6")
    @Description("Выход из учетной записи пользователя")
    public void loggingOut() {
        authSteps.clickLoginField();
        authSteps.clickPasswordField();
        authSteps.clickButton(authElement.getAutorizationElementsButton());
        authSteps.clickButtonExit(R.id.authorization_image_button);
        authSteps.clickButtonLogOut();
        authSteps.textAuthorization();
    }
}
