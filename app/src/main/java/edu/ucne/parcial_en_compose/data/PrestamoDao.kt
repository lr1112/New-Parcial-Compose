package edu.ucne.parcial_en_compose.data

import androidx.room.*
import edu.ucne.parcial_en_compose.model.Prestamo
import kotlinx.coroutines.flow.Flow


@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(prestamo: Prestamo)
    @Delete
    suspend fun eliminar(prestamo: Prestamo)
    @Query("""
        SELECT * 
        FROM Prestamos
        WHERE prestamoId=:prestamoId        
    """)
    fun buscar(prestamoId: Int): Flow<Prestamo>

    @Query("""
        SELECT * 
        FROM Prestamos
        ORDER BY prestamoId    
    """)
    fun getList(): Flow<List<Prestamo>>


}