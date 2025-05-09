package ru.netology.element;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;


public class NewsElement {

    public Matcher<View> getNewsElementsButtonMainMenu() {
        return allOf(withId(R.id.main_menu_image_button));
    }

    public Matcher<View> getNewsElementsButtonNews() {
        return allOf(withId(android.R.id.title), withText("News"));
    }

    public Matcher<View> getNewsElementsButtonEditing() {
        return allOf(withId(R.id.edit_news_material_button));
    }

    public Matcher<View> getNewsElementsButtonAddingNews() {
        return allOf(withId(R.id.add_news_image_view));
    }

    public Matcher<View> getCategoryCreatingNews() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public Matcher<View> getTitleCreatingNews() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public Matcher<View> getDateCreatingNews() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public Matcher<View> getButtonNewsOk() {
        return allOf(withId(android.R.id.button1));
    }

    public Matcher<View> getTimeCreatingNews() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public Matcher<View> getButtonTimeOk() {
        return allOf(withId(android.R.id.button1));
    }

    public Matcher<View> getDescriptionNews() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public Matcher<View> getButtonSaveNews() {
        return allOf(withId(R.id.save_button));
    }

    public Matcher<View> getButtonCancel() {
        return allOf(withId(R.id.cancel_button));
    }

    public Matcher<View> getButtonNewsSorting() {
        return allOf(withId(R.id.sort_news_material_button));
    }

    public Matcher<View> getButtonFilterNews() {
        return allOf(withId(R.id.filter_news_material_button));
    }

    public Matcher<View> getCategoryFilterNews() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public Matcher<View> getDateStartFilterNews() {
        return allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    }

    public Matcher<View> getDateEndFilterNews() {
        return allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    }

    public Matcher<View> getFilterButton() {
        return allOf(withId(R.id.filter_button));
    }
}