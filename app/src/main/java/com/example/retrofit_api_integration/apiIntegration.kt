package com.example.retrofit_api_integration

import okhttp3.Call
import retrofit2.http.GET

interface apiIntegration {

   @GET("/gimme")
   fun getdata(): retrofit2.Call<data_class>



}