package com.bear.androidtenall.test

import junit.framework.TestCase
import org.junit.Assert
import org.mockito.Mockito

class AuthManager2Test2 : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}

    fun testLogin() {

        val loginService = Mockito.mock(IloginService::class.java)
        val authManager = AuthManager2(loginService)
        Mockito.`when`(loginService.login("123456", "123456578"))
            .thenReturn(true)
        val result = authManager.login("123456", "123456578")
        Mockito.verify(loginService).login(Mockito.anyString(), Mockito.anyString())
        Assert.assertEquals(true, result)
    }
}