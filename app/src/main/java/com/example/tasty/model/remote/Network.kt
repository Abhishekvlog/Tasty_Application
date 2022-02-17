package com.example.tasty.model.remote

import android.animation.AnimatorSet
import com.example.tasty.model.remote.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class Network {
    companion object {
        val base_url = "https://tasty.p.rapidapi.com/"

        var okHttpClient: OkHttpClient = OkHttpClient.Builder()          //  to increase connection timeout
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()


        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                // .client(OkHttpClient.Builder().build())
                .client(okHttpClient).build()
        }

        fun getRetrofitForSearch(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/")
                .addConverterFactory(GsonConverterFactory.create())
                // .client(OkHttpClient.Builder().build())
                .client(okHttpClient).build()
        }

        val api: ApiService = getRetrofit().create(ApiService::class.java)
        val apiForSearch: ApiService = getRetrofitForSearch().create(ApiService::class.java)
    }
}


//OkHttpClient client = new OkHttpClient();
//client.setConnectTimeout(30, TimeUnit.SECONDS); // connect timeout
//client.setReadTimeout(30, TimeUnit.SECONDS);