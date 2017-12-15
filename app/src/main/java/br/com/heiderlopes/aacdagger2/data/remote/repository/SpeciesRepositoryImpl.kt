package br.com.heiderlopes.aacdagger2.data.remote.repository

import br.com.heiderlopes.aacdagger2.data.remote.api.StarWarsAPI
import br.com.heiderlopes.aacdagger2.data.remote.model.Species
import br.com.heiderlopes.aacdagger2.data.remote.model.SpeciesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpeciesRepositoryImpl(val apiService: StarWarsAPI) : SpeciesRepository {

    override fun getSpecies(successHandler: (List<Species>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        apiService.getSpecies().enqueue(object : Callback<SpeciesList> {
            override fun onResponse(call: Call<SpeciesList>?, response: Response<SpeciesList>?) {
                response?.body()?.let {
                    successHandler(it.speciesList)
                }
            }

            override fun onFailure(call: Call<SpeciesList>?, t: Throwable?) {
                failureHandler(t)
            }
        })
    }
}

