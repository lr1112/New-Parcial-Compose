package edu.ucne.parcial_en_compose.ui.theme.prestamo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.room.util.TableInfo
import edu.ucne.parcial_en_compose.model.Prestamo


@Composable
fun Consulta(
    navHostController: NavHostController,
    viewModel: PrestamoViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listas de Prestamos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navHostController.navigate("NavegarRegistro") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ){

        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)){

            val lis = viewModel.listado.collectAsState(initial = emptyList()).value
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lis) { prestamos ->
                    RowP(prestamos)
                }
            }
        }
    }
}

@Composable
fun RowP(prest: Prestamo) {
    Column(modifier = Modifier.padding(8.dp )) {

        Text(text = "1-DEUDOR: ${prest.deudor}",  modifier = Modifier.border(BorderStroke(2.dp, color = Color.Black)).padding(15.dp).fillMaxWidth())
        Text(text = "2-CONCEPTO: ${prest.concepto}",modifier = Modifier.border(BorderStroke(2.dp, color = Color.Black)).padding(15.dp).fillMaxWidth())
        Text(text = "3-MONTO: ${prest.monto}",modifier = Modifier.border(BorderStroke(2.dp, color = Color.Black)).padding(15.dp).fillMaxWidth())

    }
    @Immutable
    data class BorderStroke(val width: Dp, val brush: Brush)
}