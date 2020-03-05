package com.example.mynewroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [DatabaseEntityModel::class],
    version = 1
)
abstract  class MainRootDatabase: RoomDatabase() {


    abstract fun getDatabaseDao() : DatabaseInterface


    companion object {

        @Volatile private var instance : MainRootDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MainRootDatabase::class.java,
            "notedatabase"
        ).build()

    }
}