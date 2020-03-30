package com.example.android.gymondoautomationtest.common

import android.os.IBinder
import android.view.View
import android.view.WindowManager
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf

//Custom matchers to be reused at Views Matching
class CustomMatchers {
    /**
     * Author: http://www.qaautomated.com/2016/01/how-to-test-toast-message-using-espresso.html
     */
    class ToastMatcher : TypeSafeMatcher<Root?>() {

        override fun describeTo(description: Description?) {
            description?.appendText("is toast")
        }

        override fun matchesSafely(item: Root?): Boolean {
            val type: Int? = item?.getWindowLayoutParams()?.get()?.type
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                val windowToken: IBinder = item.getDecorView().getWindowToken()
                val appToken: IBinder = item.getDecorView().getApplicationWindowToken()
                if (windowToken === appToken) { // means this window isn't contained by any other windows.
                    return true
                }
            }
            return false
        }
    }

    companion object {

        //To get the number of items in Recycler View
        fun getCountFromRecyclerView(@IdRes RecyclerViewId: Int): Int {
            var COUNT = 0
            var matcher =
                object : TypeSafeMatcher<View>() {
                    override fun matchesSafely(item: View): Boolean {
                        COUNT = (item as RecyclerView).adapter!!.itemCount
                        return true
                    }

                    override fun describeTo(description: Description) {}
                }
            onView(allOf(withId(RecyclerViewId), isDisplayed()))
                .check(matches(matcher))
            val result = COUNT
            COUNT = 0
            return result
        }

        //To get element at position in Recycler View matching a matcher
        fun atPosition(
            position: Int,
            itemMatcher: Matcher<View?>
        ): Matcher<View?>? {
            checkNotNull(itemMatcher)
            return object :
                BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
                override fun describeTo(description: Description) {
                    description.appendText("has item at position $position: ")
                    itemMatcher.describeTo(description)
                }

                override fun matchesSafely(view: RecyclerView): Boolean {
                    val viewHolder = view.findViewHolderForAdapterPosition(position)
                        ?: // has no item on such position
                        return false
                    return itemMatcher.matches(viewHolder.itemView)
                }
            }
        }


    }
}