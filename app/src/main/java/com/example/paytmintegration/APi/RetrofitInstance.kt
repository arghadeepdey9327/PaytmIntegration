package com.example.paytmintegration.APi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val api:String="https://securegw-stage.paytm.in"
    fun getRetrofitInstance(): Retrofit {
       return Retrofit.Builder()
           .baseUrl(api)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }
}