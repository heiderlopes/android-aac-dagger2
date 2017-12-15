package br.com.heiderlopes.aacdagger2.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.heiderlopes.aacdagger2.base.di.ComponentInjector.Companion.appComponent
import br.com.heiderlopes.aacdagger2.base.di.component.AppComponent

abstract class BaseActivity : AppCompatActivity() {

    //protected abstract fun onActivityInject()

    fun getAppcomponent(): AppComponent = appComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //onActivityInject()
    }
}