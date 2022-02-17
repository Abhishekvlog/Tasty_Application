package com.example.tasty.model.remote.api

import com.example.tasty.model.remote.api.response.ItemX
import com.example.tasty.model.remote.api.response.ResponseDTO
import com.example.tasty.model.remote.searchResponse.SearchResponseModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("feeds/list")
    suspend fun getData(
        @Query("size") size: Int = 20,
        @Query("timezone") timezone: String = "+0700",
        @Query("vegetarian") vegetarian: Boolean = false,
        @Query("from") from: Int = 0,
        @Header("x-rapidapi-host") host: String = "tasty.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "7469390914mshd43b5e3527cfab6p15ac36jsn07e559b13b9b"
    ): ResponseDTO

    @GET("recipes/detail")
    suspend fun getDetail(
        @Query("id") id: Int,
        @Header("x-rapidapi-host") host: String = "tasty.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "7469390914mshd43b5e3527cfab6p15ac36jsn07e559b13b9b"
    ): ItemX



    //https://api.spoonacular.com/recipes/complexSearch?apiKey=1b37e582323b49849577d6cb1ef567b9&query=pasta
    @GET("recipes/complexSearch")
    suspend fun getSearchview(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
    ): SearchResponseModel
}