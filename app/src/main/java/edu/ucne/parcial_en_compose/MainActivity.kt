package edu.ucne.parcial_en_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial_en_compose.ui.theme.Parcial_en_composeTheme
import edu.ucne.parcial_en_compose.ui.theme.prestamo.Consulta
import edu.ucne.parcial_en_compose.ui.theme.prestamo.RegistroPrestamo

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial_en_composeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        //Navegacion

        val navHostController = rememberNavController( )

        NavHost(navController = navHostController, startDestination = "NavegarConsulta") {

            composable(route = "NavegarConsulta"){
                Consulta(navHostController)
            }
            composable(route = "NavegarRegistro"){
                RegistroPrestamo(navHostController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Parcial_en_composeTheme {
        MyApp()
    }
}