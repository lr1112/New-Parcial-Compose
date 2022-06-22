package edu.ucne.parcial_en_compose.ui.theme.prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial_en_compose.data.repository.PrestamoRepository
import edu.ucne.parcial_en_compose.model.Prestamo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val prestamoRepository: PrestamoRepository
): ViewModel() {
    var deudor by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf(0.00f)

    var listado = prestamoRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch {
            prestamoRepository.insertar(
                Prestamo(
                    deudor = deudor,
                    concepto = concepto,
                    monto = monto
                )
            )
        }
    }

}