package com.example.segundoparcial
data class RespuestaClima(
    val main: Main,
    val name: String,
    val weather: List<Weather>
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val humidity: Int
)

data class Weather(
    val description: String,
    val icon: String
)
