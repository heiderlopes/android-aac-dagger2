package br.com.heiderlopes.aacdagger2.base.di.module

import br.com.heiderlopes.aacdagger2.data.remote.api.StarWarsAPI
import br.com.heiderlopes.aacdagger2.data.remote.repository.SpeciesRepository
import br.com.heiderlopes.aacdagger2.data.remote.repository.SpeciesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SpeciesRepositoryModule {

    @Provides
    @Singleton
    fun provideSpeciesRepository(apiService: StarWarsAPI): SpeciesRepository = SpeciesRepositoryImpl(apiService)
}