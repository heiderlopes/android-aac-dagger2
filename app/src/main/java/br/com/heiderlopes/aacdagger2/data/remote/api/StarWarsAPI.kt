package br.com.heiderlopes.aacdagger2.data.remote.api

import br.com.heiderlopes.aacdagger2.data.remote.model.SpeciesList
import retrofit2.Call
import retrofit2.http.GET

interface StarWarsAPI {
    @GET("species/")
    fun getSpecies(): Call<SpeciesList>
}
