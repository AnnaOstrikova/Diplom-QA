package ru.netology.method;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

public class additionalActions {
    // Метод для получения текста из TextView внутри RecyclerView
    public static ViewAction getChildTextViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isDisplayed(); // Проверяем, что родительский элемент видим
            }

            @Override
            public String getDescription() {
                return "Получение текста из TextView с id: " + id;
            }

            @Override
            public void perform(UiController uiController, View view) {
                View child = view.findViewById(id);
                if (child != null && child instanceof TextView) {
                    ((TextView) child).getText().toString();
                }
            }
        };
    }

    // Метод для извлечения текста из ViewInteraction
    public static String getTextFromView(ViewInteraction viewInteraction) {
        final String[] text = {null};
        viewInteraction.perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isDisplayed(); // Проверяем, что элемент видим
            }

            @Override
            public String getDescription() {
                return "Извлечение текста из ViewInteraction";
            }

            @Override
            public void perform(UiController uiController, View view) {
                if (view instanceof TextView) {
                    text[0] = ((TextView) view).getText().toString();
                }
            }
        });
        return text[0];
    }
    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isDisplayed(); // Проверяем, что родительский элемент видим
            }

            @Override
            public String getDescription() {
                return "Клик по дочернему элементу с id: " + id;
            }

            @Override
            public void perform(UiController uiController, View view) {
                View child = view.findViewById(id);
                if (child != null) {
                    child.performClick();
                }
            }
        };
    }
}
