package com.example.todolist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todolist.domain.model.Folder
import com.example.todolist.domain.model.Task

@Database(entities = [Folder::class, Task::class], version = 1)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {
    companion object {
        const val NAME = "App_DataBase"
    }

    abstract fun getFolderDAO(): FolderDAO

    abstract fun getTaskDao(): TaskDAO

}