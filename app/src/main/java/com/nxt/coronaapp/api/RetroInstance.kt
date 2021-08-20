package com.nxt.coronaapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://api.covid19api.com/summary

class RetroInstance {

    companion object {
        var BASE_URL = "https://api.covid19api.com/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}