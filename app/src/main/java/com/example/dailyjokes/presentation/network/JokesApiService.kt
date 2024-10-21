package com.example.dailyjokes.presentation.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://official-joke-api.appspot.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface JokesApiService {
    @GET("random_joke")
    fun getJokes(): String
}

object JokesApi {
    val retrofitService : JokesApiService by lazy {
        retrofit.create(JokesApiService::class.java)
    }
}

suspend fun getJokes(): String {
    return JokesApi.retrofitService.getJokes()
}