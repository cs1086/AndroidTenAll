package com.bear.androidtenall.test

class AuthManager2(private val iloginService: IloginService) {
    fun login(account:String,password:String):Boolean{
        return iloginService.login(account,password)
    }
}