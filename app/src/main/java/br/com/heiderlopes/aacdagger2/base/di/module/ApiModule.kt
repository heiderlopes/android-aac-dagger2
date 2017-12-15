package br.com.heiderlopes.aacdagger2.base.di.module

import br.com.heiderlopes.aacdagger2.data.remote.api.StarWarsAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule(val baseUrl: String) {
    @Provides
    @Singleton
    fun provideApiService(): StarWarsAPI {
        val gson = GsonBuilder().create()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(StarWarsAPI::class.java)
    }
}