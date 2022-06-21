package edu.ucne.parcial_en_compose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial_en_compose.model.Prestamo


@Database(entities = [Prestamo::class],
    exportSchema = false,
    version = 1)
abstract class PrestamoDb: RoomDatabase() {
    abstract val pretamoDao: PrestamoDao
}