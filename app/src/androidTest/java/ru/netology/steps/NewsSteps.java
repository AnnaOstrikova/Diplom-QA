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



import static ru.netology.method.TestUtils.clickChildViewWithId;
import static ru.netology.method.TestUtils.getChildTextViewWithId;
import static ru.netology.method.TestUtils.getTextFromView;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.element.NewsElement;
import ru.netology.element.WaitElement;

public class NewsSteps {

    private final NewsElement newsElement = new NewsElement();
    private final WaitElement waitElement = new WaitElement();

    public void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
        waitElement.waitUntilElement(R.id.main_menu_image_button);
        /*waitElement.waitFor(2);*/
        onView(newsElement.getNewsElementsButtonMainMenu())
                .perform(click());
    }

    public void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости");
        waitElement.waitUntilElement(android.R.id.title);
        onView(newsElement.getNewsElementsButtonNews())
                .perform(click());
    }

    public void clickButtonEditing() {
        Allure.step("Нажать на кнопку Редактирование");
        waitElement.waitUntilElement(R.id.edit_news_material_button);
        onView(newsElement.getNewsElementsButtonEditing())
                .perform(click());
    }

    public void clickButtonAddingNews() {
        Allure.step("Нажать на кнопку Добавление новости");
        waitElement.waitUntilElement(R.id.add_news_image_view);
        onView(newsElement.getNewsElementsButtonAddingNews())
                .perform(click());
    }

    public void clickButtonCategoryCreatingNews() {
        Allure.step("Выбрать категорию для создания новости");
        waitElement.waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(newsElement.getCategoryCreatingNews())
                .perform(click(), replaceText("Объявление"), closeSoftKeyboard());
    }

    static String titleNews = "Изменения в графике работы специалистов";

    public void clickButtonTitleCreatingNews() {
        Allure.step("Ввести заголовок новости");
        waitElement.waitUntilElement(R.id.news_item_title_text_input_edit_text);
        onView(newsElement.getTitleCreatingNews())
                .perform(click(), clearText(), replaceText(titleNews), closeSoftKeyboard());
    }

    public void clickButtonDateCreatingNews() {
        Allure.step("Выбрать текущую дату публикации новости в календаре");
        waitElement.waitUntilElement(R.id.news_item_publish_date_text_input_edit_text);
        onView(newsElement.getDateCreatingNews())
                .perform(click());
        waitElement.waitUntilElement(android.R.id.button1);
        onView(newsElement.getButtonNewsOk())
                .perform(click());
    }

    public void clickButtonTimeCreatingNews() {
        Allure.step("Выбрать время публикации новости");
        waitElement.waitUntilElement(R.id.news_item_publish_time_text_input_edit_text);
        onView(newsElement.getTimeCreatingNews())
                .perform(click());
        waitElement.waitUntilElement(android.R.id.button1);
        onView(newsElement.getButtonTimeOk())
                .perform(click());
    }

    public void clickDescriptionNews() {
        Allure.step(" Ввести описание новости в окне Описание");
        waitElement.waitUntilElement(R.id.news_item_description_text_input_edit_text);
        onView(newsElement.getDescriptionNews())
                .perform(replaceText("Важно"), closeSoftKeyboard());
    }

    public void clickButtonSaveNews() {
        Allure.step("Нажать кнопку Сохранить");
        waitElement.waitUntilElement(R.id.save_button);
        onView(newsElement.getButtonSaveNews())
                .perform(scrollTo(), click());
    }

    public void clickFilterNews() {
        Allure.step("Нажать Фильтр Новостей");
        waitElement.waitUntilElement(R.id.filter_news_material_button);
        onView(newsElement.getButtonFilterNews())
                .perform(click());
    }

    public void clickButtonCategoryFilterNews() {
        Allure.step("Выбрать категорию для фильтра новостей");
        waitElement.waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(newsElement.getCategoryFilterNews())
                .perform(replaceText("Объявление"));

    }

    public void clickButtonDateStartFilterNews() {
        Allure.step("Выбрать текущую дату публикации новости в календаре фильтра");
        waitElement.waitUntilElement(R.id.news_item_publish_date_start_text_input_edit_text);
        onView(newsElement.getDateStartFilterNews())
                .perform(click());
        waitElement.waitUntilElement(android.R.id.button1);
        onView(newsElement.getButtonNewsOk())
                .perform(click());
    }

    public void clickButtonDateEndFilterNews() {
        Allure.step("Выбрать текущую дату публикации новости в календаре фильтра");
        waitElement.waitUntilElement(R.id.news_item_publish_date_end_text_input_edit_text);
        onView(newsElement.getDateEndFilterNews())
                .perform(click());
        waitElement. waitUntilElement(android.R.id.button1);
        onView(newsElement.getButtonTimeOk())
                .perform(click());
    }

    public void clickButtonFilter() {
        Allure.step("Нажать кнопку Фильтр");
        waitElement.waitUntilElement(R.id.filter_button);
        onView(newsElement.getFilterButton())
                .perform(click());
    }

    public void clickButtonNewsSorting() {
        Allure.step("Нажать кнопку сортировка новостей");
        waitElement.waitUntilElement(R.id.sort_news_material_button);
        onView(newsElement.getButtonNewsSorting())
                .perform(click());
    }

    public void newsSearch() {
        Allure.step("Наити новость");
        onView(allOf(
                withId(R.id.news_item_title_text_view),
                withText(titleNews)))
                .check(matches(isDisplayed())).perform(scrollTo());
    }

    public void deleteNews() {
        Allure.step("Удалить новость");

        final ViewInteraction recyclerView = onView(withId(R.id.news_list_recycler_view));
        ViewInteraction firstNewsTitle = recyclerView.perform(actionOnItemAtPosition(0, getChildTextViewWithId(R.id.news_item_title_text_view)));
        final String deletedNewsTitle = getTextFromView(firstNewsTitle);

        recyclerView.perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(withId(android.R.id.message)).check(matches(isDisplayed()));
        onView(withId(android.R.id.button1)).check(matches(isDisplayed())).perform(click());

        onView(withText(deletedNewsTitle)).check(doesNotExist());
    }

    public void deleteNewsInFilter() {
        Allure.step("Удалить новость из фильтра");
        onView(allOf(withId(R.id.delete_news_item_image_view), hasSibling(withText(titleNews)))).perform(click());
        onView(withId(android.R.id.button1))
                .check(matches(isDisplayed()));
        // подтверждаем удаление новости
        onView(withId(android.R.id.button1)).perform(click());


    }

    public void clickButtonCancel() {
        Allure.step("Нажать кнопку Отменить");
        waitElement.waitUntilElement(R.id.cancel_button);
        onView(newsElement.getButtonCancel())
                .perform(scrollTo(), click());
        onView(withId(android.R.id.button1)).check(matches(isDisplayed())).perform(click());
    }

    public void controlPanelIsDisplayed() {
        onView(withText("Control panel"))
                .check(matches(isDisplayed()));
    }

    public void clickCancelButtonCancel() {
        Allure.step("Отмена сообщения об отмене");
        waitElement.waitUntilElement(R.id.cancel_button);
        onView(newsElement.getButtonCancel())
                .perform(scrollTo(), click());
        onView(withId(android.R.id.button2)).check(matches(isDisplayed())).perform(click());
    }

    public void creatingNewsIsDisplayed() {
        onView(withText("Creating"))
                .check(matches(isDisplayed()));
    }
}
