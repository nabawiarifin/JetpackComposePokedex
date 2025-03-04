package com.plcoding.jetpackcomposepokedex.data.remote.responses


import com.google.gson.annotations.SerializedName

data class PokemonLists(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)