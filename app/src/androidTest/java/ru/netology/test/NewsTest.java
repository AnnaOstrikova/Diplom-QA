package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import android.view.View;
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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.element.AuthElement;
import ru.netology.element.WaitElement;
import ru.netology.steps.AuthSteps;
import ru.netology.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Добавления новости в режиме редактирования")

public class NewsTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    private final AuthSteps authSteps = new AuthSteps();
    private final AuthElement authElement = new AuthElement();
    private final NewsSteps newsSteps= new NewsSteps();
    private final WaitElement waitElement = new WaitElement();

    @Before
    public void setUp() {
        if (authElement.waitForSplashScreen(3000).checkAuthorizationIsDisplayed()) {
            authSteps.clickLoginField();
            authSteps.clickPasswordField();
            authSteps.clickButton(authElement.getAutorizationElementsButton());
        }
    }

    //  Тест-кейс №45 - Добавление новости в режиме редактирования.
    @Test
    @Story("Тест-кейс №45")
    @Description("Добавление новости в режиме редактирования")
    public void addingNews() {
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonCategoryCreatingNews();
        newsSteps.clickButtonTitleCreatingNews();
        newsSteps.clickButtonDateCreatingNews();
        newsSteps.clickButtonTimeCreatingNews();
        newsSteps.clickDescriptionNews();
        newsSteps.clickButtonSaveNews();
        newsSteps.clickFilterNews();
        newsSteps.clickButtonCategoryFilterNews();
        newsSteps.clickButtonDateStartFilterNews();
        newsSteps.clickButtonDateEndFilterNews();
        newsSteps.clickButtonFilter();
        newsSteps.deleteNewsInFilter();
    }

    //  Тест-кейс №46 - Отмена создания новости.
    @Test
    @Story("Тест-кейс №46")
    @Description("Отмена создания новости")
    public void cancelNewsCreation() {
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonCancel();
        newsSteps.controlPanelIsDisplayed();
    }

    //  Тест-кейс №47 - Отмена Отмены создания новости.
    @Test
    @Story("Тест-кейс №47")
    @Description("Отмена Отмены создания новости")
    public void removeCancellationOfNewsCreation() {
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickCancelButtonCancel();
        newsSteps.creatingNewsIsDisplayed();
    }

    //  Тест-кейс №48 - Добавление новости в режиме редактирования без заполения категории.
    @Test
    @Story("Тест-кейс №48")
    @Description("Добавление новости в режиме редактирования без заполения категории")
    public void addingNewsWithoutACategory(){
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonTitleCreatingNews();
        newsSteps.clickButtonDateCreatingNews();
        newsSteps.clickButtonTimeCreatingNews();
        newsSteps.clickDescriptionNews();
        newsSteps.clickButtonSaveNews();
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №49 - Добавление новости в режиме редактирования без заполения поля Заголовок.
    @Test
    @Story("Тест-кейс №49")
    @Description("Добавление новости в режиме редактирования без заполения поля Заголовок")
    public void addingNewsWithoutATittle() {
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonCategoryCreatingNews();
        newsSteps.clickButtonDateCreatingNews();
        newsSteps.clickButtonTimeCreatingNews();
        newsSteps.clickDescriptionNews();
        newsSteps.clickButtonSaveNews();
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №50 - Добавление новости в режиме редактирования без Даты публикации.
    @Test
    @Story("Тест-кейс №50")
    @Description("Добавление новости в режиме редактирования без Даты публикации")
    public void addingNewsWithoutAPublicationDate(){
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonCategoryCreatingNews();
        newsSteps.clickButtonTitleCreatingNews();
        newsSteps.clickButtonTimeCreatingNews();
        newsSteps.clickDescriptionNews();
        newsSteps.clickButtonSaveNews();
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №51 - Добавление новости в режиме редактирования без Времени.
    @Test
    @Story("Тест-кейс №51")
    @Description("Добавление новости в режиме редактирования без Времени")
    public void addingNewsWithoutAPublicationTime(){
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonCategoryCreatingNews();
        newsSteps.clickButtonTitleCreatingNews();
        newsSteps.clickButtonDateCreatingNews();
        newsSteps.clickDescriptionNews();
        newsSteps.clickButtonSaveNews();
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №52 - Добавление новости в режиме редактирования без Описания.
    @Test
    @Story("Тест-кейс №52")
    @Description("Добавление новости в режиме редактирования без Описания")
    public void addingNewsWithoutDescription(){
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonCategoryCreatingNews();
        newsSteps.clickButtonTitleCreatingNews();
        newsSteps.clickButtonDateCreatingNews();
        newsSteps.clickButtonTimeCreatingNews();
        newsSteps.clickButtonSaveNews();
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №53 - Добавление новости в режиме редактирования без заполения полей.
    @Test
    @Story("Тест-кейс №53")
    @Description("Добавление новости в режиме редактирования без заполения полей")
    public void addingNewsWithoutFillingInFields(){
        newsSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        newsSteps.clickButtonEditing();
        newsSteps.clickButtonAddingNews();
        newsSteps.clickButtonSaveNews();
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}

