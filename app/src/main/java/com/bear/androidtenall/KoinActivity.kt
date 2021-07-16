package com.bear.androidtenall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bear.androidtenall.dagger.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.dsl.module

class KoinActivity : AppCompatActivity() {
    //val printer: Printer by inject()
    val printer: Printer = get()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin)
        //val printer: Printer = get()
        printer.print()
    }
}