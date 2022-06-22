package edu.ucne.parcial_en_compose.ui.theme.prestamo

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotAccessible
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroPrestamo(
    navHostController: NavHostController,
    viewModel: PrestamoViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    var validar = LocalContext.current
    val focusRequester = FocusRequester()
    val focusRequesterConcepto = FocusRequester()
    val focusRequesterMonto = FocusRequester()


    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Prestamo") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (viewModel.deudor.isNullOrEmpty()) {

                        Toast.makeText(validar, "El campo Deudor está vacio!", Toast.LENGTH_LONG).show()
                        focusRequester.requestFocus()
                        return@FloatingActionButton
                    }
                    if (viewModel.concepto.isNullOrEmpty()) {
                        Toast.makeText(validar, "El campo Concepto está vacio", Toast.LENGTH_LONG).show()
                        focusRequesterConcepto.requestFocus()
                        return@FloatingActionButton
                    }
                    if (viewModel.monto <= 0) {
                        Toast.makeText(validar, "El Monto debe ser mayor que cero!", Toast.LENGTH_LONG)
                            .show()
                        focusRequesterMonto.requestFocus()
                        return@FloatingActionButton
                    }

                    viewModel.Guardar()
                    Toast.makeText(validar, "Se ha Guardado Correctamente!", Toast.LENGTH_LONG).show()
                    viewModel.deudor = ""
                    viewModel.concepto = ""
                    viewModel.monto = 0.00f
                    focusRequester.requestFocus()
                }
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = null)
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp)) {

            OutlinedTextField(
                value = viewModel.deudor,
                label = { Text(text = "Deudor") },
                onValueChange = { viewModel.deudor = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                }
            )

            OutlinedTextField(
                value = viewModel.concepto,
                label = { Text(text = "Concepto") },
                onValueChange = { viewModel.concepto = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterConcepto),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.NotAccessible, contentDescription = null)
                }
            )

            OutlinedTextField(
                value = viewModel.monto.toString(),
                label = { Text(text = "Monto") },
                onValueChange = { viewModel.monto = it.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterMonto),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
                }
            )
        }
    }
}