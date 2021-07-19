package com.bear.androidtenall.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel: ViewModel() {

    val currentName: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    fun trange(){
        currentName.value="測試"
    }
}