package edu.ucne.parcial_en_compose.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "prestamos")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int = 0,
    val deudor: String,
    val concepto: String,
    val monto: Float
)
