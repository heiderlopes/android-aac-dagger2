package br.com.heiderlopes.aacdagger2.base

import android.app.Application
import br.com.heiderlopes.aacdagger2.base.di.ComponentInjector
import br.com.heiderlopes.aacdagger2.base.di.component.AppComponent
import br.com.heiderlopes.aacdagger2.base.di.component.DaggerAppComponent
import br.com.heiderlopes.aacdagger2.base.di.module.AppModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentInjector.init(this)
    }
}