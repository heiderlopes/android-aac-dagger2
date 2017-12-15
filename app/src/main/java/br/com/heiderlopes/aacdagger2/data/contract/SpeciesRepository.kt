package br.com.heiderlopes.aacdagger2.data.remote.repository

import br.com.heiderlopes.aacdagger2.data.remote.model.Species

interface SpeciesRepository {

    fun getSpecies(successHandler: (List<Species>?) -> Unit, failureHandler: (Throwable?) -> Unit)

}