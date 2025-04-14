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

    @Insert
    suspend fun insertTask(task:Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT COUNT(*) FROM tasks WHERE folderId = :id")
    fun getTotalTaskCountFromFolder(id: Int): LiveData<Int>

    @Query("SELECT COUNT(*) FROM tasks WHERE folderId = :id AND finished = 1")
    fun getTotalFinishedTaskCountFromFolder(id: Int): LiveData<Int>
}