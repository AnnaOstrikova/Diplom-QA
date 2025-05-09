package ru.netology.data;

import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class AuxiliaryActions {

    public static Matcher<View> isDescendantOfA(final Matcher<View> parentMatcher) {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("is descendant of: ");
                parentMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                while (parent instanceof ViewGroup) {
                    if (parentMatcher.matches(parent)) {
                        return true;
                    }
                    parent = parent.getParent();
                }
                return false;
            }
        };
    }

    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for " + millis + " milliseconds";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }
}