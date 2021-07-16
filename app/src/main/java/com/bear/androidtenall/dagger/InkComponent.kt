package com.bear.androidtenall.dagger

import dagger.Component
import javax.inject.Singleton

@Component(modules = [InkModule::class])
interface InkComponent {
    fun getInk(): Ink
}