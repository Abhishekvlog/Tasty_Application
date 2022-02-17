package com.example.tasty.model.remote.searchResponse


import com.google.gson.annotations.SerializedName

data class SearchResponseModel(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val resultSearchModels: List<ResultSearchModel>,
    @SerializedName("totalResults")
    val totalResults: Int
)