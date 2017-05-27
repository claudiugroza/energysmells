package com.claug.energycodesmells;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.content.Context;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import claug.batterygauge.logging.BatteryGauge;
import claug.batterygauge.logging.BatteryGaugeConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExperimentScenario {

  @Rule
  public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(
      MainActivity.class);

  @Before
  public void setup() {
    Context context = mActivityTestRule.getActivity();
    BatteryGaugeConfig config = new BatteryGaugeConfig(context);
    BatteryGauge.init(config);
  }

  @Test
  @LargeTest
  public void experimentScenario() {

    for (int i = 0; i < ExperimentConstants.SCENARIO_REPETITIONS; i++) {
      ViewInteraction bottomNavigationItemView = onView(
          allOf(withId(R.id.navigation_hmu), withContentDescription("HMU"), isDisplayed()));
      bottomNavigationItemView.perform(click());

      BatteryGauge.log();

      ViewInteraction appCompatButton = onView(
          allOf(withId(R.id.bRunTest), withText("Run test"), isDisplayed()));
      appCompatButton.perform(click());

      BatteryGauge.log();

      ViewInteraction bottomNavigationItemView2 = onView(
          allOf(withId(R.id.navigation_igsu), withContentDescription("IGSU"), isDisplayed()));
      bottomNavigationItemView2.perform(click());

      BatteryGauge.log();

      ViewInteraction appCompatButton2 = onView(
          allOf(withId(R.id.bRunTest), withText("Run test"), isDisplayed()));
      appCompatButton2.perform(click());

      BatteryGauge.log();

      ViewInteraction bottomNavigationItemView3 = onView(
          allOf(withId(R.id.navigation_mim), withContentDescription("MIM"), isDisplayed()));
      bottomNavigationItemView3.perform(click());

      BatteryGauge.log();

      ViewInteraction appCompatButton3 = onView(
          allOf(withId(R.id.bRunTest), withText("Run test"), isDisplayed()));
      appCompatButton3.perform(click());

      BatteryGauge.log();
    }

  }

  @After
  public void release() {
    BatteryGauge.destroy();
  }

}
