package com.example.ejournal.data.remote

import com.example.ejournal.data.models.Teachers
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("add/mugalim/")
    suspend fun getTeachers(): Response<Teachers>
}