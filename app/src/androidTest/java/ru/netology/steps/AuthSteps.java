package ru.netology.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import static ru.netology.element.AuthElement.getAuthorizationElementsButtonLogOut;
import static ru.netology.element.AuthElement.getAuthorizationElementsLoginField;
import static ru.netology.element.AuthElement.getAuthorizationElementsPasswordField;
import static ru.netology.element.AuthElement.getAuthorizationElementsTextAuthorization;
import static ru.netology.element.WaitElement.waitFor;
import static ru.netology.element.WaitElement.waitUntilElement;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.element.AuthElement;


public class AuthSteps {

    static String validlogin = "login2";
    static String validPassword = "password2";
    static String wrongLogin = "login";
    static String wrongPassword = "password";


    public static void autorization() {
        try {
            AuthElement.textAuthorization();
        } catch (NoMatchingViewException e) {
            return;
        }
        waitFor(2);
        AuthElement.clickLoginField();
        AuthElement.clickPasswordField();
        AuthElement.clickButton(AuthElement.getAutorizationElementsButton());
    }

    public static void clickButton(Integer resourceId) {
        Allure.step("Нажать на кнопку Войти");
        waitUntilElement(R.id.enter_button);
        onView(withId(resourceId))
                .perform(click());
    }

    public static void clickLoginField() {
        Allure.step("В поле Логин ввести логин зарегистрированного пользователя");
        waitUntilElement(R.id.login_text_input_layout);
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText(validlogin), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
    public static void clickLoginFieldWrong() {
        Allure.step("В поле Логин ввести логин незарегистрированного пользователя");
        waitUntilElement(R.id.login_text_input_layout);
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText(wrongLogin), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordField() {
        Allure.step("В поле Пароль ввести пароль зарегистрированного пользователя");
        waitUntilElement(R.id.password_text_input_layout);
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText(validPassword), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
    public static void clickPasswordFieldWrong() {
        Allure.step("В поле Пароль ввести пароль незарегистрированного пользователя");
        waitUntilElement(R.id.password_text_input_layout);
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText(wrongPassword), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickButtonExit(Integer resourceId) {
        Allure.step("Нажать на кнопку Выход");
        waitUntilElement(R.id.authorization_image_button);
        waitFor(5);
        onView(withId(resourceId))
                .perform(click());
    }

    public static void clickButtonLogOut() {
        Allure.step("Нажать на кнопку для выхода из приложения");
        waitUntilElement(android.R.id.title);
        onView(getAuthorizationElementsButtonLogOut())
                .perform(click());
    }

    public static void textAuthorization() {
        Allure.step("Отобразилаcь страница Авторизации");
        waitUntilElement(R.id.nav_host_fragment);
        waitFor(3);
        onView(getAuthorizationElementsTextAuthorization())
                .check(matches(isDisplayed()));
    }
}