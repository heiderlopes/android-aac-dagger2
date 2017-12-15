package br.com.heiderlopes.aacdagger2.base.di

import android.app.Application
import android.content.Context
import br.com.heiderlopes.aacdagger2.base.App
import br.com.heiderlopes.aacdagger2.base.di.component.AppComponent
import br.com.heiderlopes.aacdagger2.base.di.component.DaggerAppComponent
import br.com.heiderlopes.aacdagger2.base.di.module.AppModule

class ComponentInjector {

    companion object {

        lateinit var appComponent: AppComponent

        fun init(application: Application) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(application))
                    .build()
        }
    }
}

