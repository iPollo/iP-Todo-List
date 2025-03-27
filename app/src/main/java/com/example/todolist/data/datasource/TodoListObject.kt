package com.example.todolist.data.datasource

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.domain.model.Folder
import com.example.todolist.domain.model.PRIORITYLEVEL
import com.example.todolist.domain.model.Task
import com.example.todolist.ui.theme.TodoListTheme
import java.time.Instant
import java.util.Date

object TodoListObject {

    private val todoTaskList = mutableListOf<Task>()
    private val folderList = mutableListOf<Folder>()

    fun getAllFolders(): List<Folder>{
        return folderList.reversed()
    }

    fun addFolder(newFolder: Folder){
        newFolder.id = System.nanoTime().toInt()
        folderList.add(newFolder)
    }

    fun removeFolder(folder: Folder){
        folderList.remove(folder)
    }

    fun setFolderIcon(folder: Folder, newIcon: ImageVector){
        val updatedFolder = folder.copy(folderIcon = newIcon)
        val folderIndex = getFolderIndex(folder)

        removeFolder(folder)
        folderList.add(folderIndex, updatedFolder)
    }

    fun getFirstFolderId(): Int{
        return folderList.last().id
    }


    fun isFolderManager(folderid: Int): Boolean{
        return folderList.elementAt(0).id == folderid
    }

    fun setFolderName(folderid: Int, newName: String){
        val currentFolder = getFolderFromId(folderid) ?: return
        val updatedFolder = currentFolder.copy(folderName = newName)

        val folderIndex = getFolderIndex(currentFolder)
        removeFolder(currentFolder)

        folderList.add(folderIndex, updatedFolder)
    }

    fun getAllTasks(folderid: Int): List<Task>{
        val currentFolder = getFolderFromId(folderid) ?: return emptyList()
        return currentFolder.taskList.reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTask(folderid: Int, taskText: String){
        val currentFolder = getFolderFromId(folderid)
        currentFolder?.taskList?.add(Task(System.currentTimeMillis().toInt(), taskText, PRIORITYLEVEL.NONE, false, Date.from(Instant.now())))
    }

    fun deleteTask(folderid: Int, task: Task){
        val currentFolder = getFolderFromId(folderid)
        currentFolder?.taskList?.remove(task)
    }

    fun setTaskFinished(folderid: Int, taskid: Int){

        val currentFolder = getFolderFromId(folderid)
        val task = currentFolder?.taskList?.find { it.id == taskid } ?: return
        val updatedTask = task.copy(finished = !task.finished)

        deleteTask(folderid, task)

        if(!task.finished) currentFolder.taskList.add(0, updatedTask)
        else currentFolder.taskList.add(updatedTask)

    }

    fun getFolderFromId(folderid: Int): Folder? {
        val currentFolder = folderList.find {it.id == folderid}
        return currentFolder
    }

    fun getFolderIndex(folder: Folder): Int{
        return folderList.indexOf(folder)
    }


}