package br.com.heiderlopes.aacdagger2.app.view.mainscreen

import br.com.heiderlopes.aacdagger2.base.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ActivityScope
    internal fun hello() = "Olha nóis aqui funcionando"

    @Provides
    @ActivityScope
    fun provideMainViewModel(): MainViewModel = MainViewModel()

}