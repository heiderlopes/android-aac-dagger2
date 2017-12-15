package br.com.heiderlopes.aacdagger2.data.remote.model

import com.google.gson.annotations.SerializedName

data class Species(val name : String, val classification : String, val language : String, @SerializedName("average_lifespan") val lifeSpan : String)