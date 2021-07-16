package com.bear.androidtenall.dagger

import com.bear.androidtenall.Dagger2Activity
import dagger.Component
import javax.inject.Singleton

//@PrinterModule.MyScope
@Singleton
@Component(dependencies = [InkComponent::class],modules = [PrinterModule::class])
interface PrinterComponent {
    fun inject(activity: Dagger2Activity)
}