package com.example.a20200430_brianferguson_nycschools;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.example.a20200430_brianferguson_nycschools.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void activityLaunched() {
        onView(withId(R.id.school_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
    }
}
