package com.bear.androidtenall.test

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthManager2Test3 : TestCase() {
    @Mock
    lateinit var loginService: LoginService
    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}
    @Test
    fun testLogin() {
        val authManager = AuthManager2(loginService)
        Mockito.`when`(loginService.login("123456", "123456578"))
            .thenReturn(true)
        val result = authManager.login("123456", "123456578")
        Mockito.verify(loginService).login(Mockito.anyString(), Mockito.anyString())
        Assert.assertEquals(true, result)
    }
}