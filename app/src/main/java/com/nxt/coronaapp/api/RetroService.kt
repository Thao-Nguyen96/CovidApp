package com.nxt.coronaapp.api

import com.nxt.coronaapp.Model
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetroService {

    @GET("summary")
    suspend fun getDataFromApi(): Response<Model>
}