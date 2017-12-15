package br.com.heiderlopes.aacdagger2.base.di.module

import android.app.Application
import android.content.Context
import br.com.heiderlopes.aacdagger2.base.helper.SpHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun providesGson() = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    @Provides
    @Singleton
    fun providesApplication() = application

    @Provides
    @Singleton
    fun providesResources() = application.resources

    @Provides
    @Singleton
    fun providesSharedPref(gson: Gson) = SpHelper(application.getSharedPreferences("Sp", Context.MODE_PRIVATE), gson)


}