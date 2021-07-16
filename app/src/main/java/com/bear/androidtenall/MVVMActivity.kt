package com.bear.androidtenall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData

class MVVMActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmactivity)
        val currentName:MutableLiveData<String> by lazy{
            MutableLiveData<String>()
        }
    }
}