package com.example.android.gymondoautomationtest.activity.objects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.android.gymondoautomationtest.R
import com.example.android.gymondoautomationtest.common.CustomMatchers
import com.example.android.gymondoautomationtest.common.CustomMatchers.Companion.atPosition
import junit.framework.Assert.fail
import org.junit.Assert

// List Activity object contain reusable methods to be used at tests

class ListActivityObject {
    companion object {
        fun verifyScreenLoaded() {
            onView(withId(R.id.btnClear))
                .check(matches(isDisplayed()))
        }

        fun verifyScreenUI(title: String) {
            onView(withId(R.id.btnClear))
                .check(matches(isDisplayed()))
            onView(withId(R.id.editTxtSearch))
                .check(matches(isDisplayed()))
            onView(withId(R.id.btnSearch))
                .check(matches(isDisplayed()))
            onView(withText(title))
                .check(matches(isDisplayed()))
        }

        fun typeSearchKeyword(keyword: String) {
            onView(withId(R.id.editTxtSearch))
                .perform(replaceText(keyword), closeSoftKeyboard())
        }

        fun pressClearButton() {
            onView(withId(R.id.btnClear)).perform(click())
        }

        fun pressSearchButton() {
            onView(withId(R.id.btnSearch)).perform(click())
        }

        fun verifySearchResultsContainKeyword(keyword: String) {
            val count = CustomMatchers.getCountFromRecyclerView(R.id.recycler_view)
            if (count > 0) {
                for (x in 0..count - 1) {
                    onView(withId(R.id.recycler_view))
                        .check(matches(atPosition(x, withSubstring(keyword))));
                }
            } else fail("View is empty")
        }

        fun verifyNoAvailableResults() {
            Assert.assertEquals(0, CustomMatchers.getCountFromRecyclerView(R.id.recycler_view))

        }

        fun verifyAvailableResults() {
            Assert.assertTrue(CustomMatchers.getCountFromRecyclerView(R.id.recycler_view) > 0)

        }
    }


}