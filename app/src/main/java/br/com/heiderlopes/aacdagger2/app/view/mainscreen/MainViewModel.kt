package br.com.heiderlopes.aacdagger2.app.view.mainscreen

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.heiderlopes.aacdagger2.data.remote.model.Species
import br.com.heiderlopes.aacdagger2.data.remote.repository.SpeciesRepository
import javax.inject.Inject


class MainViewModel : ViewModel() {

    @Inject
    lateinit var repository: SpeciesRepository

    var isLoading = MutableLiveData<Boolean>()

    var apiError = MutableLiveData<Throwable>()

    var speciesResponse = MutableLiveData<List<Species>>()

    fun getSpecies() {
        isLoading.value = true
        repository.getSpecies(
                {
                    speciesResponse.value = it
                    isLoading.value = false
                },

                {
                    apiError.value = it
                    isLoading.value = false
                })
    }

    fun getSpeciesAt(position: Int): Species? {
        if (position < getSpeciesSize()) {
            return speciesResponse.value?.get(position)
        } else {
            return null
        }
    }

    fun getSpeciesSize(): Int {
        speciesResponse.value?.let {
            return it.size
        }
        return 0
    }
}