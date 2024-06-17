package com.example.segundoparcial
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.items
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Ciudades(navHostController: NavHostController, apiClima: ServicioAPIClima) {
    var ciudadIngresada by remember { mutableStateOf("") }
    var ciudadesSugeridas by remember { mutableStateOf(listOf<Ciudad>()) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "App Clima",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Accesos Rápidos",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Botones(navHostController, "Buenos Aires", "Paris", "Miami", "Barcelona")
        OutlinedTextField(
            value = ciudadIngresada,
            onValueChange = {
                ciudadIngresada = it
                coroutineScope.launch {
                    delay(500)
                    if (ciudadIngresada.isNotEmpty()) {
                        try {
                            ciudadesSugeridas =
                                apiClima.getCiudades(ciudadIngresada, 5, "5860473db9c726fdcf35b5c47e0aaa79").toList()
                        } catch (e: Exception) {
                            ciudadesSugeridas = emptyList()
                        }
                    }
                }
            },
            label = { Text("Ingrese la ciudad") },
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn {
            items(ciudadesSugeridas) { ciudad ->
                Text(
                    text = ciudad.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { navHostController.navigate("clima/${ciudad.nombre}") }
                )
            }
        }
        Button(
            onClick = { navHostController.navigate("clima/$ciudadIngresada") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Buscar")
        }
    }
}

@Composable
fun Botones(navHostController: NavHostController, ciudad1: String, ciudad2: String, ciudad3: String, ciudad4: String) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    navHostController.navigate("clima/$ciudad1")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text(ciudad1)
            }
            Button(
                onClick = {
                    navHostController.navigate("clima/$ciudad2")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                )
            ) {
                Text(ciudad2)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    navHostController.navigate("clima/$ciudad3")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(ciudad3)
            }
            Button(
                onClick = {
                    navHostController.navigate("clima/$ciudad4")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text(ciudad4)
            }
        }
    }
}
