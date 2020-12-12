package com.example.rentalapplication.ui;

import android.content.Intent;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.is;

import com.example.rentalapplication.R;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;

public class LoginTest {
    @Rule
    public ActivityTestRule<Login> activityTestRule
            = new ActivityTestRule<>(Login.class);

    @Test
    public void successfulLogin() {
        onView(withId(R.id.textUsername))
                .perform(typeText("12"));
        closeSoftKeyboard();
        onView(withId(R.id.textPassword))
                .perform(typeText("12"));
        closeSoftKeyboard();

        onView(withId(R.id.buttonSearch)).perform(click());

        activityTestRule.launchActivity(new Intent());
        intended(hasComponent(RentOrPost.class.getName()));
    }

    @Test
    public void failedLogin() {
        onView(withId(R.id.buttonSearch)).perform(click());

        activityTestRule.launchActivity(new Intent());
        intended(hasComponent(Login.class.getName()));
    }
}
