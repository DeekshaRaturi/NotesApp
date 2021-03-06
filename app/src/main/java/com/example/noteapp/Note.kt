package com.example.noteapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(val name: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}