package com.example.a20200430_brianferguson_nycschools;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import com.example.a20200430_brianferguson_nycschools.view.MainActivity;
import com.example.a20200430_brianferguson_nycschools.view.ScoresActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void shouldLaunchScoresActivity() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.school_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        intended(hasComponent(ScoresActivity.class.getName()));
    }

    @Test
    public void shouldNotLaunchScoresActivity() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.school_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withText("Could not retrieve data for school")).inRoot(withDecorView(not(is(intentsTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}
