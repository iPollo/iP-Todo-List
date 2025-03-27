package com.example.todolist.presentation.viewmodel

import android.os.Build
import android.os.Debug
import android.util.Log
import android.util.MutableInt
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Folder
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.todolist.data.datasource.TodoListObject
import com.example.todolist.domain.model.FOLDERTYPE
import com.example.todolist.domain.model.Folder
import com.example.todolist.domain.model.Task

class TodoListViewModel: ViewModel() {

    private val _newTaskInput = MutableLiveData("")
    val newTaskInput: LiveData<String> = _newTaskInput

    private val _taskList = MutableLiveData<List<Task>>()
    val taskList: LiveData<List<Task>> = _taskList

    private val _folderList = MutableLiveData<List<Folder>>()
    val folderList: LiveData<List<Folder>> = _folderList

    var currentSelectedFolder by mutableIntStateOf(0)
        private set

    var currentEditingFolder by mutableStateOf(Folder(0, "Default", Icons.Filled.Email, FOLDERTYPE.FOLDER, mutableListOf<Task>()))
        private set

    fun onNewTaskInputChanger(newText: String){
        _newTaskInput.value = newText
    }

    fun onFolderClick(folderid: Int){
        currentSelectedFolder = folderid
        getAllTasksFromCurrentFolder()
    }

    fun isFolderCurrentSelectedFolder(folder: Folder): Boolean{
        return folder.id == currentSelectedFolder
    }

    fun getAllTasksFromCurrentFolder(){
        _taskList.value = TodoListObject.getAllTasks(currentSelectedFolder)
    }

    fun addFolder(folder: Folder){
        TodoListObject.addFolder(folder)
        _folderList.value = TodoListObject.getAllFolders()
        currentSelectedFolder = 1
    }

    fun onIconSelectorClick(icon: ImageVector, navController: NavController){
        TodoListObject.setFolderIcon(currentEditingFolder, icon)
        _folderList.value = TodoListObject.getAllFolders()
        navController.popBackStack()
    }

    fun onFolderIconClick(folder: Folder, navController: NavController){
        currentEditingFolder = folder
        navController.navigate("todo_list_iconselector")
    }

    fun onFolderNameTextChange(folder: Folder, newText: String){
        TodoListObject.setFolderName(folder.id, newText)
        _folderList.value = TodoListObject.getAllFolders()
    }

    fun onFolderDeleteClick(folder: Folder){
        TodoListObject.removeFolder(folder)
        _folderList.value = TodoListObject.getAllFolders()
    }

    fun onNewFolderButtonClick(){
        addFolder(Folder(0, "My new folder", Icons.Filled.Folder, FOLDERTYPE.FOLDER, mutableListOf<Task>()))
    }

    fun setFirstFolderAsCurrent(){
        currentSelectedFolder = TodoListObject.getFirstFolderId()
    }

    fun isFolderManager(folderid: Int): Boolean{
        return TodoListObject.isFolderManager(folderid)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTask(text: String){
        if(text.isBlank()) return;
        TodoListObject.addTask(currentSelectedFolder, text)
        getAllTasksFromCurrentFolder()
    }

    fun deleteTask(task: Task){
        TodoListObject.deleteTask(currentSelectedFolder, task)
        getAllTasksFromCurrentFolder()
    }

    fun setTaskFinished(taskid: Int){
        TodoListObject.setTaskFinished(currentSelectedFolder, taskid)
        getAllTasksFromCurrentFolder()
    }



}

