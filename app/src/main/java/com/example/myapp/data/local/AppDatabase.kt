package com.example.myapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapp.data.local.dao.TodoDao
import com.example.myapp.data.local.entity.TodoEntity

@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}