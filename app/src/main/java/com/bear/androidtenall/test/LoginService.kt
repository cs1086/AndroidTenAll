package com.bear.androidtenall.test

open class LoginService:IloginService {
    override fun login(account: String, password: String): Boolean {
        if(account.length<6){
            return false
        }else if(password.length<8) {
            return false
        }
        return true
    }
}