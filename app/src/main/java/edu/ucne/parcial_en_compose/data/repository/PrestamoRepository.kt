package edu.ucne.parcial_en_compose.data.repository

import edu.ucne.parcial_en_compose.data.PrestamoDao
import edu.ucne.parcial_en_compose.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamoDao: PrestamoDao
) {

    suspend fun insertar(prestamo: Prestamo){
        prestamoDao.insertar(prestamo)
    }
    suspend fun eliminar(prestamo: Prestamo){
        prestamoDao.eliminar(prestamo)
    }

    fun buscar(prestamoId: Int): Flow<Prestamo> {
        return prestamoDao.buscar(prestamoId)
    }

    fun getList(): Flow<List<Prestamo>> {
        return prestamoDao.getList()
    }
}