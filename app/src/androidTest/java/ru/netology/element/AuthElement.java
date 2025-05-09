package ru.netology.element;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import android.view.View;
import androidx.test.espresso.NoMatchingViewException;
import org.hamcrest.Matcher;
import ru.iteco.fmhandroid.R;
import ru.netology.data.AuxiliaryActions;

public class AuthElement {

    public AuthElement waitForSplashScreen(long millis) {
        onView(isRoot()).perform(AuxiliaryActions.waitFor(millis));
        return this;
    }
    public AuthElement waitForMainScreen(long millis) {
        onView(isRoot()).perform(AuxiliaryActions.waitFor(millis));
        return this;
    }

    public void checkDashboardIsDisplayed() {
        onView(withId(R.id.container_custom_app_bar_include_on_fragment_main))
                .check(matches(isDisplayed()));
    }
    public boolean checkAuthorizationIsDisplayed() {
        try {
            onView(withText("Authorization")).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException e) {
            return false;
        }
    }

    public int getAutorizationElementsButton () {
        return R.id.enter_button;
    }

    public Matcher<View> getAuthorizationElementsLoginField() {
        return allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout))));
    }

    public Matcher<View> getAuthorizationElementsPasswordField() {
        return allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout))));
    }

    public int getAuthorizationElementsButtonExit() {
        return R.id.authorization_image_button;

    }

    public Matcher<View> getAuthorizationElementsButtonLogOut() {
        return allOf(withId(android.R.id.title), withText("Log out"));
    }

    public Matcher<View> getAuthorizationElementsTextAuthorization() {
        return allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))));
    }
}