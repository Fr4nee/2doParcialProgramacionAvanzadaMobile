package com.example.segundoparcial

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ServicioAPIClima {
    @GET("data/2.5/weather")
    suspend fun getClimaActual(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "es"
    ): RespuestaClima

    @GET("data/2.5/forecast/daily")
    suspend fun getPronosticoSemanal(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
        @Query("cnt") count: Int = 7,
        @Query("lang") lang: String = "es"
    ): RespuestaPronosticoSemanal

    @GET("geo/1.0/direct")
    suspend fun getCiudades(
        @Query("q") city: String,
        @Query("limit") limit: Int = 100,
        @Query("appid") apiKey: String
    ): Array<Ciudad>
}
//https://api.openweathermap.org/geo/1.0/direct

object RetrofitClient {
    private const val root = "https://api.openweathermap.org/"

    val instance: ServicioAPIClima by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(root)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ServicioAPIClima::class.java)
    }
}
