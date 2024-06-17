package com.example.segundoparcial
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Ciudades(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val ciudadIngresada = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "App Clima",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = ciudadIngresada.value,
            onValueChange = { ciudadIngresada.value = it },
            label = { Text("Ingrese la ciudad") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Button(
            onClick = {
                navHostController.navigate("clima/${ciudadIngresada.value}")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Buscar")
        }
    }
}
