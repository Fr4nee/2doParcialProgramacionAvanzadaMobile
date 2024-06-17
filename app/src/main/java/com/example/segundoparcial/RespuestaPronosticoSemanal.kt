package com.example.segundoparcial

data class RespuestaPronosticoSemanal(
    val city: City,
    val list: List<Forecast>
)

data class City(
    val name: String,
    val country: String
)

data class Forecast(
    val dt: Long,
    val temp: Temp,
    val weather: List<Weather>
)

data class Temp(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

data class Clima(
    val description: String,
    val icon: String
)
