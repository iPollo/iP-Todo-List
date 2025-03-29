package com.example.todolist.data.local

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todolist.domain.model.Folder
import com.example.todolist.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Query("SELECT * FROM tasks WHERE folderId = :id")
    fun getAllDataFromFolder(id : Int): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task:Task){Log.d("DEBUG", "C3")}

    @Delete
    fun deleteTask(task: Task)
}