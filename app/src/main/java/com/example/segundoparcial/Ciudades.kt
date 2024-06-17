package com.example.segundoparcial
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
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



@Composable
fun Ciudades(navHostController: NavHostController) {
    var ciudadIngresada by remember { mutableStateOf("") }
    var acceso1 by remember { mutableStateOf("Buenos Aires") }
    var acceso2 by remember { mutableStateOf("Paris") }
    var acceso3 by remember { mutableStateOf("Miami") }
    var acceso4 by remember { mutableStateOf("Barcelona") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
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
        Botones(navHostController, acceso1, acceso2, acceso3, acceso4)


        OutlinedTextField(
            value = ciudadIngresada,
            onValueChange = { ciudadIngresada = it },
            label = { Text("Ingrese la ciudad") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Button(
            onClick = {
                navHostController.navigate("clima/$ciudadIngresada")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Buscar")
        }
    }
}



@Composable
fun Botones(navHostController: NavHostController, acceso1: String, acceso2: String, acceso3: String, acceso4: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    navHostController.navigate("clima/$acceso1")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text(acceso1)
            }
            Button(
                onClick = {
                    navHostController.navigate("clima/$acceso2")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                )
            ) {
                Text(acceso2)
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
                    navHostController.navigate("clima/$acceso3")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(acceso3)
            }
            Button(
                onClick = {
                    navHostController.navigate("clima/$acceso4")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text(acceso4)
            }
        }
    }
}
