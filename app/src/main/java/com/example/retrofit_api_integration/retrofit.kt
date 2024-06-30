package com.example.retrofit_api_integration

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://meme-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val apiservice by lazy {
        retrofit.create(apiIntegration::class.java)
    }
}