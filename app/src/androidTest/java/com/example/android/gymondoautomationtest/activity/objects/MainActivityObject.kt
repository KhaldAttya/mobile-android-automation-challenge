package com.example.android.gymondoautomationtest.activity.objects


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.android.gymondoautomationtest.R
import com.example.android.gymondoautomationtest.common.CustomMatchers

// Main Activity object contain reusable methods to be used at tests

class MainActivityObject {

    companion object {
        fun verifyLoginScreenLoaded() {
            onView(withId(R.id.loginButton)).check(matches(isDisplayed()))
        }

        fun login(email: String, password: String) {
            onView(withId(R.id.emailTextField))
                .perform(replaceText(email), closeSoftKeyboard())
            onView(withId(R.id.passwordTextField))
                .perform(replaceText(password), closeSoftKeyboard())
            onView(withId(R.id.loginButton))
                .perform(click())
        }

        fun typeEmail(email: String) {
            onView(withId(R.id.emailTextField))
                .perform(replaceText(email), closeSoftKeyboard())
        }

        fun typePassword(password: String) {
            onView(withId(R.id.passwordTextField))
                .perform(replaceText(password), closeSoftKeyboard())
        }

        fun pressLoginButton() {
            onView(withId(R.id.loginButton))
                .perform(click())
        }

        fun verifyToastMsg(expectedValue: String) {
            onView(withText(expectedValue)).inRoot(CustomMatchers.ToastMatcher())
                .check(matches(isDisplayed()))
        }

        fun verifyTitle(title: String) {
            onView(withText(title)).check(matches(isDisplayed()))
        }

        fun verifyEmailPlaceholder(placeholder: String) {
            onView(withId(R.id.emailTextField))
                .check(matches(withHint(placeholder)))
        }

        fun verifyPasswordPlaceholder(placeholder: String) {
            onView(withId(R.id.passwordTextField))
                .check(matches(withHint(placeholder)))
        }

        fun verifyLoginButtonText(text: String) {
            onView(withId(R.id.loginButton))
                .check(matches(withText(text)))
        }
    }
}

