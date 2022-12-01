package com.example.squads.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

private const val BASE_URL =
    "https://localhost:25153/measurements/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface MeasurementApiService {
    @GET("/{userId}")
    suspend fun getAllMeasurementsFromUser(@Path("userId") userId: Int): Deferred<MeasurementDtoContainer>

    @GET("/{userId}/latest")
    suspend fun getLatestMeasurementsFromUser(@Path("userId") userId: Int): Deferred<MeasurementDto>
}

object MeasurementApi {
    val retrofitService : MeasurementApiService by lazy {
        retrofit.create(MeasurementApiService::class.java)
    }
}