package br.com.heiderlopes.aacdagger2.base.di.component

import android.app.Application
import android.content.res.Resources
import br.com.heiderlopes.aacdagger2.base.di.ActivityScope
import br.com.heiderlopes.aacdagger2.base.di.module.AppModule
import br.com.heiderlopes.aacdagger2.base.di.module.NetModule
import br.com.heiderlopes.aacdagger2.base.helper.SpHelper
import com.google.gson.Gson
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (NetModule::class)])
interface AppComponent {
    fun application(): Application
    fun gson(): Gson
    fun resources(): Resources
    fun retrofit(): Retrofit
    fun cache(): Cache
    fun client(): OkHttpClient
    fun loggingInterceptor(): HttpLoggingInterceptor
    fun spHelper(): SpHelper
}