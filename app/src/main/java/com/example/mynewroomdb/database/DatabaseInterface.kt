package com.example.mynewroomdb.database

import androidx.room.*

@Dao
interface DatabaseInterface {


    @Insert
    suspend fun addNote(note: DatabaseEntityModel)

    @Query("SELECT * FROM databaseentitymodel ORDER BY id DESC")
    suspend fun getAllNotes() : List<DatabaseEntityModel>

    @Insert
    suspend fun addMultipleNotes(vararg note: DatabaseEntityModel)

    @Update
    suspend fun updateNote(note: DatabaseEntityModel)

    @Delete
    suspend fun deleteNote(note: DatabaseEntityModel)
}