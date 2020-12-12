package com.example.rentalapplication.ui;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import com.example.rentalapplication.R;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


public class LoginTest {

    @Rule
    public IntentsTestRule<Login> intentsTestRule
            = new IntentsTestRule<>(Login.class);

    @Test
    public void loginButton() {

        onView(withId(R.id.textUsername))
                .perform(typeText("12"));
        closeSoftKeyboard();
        onView(withId(R.id.textPassword))
                .perform(typeText("12"));
        closeSoftKeyboard();

        onView(withId(R.id.buttonLogin)).perform(click());
        intended(toPackage());
    }
}