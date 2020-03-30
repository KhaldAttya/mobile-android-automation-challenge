package com.example.android.gymondoautomationtest.common

import android.app.Activity
import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.base.DefaultFailureHandler
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.squareup.spoon.Spoon
import org.hamcrest.Matcher
import org.junit.runner.Description
import org.junit.runners.model.Statement

// Custom Test Rule to take a screenshot on failure using spoon
class TakeScreenshotOnFailureTestRule<T : Activity?>(activityClass: Class<T>?) :
    ActivityTestRule<T>(activityClass) {

    override fun beforeActivityLaunched() {

    }

    override fun apply(base: Statement, description: Description): Statement {
        val testClassName = description.className
        val testMethodName = description.methodName
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        Espresso.setFailureHandler { throwable: Throwable?, matcher: Matcher<View?>? ->
            Spoon.screenshot(activity, "failure", testClassName, testMethodName)
            DefaultFailureHandler(context).handle(throwable, matcher)
        }
        return super.apply(base, description)
    }


}