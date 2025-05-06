package ru.netology.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.netology.element.WaitElement.waitFor;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
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

    @Before
    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }


    @Before
    public void authorizationCheck() {
        AuthSteps.autorization();
    }

    @AfterClass
    public static void exit() {
        AuthElement.clickButtonExit(AuthElement.getAuthorizationElementsButtonExit());
        AuthSteps.clickButtonLogOut();
    }

    //  Тест-кейс №45 - Добавление новости в режиме редактирования.
    @Test
    @Story("Тест-кейс №45")
    @Description("Добавление новости в режиме редактирования")
    public void addingNews() {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickDescriptionNews();
        NewsSteps.clickButtonSaveNews();
        NewsSteps.clickFilterNews();
        NewsSteps.clickButtonCategoryFilterNews();
        NewsSteps.clickButtonDateStartFilterNews();
        NewsSteps.clickButtonDateEndFilterNews();
        NewsSteps.clickButtonFilter();
        NewsSteps.deleteNewsInFilter();
    }

    //  Тест-кейс №46 - Отмена создания новости.
    @Test
    @Story("Тест-кейс №46")
    @Description("Отмена создания новости")
    public void cancelNewsCreation() {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonCancel();
        NewsSteps.controlPanelIsDisplayed();
    }

    //  Тест-кейс №47 - Отмена Отмены создания новости.
    @Test
    @Story("Тест-кейс №47")
    @Description("Отмена Отмены создания новости")
    public void removeCancellationOfNewsCreation() {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickCancelButtonCancel();
        NewsSteps.creatingNewsIsDisplayed();
    }

    //  Тест-кейс №48 - Добавление новости в режиме редактирования без заполения категории.
    @Test
    @Story("Тест-кейс №48")
    @Description("Добавление новости в режиме редактирования без заполения категории")
    public void addingNewsWithoutACategory(){
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickDescriptionNews();
        NewsSteps.clickButtonSaveNews();
        waitFor(1);
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №49 - Добавление новости в режиме редактирования без заполения поля Заголовок.
    @Test
    @Story("Тест-кейс №49")
    @Description("Добавление новости в режиме редактирования без заполения поля Заголовок")
    public void addingNewsWithoutATittle() {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickDescriptionNews();
        NewsSteps.clickButtonSaveNews();
        waitFor(1);
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №50 - Добавление новости в режиме редактирования без Даты публикации.
    @Test
    @Story("Тест-кейс №50")
    @Description("Добавление новости в режиме редактирования без Даты публикации")
    public void addingNewsWithoutAPublicationDate() throws InterruptedException {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickDescriptionNews();
        NewsSteps.clickButtonSaveNews();
        waitFor(1);
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №51 - Добавление новости в режиме редактирования без Времени.
    @Test
    @Story("Тест-кейс №51")
    @Description("Добавление новости в режиме редактирования без Времени")
    public void addingNewsWithoutAPublicationTime() throws InterruptedException {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickDescriptionNews();
        NewsSteps.clickButtonSaveNews();
        Thread.sleep(1000);
        waitFor(1);
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №52 - Добавление новости в режиме редактирования без Описания.
    @Test
    @Story("Тест-кейс №52")
    @Description("Добавление новости в режиме редактирования без Описания")
    public void addingNewsWithoutDescription() throws InterruptedException {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickButtonSaveNews();
        Thread.sleep(1000);
        waitFor(1);
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    //  Тест-кейс №53 - Добавление новости в режиме редактирования без заполения полей.
    @Test
    @Story("Тест-кейс №53")
    @Description("Добавление новости в режиме редактирования без заполения полей")
    public void addingNewsWithoutFillingInFields() throws InterruptedException {
        NewsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonEditing();
        NewsSteps.clickButtonAddingNews();
        NewsSteps.clickButtonSaveNews();
        waitFor(1);
        onView(withText(R.string.empty_fields)) //Заполните пустые поля
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}

