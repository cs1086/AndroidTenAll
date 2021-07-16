package com.bear.androidtenall.dagger

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton

@Module
class PrinterModule {
    @Scope
    annotation class MyScope

    @Qualifier
    annotation class DoubleA

    @Qualifier
    annotation class NormalPaper

    //@MyScope
    @Singleton
    @Provides
    fun providePrinter(@DoubleA paper: Paper, ink: Ink): Printer {
        return MyPrinter(paper, ink)
    }

    @DoubleA
    @Provides
    fun providePaper(wood: Wood): Paper {
        return MyPaper(wood)
    }

    @Named("doubleA")
    @Provides
    fun provideDoubleAPaper(wood: Wood): Paper {
        return DoubleAPaper(wood)
    }

    @Provides
    fun provideWood(): Wood {
        return MyWood()
    }


}