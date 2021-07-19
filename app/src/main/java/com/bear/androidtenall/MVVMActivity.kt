package com.bear.androidtenall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.*
import com.bear.androidtenall.mvvm.NameViewModel

class MVVMActivity : AppCompatActivity() {
    private lateinit var modle: NameViewModel
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmactivity)
        textView=findViewById(R.id.textView)
        modle=ViewModelProvider(this,SavedStateViewModelFactory(application,this)).get(NameViewModel::class.java)
        val nameObserver=Observer<String>{
            newName->textView.text=newName 
        }
        modle.currentName.observe(this,nameObserver)
        modle.trange()
    }
}