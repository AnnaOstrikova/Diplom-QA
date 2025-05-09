package ru.netology.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.element.AuthElement;
import ru.netology.element.WaitElement;



public class AuthSteps {
    private final AuthElement authElement = new AuthElement();
    private final WaitElement waitElement = new WaitElement();

    static String validlogin = "login2";
    static String validPassword = "password2";
    static String wrongLogin = "login";
    static String wrongPassword = "password";


    public void clickButton(Integer resourceId) {
        Allure.step("Нажать на кнопку Войти");
        waitElement.waitUntilElement(R.id.enter_button);
        onView(withId(resourceId))
                .perform(click());
    }

    public void clickLoginField() {
        Allure.step("В поле Логин ввести логин зарегистрированного пользователя");
        waitElement.waitUntilElement(R.id.login_text_input_layout);
        onView(authElement.getAuthorizationElementsLoginField())
                .perform(replaceText(validlogin), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
    public void clickLoginFieldWrong() {
        Allure.step("В поле Логин ввести логин незарегистрированного пользователя");
        waitElement.waitUntilElement(R.id.login_text_input_layout);
        onView(authElement.getAuthorizationElementsLoginField())
                .perform(replaceText(wrongLogin), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public void clickPasswordField() {
        Allure.step("В поле Пароль ввести пароль зарегистрированного пользователя");
        waitElement.waitUntilElement(R.id.password_text_input_layout);
        onView(authElement.getAuthorizationElementsPasswordField())
                .perform(replaceText(validPassword), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
    public void clickPasswordFieldWrong() {
        Allure.step("В поле Пароль ввести пароль незарегистрированного пользователя");
        waitElement.waitUntilElement(R.id.password_text_input_layout);
        onView(authElement.getAuthorizationElementsPasswordField())
                .perform(replaceText(wrongPassword), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public void clickButtonExit(Integer resourceId) {
        Allure.step("Нажать на кнопку Выход");
        waitElement.waitUntilElement(R.id.authorization_image_button);
        onView(withId(resourceId))
                .perform(click());
    }

    public void clickButtonLogOut() {
        Allure.step("Нажать на кнопку для выхода из приложения");
        waitElement.waitUntilElement(android.R.id.title);
        onView(authElement.getAuthorizationElementsButtonLogOut())
                .perform(click());
    }

    public void textAuthorization() {
        Allure.step("Отобразилаcь страница Авторизации");
        waitElement.waitUntilElement(R.id.nav_host_fragment);
        onView(authElement.getAuthorizationElementsTextAuthorization())
                .check(matches(isDisplayed()));
    }
}