package ru.netology.element;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.steps.NewsSteps;

public class NewsElement extends NewsSteps {

    public static Matcher<View> getNewsElementsButtonMainMenu() {
        return allOf(withId(R.id.main_menu_image_button));
    }

    public static Matcher<View> getNewsElementsButtonNews() {
        return allOf(withId(android.R.id.title), withText("News"));
    }

    public static Matcher<View> getNewsElementsButtonEditing() {
        return allOf(withId(R.id.edit_news_material_button));
    }

    public static Matcher<View> getNewsElementsButtonAddingNews() {
        return allOf(withId(R.id.add_news_image_view));
    }

    public static Matcher<View> getCategoryCreatingNews() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static Matcher<View> getTitleCreatingNews() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public static Matcher<View> getDateCreatingNews() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public static Matcher<View> getButtonNewsOk() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getTimeCreatingNews() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public static Matcher<View> getButtonTimeOk() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getDescriptionNews() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public static Matcher<View> getButtonSaveNews() {
        return allOf(withId(R.id.save_button));
    }

    public static Matcher<View> getButtonCancel() {
        return allOf(withId(R.id.cancel_button));
    }

    public static Matcher<View> getButtonNewsSorting() {
        return allOf(withId(R.id.sort_news_material_button));
    }

    public static Matcher<View> getButtonFilterNews() {
        return allOf(withId(R.id.filter_news_material_button));
    }

    public static Matcher<View> getCategoryFilterNews() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static Matcher<View> getDateStartFilterNews() {
        return  allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    }

    public static Matcher<View> getDateEndFilterNews() {
        return  allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    }

    public static Matcher<View> getFilterButton() {
        return allOf(withId(R.id.filter_button));
    }
}