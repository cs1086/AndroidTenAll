package com.bear.androidtenall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bear.androidtenall.dagger.*
import javax.inject.Inject

class Dagger2Activity : AppCompatActivity() {
    @Inject
    lateinit var printer: Printer;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2)
        val inkComponent = DaggerInkComponent.create()
        DaggerPrinterComponent .builder().inkComponent(inkComponent).build().inject(this)
//        val water = MyWater()
//        val wood = MyWood()
//        val ink = MyInk(water)
//        val paper = MyPaper(wood)
//        val printer = MyPrinter( paper,ink)
        printer.print()
    }
}