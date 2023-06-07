package com.example.surepass.domain.retrofit

import com.example.surepass.data.AdoptAPetResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("entries")
    suspend fun getPetList(): Response<AdoptAPetResponse>
}