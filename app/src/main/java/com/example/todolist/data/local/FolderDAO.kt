package com.example.todolist.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.domain.model.Folder

@Dao
interface FolderDAO {

    // Return all folders
    @Query("SELECT * FROM folders ORDER BY isFolderManager ASC")
    fun getAllData(): LiveData<List<Folder>>

    @Insert
    fun addFolderData(folder: Folder)

    @Query("DELETE FROM folders WHERE id = :id")
    fun deleteFolderData(id: Int)

}