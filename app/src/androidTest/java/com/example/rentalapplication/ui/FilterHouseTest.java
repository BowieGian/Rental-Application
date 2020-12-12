package com.example.rentalapplication.ui;

import android.content.Intent;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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

public class FilterHouseTest {
    @Rule
    public ActivityTestRule<FilterHouse> activityTestRule
            = new ActivityTestRule<>(FilterHouse.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @Test
    public void successfulFilter() {
        onView(withId(R.id.location))
                .perform(typeText("Vancouver"));

        onView(withId(R.id.tvDate)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2020, 12, 11));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.tvDate2)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2020, 12, 12));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.buttonSearch)).perform(click());

        activityTestRule.launchActivity(new Intent());
        intended(hasComponent(RentalList.class.getName()));
    }

    @Test
    public void fullSuccessfulFilter() {
        onView(withId(R.id.location))
                .perform(typeText("Vancouver"));

        onView(withId(R.id.tvDate)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2020, 12, 11));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.tvDate2)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2020, 12, 12));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.spinnerGuests))
                .perform(click());
        onData(is("House")).perform(click());

        onView(withId(R.id.buttonSearch)).perform(click());

        activityTestRule.launchActivity(new Intent());
        intended(hasComponent(RentalList.class.getName()));
    }

    @After
    public void tearDown() {
        Intents.release();
    }
}
