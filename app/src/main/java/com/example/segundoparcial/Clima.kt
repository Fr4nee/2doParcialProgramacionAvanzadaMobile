package com.example.segundoparcial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import com.example.segundoparcial.ui.theme.SegundoParcialTheme
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun Clima(navController: NavController, ciudad: String) {
    val apiKey = "5860473db9c726fdcf35b5c47e0aaa79"
    var res by remember { mutableStateOf<RespuestaClima?>(null) }
    var forecast by remember { mutableStateOf<RespuestaPronosticoSemanal?>(null) }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(ciudad) {
        coroutineScope.launch {
            try {
                res = RetrofitClient.instance.getClimaActual(ciudad, apiKey)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    LaunchedEffect(ciudad) {
        coroutineScope.launch {
            try {
                forecast = RetrofitClient.instance.getPronosticoSemanal(ciudad, apiKey)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Clima en $ciudad",
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        res?.let {
            Text(
                text = "Temperatura: ${it.main.temp}°C",
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Descripción: ${it.weather.firstOrNull()?.description ?: "N/A"}",
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Sensación Térmica: ${it.main.feels_like}°C",
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Min: ${it.main.temp_min}°C",
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Min: ${it.main.temp_max}°C",
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Humedad: ${it.main.humidity}%",
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp)
            )
        } ?: Text(
            text = "No se encontró información para la ciudad $ciudad, intente con otra.",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Previsión para $ciudad",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
             Text(
                text = "Actualmente la funcionalidad de previsión no está disponible ya que se requiere una subscripción paga.",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
            Button(
                onClick = { navController.navigateUp() },
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Volver")
            }
        }
        Button(
            onClick = { navController.navigateUp() },
            modifier = Modifier.padding(20.dp)
        ) {
            Text("Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPagePreview() {
    SegundoParcialTheme {
        ClimaPreview()
    }
}

@Composable
fun ClimaPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "",
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        Text(
            text = "",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        Text(
            text = "",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        Button(
            onClick = { },
            modifier = Modifier.padding(20.dp)
        ) {
            Text("Volver")
        }
    }
}
