package com.bear.androidtenall.dagger

import android.util.Log

class MyPrinter(val paper: Paper, val ink: Ink) : Printer{
    override fun print(){
        Log.d("###","####${paper.category}的紙印出來東西了");
    }
}