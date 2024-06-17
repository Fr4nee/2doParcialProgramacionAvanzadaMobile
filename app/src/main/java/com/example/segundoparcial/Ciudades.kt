package com.example.segundoparcial
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.segundoparcial.ui.theme.SegundoParcialTheme
import ClimaPage

@Composable
fun Main(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()
    Scaffold(
        modifier = Modifier
    ) {
        MainNavHost(
            modifier = Modifier.padding(it),
            navHostController = navHostController,
        )
    }
}

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "ciudades"
    ) {
        composable("ciudades") {
            Ciudades(navHostController, modifier = modifier)
        }
        composable("clima") {
            ClimaPage(
                ciudad = "Pedro Pe"
            )
        }
    }
}

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
                navHostController.navigate("clima")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Buscar")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    SegundoParcialTheme {
        Main()
    }
}





