package com.example.khajanpandey.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

/**
 * Created by khajanpandey on 10/5/18.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    MainActivity mainActivity;
    @Before
    public void setUp() throws Exception {
        System.out.println("setup called");
        mainActivity = mainActivityActivityTestRule.getActivity();
    }



    @Test
    public void testForActivityLaunch(){
        Activity activity = getInstrumentation().waitForMonitorWithTimeout(monitor,3000);
        assertNotNull(activity);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown called");
        mainActivity = null;
    }

}