package com.bear.androidtenall.test

import junit.framework.TestCase
import org.junit.Assert

class AuthManagerTest : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}

    fun testValidLogin() {
        val authManager=AuthManager()
        val result=authManager.validLogin("cs1086","1234567890")
        Assert.assertEquals(true,result)
    }
}