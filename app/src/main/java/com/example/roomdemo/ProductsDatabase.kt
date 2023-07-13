package com.example.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Products::class],
    version = 1
)
abstract class ProductsDatabase: RoomDatabase() {
    abstract fun getProducts(): ProductsDao

    companion object{
        @Volatile private var instance: ProductsDatabase? = null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ProductsDatabase::class.java,
            "products"
        ).build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}