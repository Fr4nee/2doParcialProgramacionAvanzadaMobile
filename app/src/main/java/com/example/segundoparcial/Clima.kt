package com.example.segundoparcial
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.segundoparcial.ui.theme.SegundoParcialTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun Clima(ciudad: String) {
    val apiKey = "5860473db9c726fdcf35b5c47e0aaa79"

    var res by remember { mutableStateOf<RespuestaClima?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(ciudad) {
        coroutineScope.launch {
            try {
                res = RetrofitClient.instance.getCurrentWeather(ciudad, apiKey)
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
                text = "Temperatura: ${it.main.temp} °C",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Descripción: ${it.weather.firstOrNull()?.description ?: "N/A"}",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
        } ?: Text(
            text = "Cargando...",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPagePreview() {
    SegundoParcialTheme {
        Clima("")
    }
}
