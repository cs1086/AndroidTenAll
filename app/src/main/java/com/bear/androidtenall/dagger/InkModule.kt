package com.bear.androidtenall.dagger

import dagger.Module
import dagger.Provides
@Module
class InkModule {
    @Provides
    fun provideInk(water: Water): Ink {
        return MyInk(water)
    }

    @Provides
    fun provideWater(): Water {
        return MyWater()
    }
}