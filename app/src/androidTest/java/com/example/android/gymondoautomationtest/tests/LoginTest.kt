package com.example.android.gymondoautomationtest.tests

import com.example.android.gymondoautomationtest.MainActivity
import com.example.android.gymondoautomationtest.activity.objects.ListActivityObject
import com.example.android.gymondoautomationtest.activity.objects.MainActivityObject
import com.example.android.gymondoautomationtest.common.TestBase
import com.example.android.gymondoautomationtest.common.TestData
import org.junit.Test

open class LoginTest : TestBase<MainActivity>(MainActivity::class.java) {

    @Test
    fun loginScreenLoadedTest() {
        MainActivityObject.verifyLoginScreenLoaded()
    }

    @Test
    fun loginScreenUITest() {
        MainActivityObject.verifyTitle(TestData.APP_TITLE.VALUE)
        MainActivityObject.verifyEmailPlaceholder(TestData.EMAIL_PLACEHOLDER.VALUE)
        MainActivityObject.verifyPasswordPlaceholder(TestData.PASSWORD_PLACEHOLDER.VALUE)
        MainActivityObject.verifyLoginButtonText(TestData.LOGIN_BUTTON_TEXT.VALUE)
    }

    @Test
    fun loginWithValidCredentialsTest() {
        MainActivityObject.login(TestData.EMAIL.VALUE, TestData.PASSWORD.VALUE)
        ListActivityObject.verifyScreenLoaded()
    }

    @Test
    fun loginWithInvalidCredentialsTest() {
        MainActivityObject.login(TestData.EMAIL.VALUE + "typo", TestData.PASSWORD.VALUE + "typo")
        MainActivityObject.verifyToastMsg(TestData.INCORRECT_CREDENTIALS_TOAST.VALUE)
    }

    @Test
    fun attemptLoginWithEmailOnlyTest() {
        MainActivityObject.typeEmail(TestData.EMAIL.VALUE)
        MainActivityObject.pressLoginButton()
        MainActivityObject.verifyToastMsg(TestData.INCORRECT_CREDENTIALS_TOAST.VALUE)
    }

    @Test
    fun attemptLoginWithPasswordOnlyTest() {
        MainActivityObject.typePassword(TestData.PASSWORD.VALUE)
        MainActivityObject.pressLoginButton()
        MainActivityObject.verifyToastMsg(TestData.INCORRECT_CREDENTIALS_TOAST.VALUE)
    }


}