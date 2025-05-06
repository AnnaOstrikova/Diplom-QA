package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.netology.element.WaitElement.waitFor;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.NoMatchingViewException;
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
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.element.AuthElement;
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

    @Before
    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Before
    public void authorizationVerification() {
        try {
            AuthSteps.textAuthorization();
        }catch (NoMatchingViewException e) {
            AuthSteps.clickButtonExit(AuthElement.getAuthorizationElementsButtonExit());
            AuthSteps.clickButtonLogOut();
        }
    }

//  Тест-кейс №1 - Авторизация зарегистрированного пользователя.
    @Test
    @Story("Тест-кейс №1")
    @Description("Авторизация зарегистрированного пользователя")
    public void successfulAuthorization() {
        AuthSteps.clickLoginField();
        AuthSteps.clickPasswordField();
        AuthElement.clickButton(AuthElement.getAutorizationElementsButton());
        AuthElement.clickButtonExit(AuthElement.getAuthorizationElementsButtonExit());
        AuthElement.clickButtonLogOut();
    }
//  Тест-кейс №2 - Авторизация незарегистрированного пользователя.

    @Test
    @Story("Тест-кейс №2")
    @Description("Авторизация незарегистрированного пользователя (неверный логин и пароль)")
    public void unsuccessfulAuthorization() {
        AuthSteps.clickLoginFieldWrong();
        AuthSteps.clickPasswordFieldWrong();
        AuthElement.clickButton(AuthElement.getAutorizationElementsButton());
        waitFor(1);
        onView(withText("Wrong login or password")) // Неверный логин или пароль
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));

    }

    //  Тест-кейс №3 - Авторизация незарегистрированного пользователя (с пустым логином)
    @Test
    @Story("Тест-кейс №3")
    @Description("Авторизация незарегистрированного пользователя (с пустым логином)")
    public void loginFieldIsEmpty() {
        AuthSteps.clickPasswordField();
        AuthElement.clickButton(AuthElement.getAutorizationElementsButton());
        waitFor(1);
        onView(withText("Login and password cannot be empty")) // Логин и пароль не могут быть пустыми
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }


    //  Тест-кейс №4 - Авторизация незарегистрированного пользователя (с пустым паролем).
    @Test
    @Story("Тест-кейс №4")
    @Description("Авторизация незарегистрированного пользователя (с пустым паролем)")
    public void passwordFieldIsEmpty() {
        AuthSteps.clickLoginField();
        AuthElement.clickButton(AuthElement.getAutorizationElementsButton());
        waitFor(1);
        onView(withText("Login and password cannot be empty")) // Логин и пароль не могут быть пустыми
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №5 - Авторизация пользователя без ввода логина и пароля
    @Test
    @Story("Тест-кейс №5")
    @Description("Авторизация пользователя без ввода логина и пароля")
    public void loginAndPasswordEmpty() {
        AuthElement.clickButton(AuthElement.getAutorizationElementsButton());
        waitFor(1);
        onView(withText("Login and password cannot be empty")) // Логин и пароль не могут быть пустыми
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №6 - Выход из учетной записи пользователя
    @Test
    @Story("Тест-кейс №6")
    @Description("Выход из учетной записи пользователя")
    public void loggingOut() {
        AuthSteps.clickLoginField();
        AuthSteps.clickPasswordField();
        AuthElement.clickButton(AuthElement.getAutorizationElementsButton());
        AuthElement.clickButtonExit(AuthElement.getAuthorizationElementsButtonExit());
        AuthElement.clickButtonLogOut();
        AuthSteps.textAuthorization();
    }
}
