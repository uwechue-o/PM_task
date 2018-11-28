package com.uwechue.sample.androidtest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of app being tested
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.uwechue.sample.androidtest", appContext.getPackageName());
    }
}
