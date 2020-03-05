package com.example.mynewroomdb.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class DatabaseEntityModel(
    val title: String,
    val note: String
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}