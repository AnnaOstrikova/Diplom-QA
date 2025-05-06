package ru.netology.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.element.NewsElement.getButtonCancel;
import static ru.netology.element.NewsElement.getButtonFilterNews;
import static ru.netology.element.NewsElement.getButtonNewsOk;
import static ru.netology.element.NewsElement.getButtonNewsSorting;
import static ru.netology.element.NewsElement.getButtonSaveNews;
import static ru.netology.element.NewsElement.getButtonTimeOk;
import static ru.netology.element.NewsElement.getCategoryCreatingNews;
import static ru.netology.element.NewsElement.getCategoryFilterNews;
import static ru.netology.element.NewsElement.getDateCreatingNews;
import static ru.netology.element.NewsElement.getDateEndFilterNews;
import static ru.netology.element.NewsElement.getDateStartFilterNews;
import static ru.netology.element.NewsElement.getDescriptionNews;
import static ru.netology.element.NewsElement.getFilterButton;
import static ru.netology.element.NewsElement.getNewsElementsButtonAddingNews;
import static ru.netology.element.NewsElement.getNewsElementsButtonEditing;
import static ru.netology.element.NewsElement.getNewsElementsButtonMainMenu;
import static ru.netology.element.NewsElement.getNewsElementsButtonNews;
import static ru.netology.element.NewsElement.getTimeCreatingNews;
import static ru.netology.element.NewsElement.getTitleCreatingNews;
import static ru.netology.element.WaitElement.waitFor;
import static ru.netology.element.WaitElement.waitUntilElement;
import static ru.netology.method.additionalActions.clickChildViewWithId;
import static ru.netology.method.additionalActions.getChildTextViewWithId;
import static ru.netology.method.additionalActions.getTextFromView;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsSteps {

    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
        waitUntilElement(R.id.main_menu_image_button);
        waitFor(2);
        onView(getNewsElementsButtonMainMenu())
                .perform(click());
    }

    public static void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости");
        waitUntilElement(android.R.id.title);
        onView(getNewsElementsButtonNews())
                .perform(click());
    }

    public static void clickButtonEditing() {
        Allure.step("Нажать на кнопку Редактирование");
        waitUntilElement(R.id.edit_news_material_button);
        onView(getNewsElementsButtonEditing())
                .perform(click());
    }

    public static void clickButtonAddingNews() {
        Allure.step("Нажать на кнопку Добавление новости");
        waitUntilElement(R.id.add_news_image_view);
        onView(getNewsElementsButtonAddingNews())
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNews() {
        Allure.step("Выбрать категорию для создания новости");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getCategoryCreatingNews())
                .perform(click(), replaceText("Объявление"), closeSoftKeyboard());
    }

    static String titleNews = "Изменения в графике работы специалистов";

    public static void clickButtonTitleCreatingNews() {
        Allure.step("Ввести заголовок новости");
        waitUntilElement(R.id.news_item_title_text_input_edit_text);
        onView(getTitleCreatingNews())
                .perform(click(), clearText(), replaceText(titleNews), closeSoftKeyboard());
    }

    public static void clickButtonDateCreatingNews() {
        Allure.step("Выбрать текущую дату публикации новости в календаре");
        waitUntilElement(R.id.news_item_publish_date_text_input_edit_text);
        onView(getDateCreatingNews())
                .perform(click());
        waitUntilElement(android.R.id.button1);
        onView(getButtonNewsOk())
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews() {
        Allure.step("Выбрать время публикации новости");
        waitUntilElement(R.id.news_item_publish_time_text_input_edit_text);
        onView(getTimeCreatingNews())
                .perform(click());
        waitUntilElement(android.R.id.button1);
        onView(getButtonTimeOk())
                .perform(click());
    }

    public static void clickDescriptionNews() {
        Allure.step(" Ввести описание новости в окне Описание");
        waitUntilElement(R.id.news_item_description_text_input_edit_text);
        onView(getDescriptionNews())
                .perform(replaceText("Важно"), closeSoftKeyboard());
    }

    public static void clickButtonSaveNews() {
        Allure.step("Нажать кнопку Сохранить");
        waitUntilElement(R.id.save_button);
        onView(getButtonSaveNews())
                .perform(scrollTo(), click());
    }

    public static void clickFilterNews() {
        Allure.step("Нажать Фильтр Новостей");
        waitUntilElement(R.id.filter_news_material_button);
        onView(getButtonFilterNews())
                .perform(click());
    }

    public static void clickButtonCategoryFilterNews() {
        Allure.step("Выбрать категорию для фильтра новостей");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getCategoryFilterNews())
                .perform(replaceText("Объявление"));

    }

    public static void clickButtonDateStartFilterNews() {
        Allure.step("Выбрать текущую дату публикации новости в календаре фильтра");
        waitUntilElement(R.id.news_item_publish_date_start_text_input_edit_text);
        onView(getDateStartFilterNews())
                .perform(click());
        waitUntilElement(android.R.id.button1);
        onView(getButtonNewsOk())
                .perform(click());
    }

    public static void clickButtonDateEndFilterNews() {
        Allure.step("Выбрать текущую дату публикации новости в календаре фильтра");
        waitUntilElement(R.id.news_item_publish_date_end_text_input_edit_text);
        onView(getDateEndFilterNews())
                .perform(click());
        waitUntilElement(android.R.id.button1);
        onView(getButtonTimeOk())
                .perform(click());
    }

    public static void clickButtonFilter() {
        Allure.step("Нажать кнопку Фильтр");
        waitUntilElement(R.id.filter_button);
        onView(getFilterButton())
                .perform(click());
    }

    public static void clickButtonNewsSorting() {
        Allure.step("Нажать кнопку сортировка новостей");
        waitUntilElement(R.id.sort_news_material_button);
        onView(getButtonNewsSorting())
                .perform(click());
    }

    public static void newsSearch() {
        Allure.step("Наити новость");
        onView(allOf(
                withId(R.id.news_item_title_text_view),
                withText(titleNews)))
                .check(matches(isDisplayed())).perform(scrollTo());
    }

    public static void deleteNews() {
        Allure.step("Удалить новость");

        final ViewInteraction recyclerView = onView(withId(R.id.news_list_recycler_view));
        ViewInteraction firstNewsTitle = recyclerView.perform(actionOnItemAtPosition(0, getChildTextViewWithId(R.id.news_item_title_text_view)));
        final String deletedNewsTitle = getTextFromView(firstNewsTitle);

        recyclerView.perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(withId(android.R.id.message)).check(matches(isDisplayed()));
        onView(withId(android.R.id.button1)).check(matches(isDisplayed())).perform(click());

        onView(withText(deletedNewsTitle)).check(doesNotExist());
    }

    public static void deleteNewsInFilter() {
        Allure.step("Удалить новость из фильтра");
        onView(allOf(withId(R.id.delete_news_item_image_view), hasSibling(withText(titleNews)))).perform(click());
        onView(withId(android.R.id.button1))
                .check(matches(isDisplayed()));
        // подтверждаем удаление новости
        onView(withId(android.R.id.button1)).perform(click());


    }

    public static void clickButtonCancel() {
        Allure.step("Нажать кнопку Отменить");
        waitUntilElement(R.id.cancel_button);
        onView(getButtonCancel())
                .perform(scrollTo(), click());
        onView(withId(android.R.id.button1)).check(matches(isDisplayed())).perform(click());
    }

    public static void controlPanelIsDisplayed() {
        onView(withText("Control panel"))
                .check(matches(isDisplayed()));
    }

    public static void clickCancelButtonCancel() {
        Allure.step("Отмена сообщения об отмене");
        waitUntilElement(R.id.cancel_button);
        onView(getButtonCancel())
                .perform(scrollTo(), click());
        onView(withId(android.R.id.button2)).check(matches(isDisplayed())).perform(click());
    }

    public static void creatingNewsIsDisplayed() {
        onView(withText("Creating"))
                .check(matches(isDisplayed()));
    }

}
