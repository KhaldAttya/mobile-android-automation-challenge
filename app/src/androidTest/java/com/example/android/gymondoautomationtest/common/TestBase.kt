package com.example.android.gymondoautomationtest.common

import android.Manifest
import android.app.Activity
import androidx.test.rule.GrantPermissionRule
import org.junit.Before
import org.junit.Rule

// A Test Base class to initiate common rules and activity under test and enable screenshot on failure rule
open class TestBase<T : Activity?>(type: Class<T>?) {

    @get:Rule
    var activityTestRule: TakeScreenshotOnFailureTestRule<T> = TakeScreenshotOnFailureTestRule(type)
    private var activity: T? = null

    @Before
    fun setup() {
        activity = activityTestRule.activity
    }

    @get:Rule
    val mGrantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )


}