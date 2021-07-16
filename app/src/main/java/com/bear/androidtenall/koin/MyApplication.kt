package com.bear.androidtenall.koin

import android.app.Application
import com.bear.androidtenall.dagger.*
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val myModule = module {
            factory { MyPrinter(get(), get()) as Printer }
            single { MyWood() as Wood }
            single{ MyPaper(get()) as Paper }
        }
        val myModule2 = module {
            single { MyWater() as Water }
            single { MyInk(get()) as Ink }
        }
        startKoin {
            modules(listOf(myModule,myModule2))
        }
    }
}