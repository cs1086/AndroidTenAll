package com.bear.androidtenall.test

import junit.framework.TestCase
import org.junit.Assert

class AuthManager2Test : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}

    fun testLogin() {
        val loginService=LoginService()
        val authManager2=AuthManager2(loginService)
        val result =authManager2.login("cs1086","123456789")
        Assert.assertEquals(true,result)
    }
}