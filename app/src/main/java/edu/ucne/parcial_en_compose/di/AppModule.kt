package edu.ucne.parcial_en_compose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial_en_compose.data.PrestamoDao
import edu.ucne.parcial_en_compose.data.PrestamoDb
import edu.ucne.parcial_en_compose.data.repository.PrestamoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPrestamosDb(@ApplicationContext context: Context): PrestamoDb {
        return Room.databaseBuilder(
            context,
            PrestamoDb::class.java, "PrestamoDb")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    fun providesPrestamoDao(prestamoDb:PrestamoDb): PrestamoDao {
        return prestamoDb.pretamoDao
    }

    @Provides
    fun providesPrestamoRepository(prestamoDao: PrestamoDao): PrestamoRepository {
        return PrestamoRepository(prestamoDao)
    }
}