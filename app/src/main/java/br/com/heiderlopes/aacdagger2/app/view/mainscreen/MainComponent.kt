package br.com.heiderlopes.aacdagger2.app.view.mainscreen

import br.com.heiderlopes.aacdagger2.base.di.ActivityScope
import br.com.heiderlopes.aacdagger2.base.di.component.AppComponent
import br.com.heiderlopes.aacdagger2.base.di.module.ApiModule
import br.com.heiderlopes.aacdagger2.base.di.module.AppModule
import br.com.heiderlopes.aacdagger2.base.di.module.SpeciesRepositoryModule
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [AppModule::class, ApiModule::class, SpeciesRepositoryModule::class])
interface MainComponent {

    fun inject(homeActivity: MainActivity)

}