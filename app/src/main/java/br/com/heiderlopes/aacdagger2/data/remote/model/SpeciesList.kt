package br.com.heiderlopes.aacdagger2.data.remote.model

import com.google.gson.annotations.SerializedName

data class SpeciesList(@SerializedName("results") val speciesList: List<Species>, val next: String?)