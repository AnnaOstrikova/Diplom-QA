package ru.netology.element;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.steps.AboutAppSteps;

public class AboutAppElement extends AboutAppSteps {

    public static Matcher<View> getAboutElementButtonAbout() {
        return allOf(withId(android.R.id.title), withText("About"));
    }

    public static Matcher<View> getAboutElementButtonBack() {
        return allOf(withId(R.id.about_back_image_button));
    }

    public static Matcher<View> getNewsPage() {
        return allOf(withText("News"));
    }
}

