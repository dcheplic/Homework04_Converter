package com.homework.cheplic.homework04;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UserInterfaceTest {

    @Rule
    public final ActivityTestRule<SingleConversionActivity> single = new ActivityTestRule<>(SingleConversionActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.homework.cheplic.homework04", appContext.getPackageName());
    }

    @Test
    public void single_conv_activity_has_input() throws Exception {
        onView(withText("Input:")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void single_conv_activity_has_output() throws Exception {
        onView(withText("Output:")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void single_conv_input_field_changes() throws Exception {
        onView(withId(R.id.edit_input)).perform(typeText("1.0"));
        onView(withText("1.0")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void all_starts_multi_activity() throws Exception {
        onView(withId(R.id.all_button)).perform(click());
        onView(withId(R.id.recycler_view)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void spinner_changes() throws Exception {
        onView(withId(R.id.input_spinner)).perform(click());
        onData(hasToString("s")).perform(click());
        onView(withText("s")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void spinners_change_output() throws Exception {
        onView(withId(R.id.input_spinner)).perform(click());
        onData(hasToString("s")).perform(click());

        onView(withId(R.id.output_spinner)).perform(click());
        onData(hasToString("min")).perform(click());

        onView(withId(R.id.edit_input)).perform(typeText("30.0"));

        onView(withText("5.000e-01")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void spinners_change_multi_output() throws Exception {
        onView(withId(R.id.input_spinner)).perform(click());
        onData(hasToString("s")).perform(click());

        onView(withId(R.id.output_spinner)).perform(click());
        onData(hasToString("min")).perform(click());

        onView(withId(R.id.edit_input)).perform(typeText("30.0"));

        onView(withId(R.id.all_button)).perform(click());

        onView(withText("2.479e-05")).check(ViewAssertions.matches(isDisplayed()));
    }
}
