package com.example.android.gymondoautomationtest.tests

import com.example.android.gymondoautomationtest.MainActivity
import com.example.android.gymondoautomationtest.activity.objects.ListActivityObject
import com.example.android.gymondoautomationtest.activity.objects.MainActivityObject
import com.example.android.gymondoautomationtest.common.TestBase
import com.example.android.gymondoautomationtest.common.TestData
import org.junit.Before
import org.junit.Test

open class SearchTest : TestBase<MainActivity>(MainActivity::class.java) {
    @Before
    fun login() {
        MainActivityObject.login(TestData.EMAIL.VALUE, TestData.PASSWORD.VALUE)
    }

    @Test
    fun listScreenUITest() {
        ListActivityObject.verifyScreenUI(TestData.APP_TITLE.VALUE)
    }

    @Test
    fun searchWithValidExerciseTest() {
        ListActivityObject.typeSearchKeyword(TestData.VALID_EXERCISE_SEARCH_KEYWORD.VALUE)
        //TODO: to implement IdlingResource
        Thread.sleep(5000)
        ListActivityObject.pressSearchButton()
        Thread.sleep(5000)
        ListActivityObject.verifySearchResultsContainKeyword(TestData.VALID_EXERCISE_SEARCH_KEYWORD.VALUE)
    }

    @Test
    fun searchWithInvalidKeywordTest() {
        ListActivityObject.typeSearchKeyword(TestData.INVALID_EXERCISE_SEARCH_KEYWORD.VALUE)
        //TODO: to implement IdlingResource
        Thread.sleep(5000)
        ListActivityObject.pressSearchButton()
        ListActivityObject.verifyNoAvailableResults()

    }

    @Test
    fun searchWithRandomExerciseKeywordsTest() {
        ListActivityObject.typeSearchKeyword(TestData.RANDOM_EXERCISE_SEARCH_KEYWORD.VALUE)
        //TODO: to implement IdlingResource
        Thread.sleep(5000)
        ListActivityObject.pressSearchButton()
        Thread.sleep(5000)
        ListActivityObject.verifySearchResultsContainKeyword(TestData.RANDOM_EXERCISE_SEARCH_KEYWORD.VALUE)
    }

    @Test
    fun clearButtonTest() {
        ListActivityObject.typeSearchKeyword(TestData.INVALID_EXERCISE_SEARCH_KEYWORD.VALUE)
        //TODO: to implement IdlingResource
        Thread.sleep(5000)
        ListActivityObject.pressSearchButton()
        Thread.sleep(5000)
        ListActivityObject.verifyNoAvailableResults()
        ListActivityObject.pressClearButton()
        Thread.sleep(5000)
        ListActivityObject.verifyAvailableResults()
    }

    //TODO: Add offline tests


}