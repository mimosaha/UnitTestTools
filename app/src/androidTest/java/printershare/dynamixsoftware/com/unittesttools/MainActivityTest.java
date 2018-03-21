package printershare.dynamixsoftware.com.unittesttools;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by USER03 on 3/20/2018.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private String STRING_TO_BE_TYPED = "BANGLA";

    /**
     * Set an activity which is the first one in whole app lifecycle
     */

    @Rule
    public ActivityTestRule<RegistrationActivity> mainActivityTest = new ActivityTestRule<>(RegistrationActivity.class);

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void setNameAndGo() {
        // Type text and then press the button.
        onView(withId(R.id.name_edit)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());

        // This view is in a different Activity, no need to tell Espresso.

        // Match the text in an item below the fold and check that it's displayed.
//        String itemElementText = mainActivityTest.getActivity().getResources().getString(
//                R.string.item_element_text) + String.valueOf(ITEM_BELOW_THE_FOLD);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(ViewMatchers.withId(R.id.recyclerview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(20, click()));

        onView(withId(R.id.selected_language)).check(matches(isDisplayed()));

        onView(withId(R.id.selected_language)).check(matches(withText(STRING_TO_BE_TYPED)));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}