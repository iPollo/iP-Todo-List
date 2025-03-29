package com.example.todolist.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.todolist.domain.model.Folder
import com.example.todolist.domain.model.Task

@Dao
interface TaskDAO {
    @Query("SELECT * FROM tasks WHERE folderId = :id")
    fun getAllDataFromFolder(id : Int): LiveData<List<Task>>
}