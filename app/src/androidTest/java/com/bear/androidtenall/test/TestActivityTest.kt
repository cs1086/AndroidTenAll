package com.bear.androidtenall.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.bear.androidtenall.R
import org.hamcrest.Matchers.not

@RunWith(AndroidJUnit4::class)
class TestActivityTest : TestCase() {
    @Rule
    @JvmField
    val activityRule=ActivityTestRule(TestActivity::class.java)
    @Test
    fun checkSubmitState(){
        onView(withId(R.id.button2)).check(matches(not(isEnabled())))//取得button並檢查判斷是否符合不能點選
        onView(withId(R.id.textView2)).perform(typeText("jason"))//將edittext的text改成json
        onView(withId(R.id.button2)).check(matches(isEnabled()))//檢查按鈕應該要可以點選
        onView(withId(R.id.textView2)).perform(clearText())//清空edittext
        onView(withId(R.id.button2)).check(matches(not(isEnabled())))//檢查按鈕不能點選
    }
    public override fun setUp() {
        super.setUp()
    }
    public override fun tearDown() {}
}