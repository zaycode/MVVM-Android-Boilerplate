package com.zaycode.mvvm

import android.app.Application
import com.zaycode.mvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext (this@Application)
            listOf(
                viewModelModule,
                useCaseModule,
                repositoryModule,
                dataSourceModule,
                networkModule

            )
        }

    }
}
