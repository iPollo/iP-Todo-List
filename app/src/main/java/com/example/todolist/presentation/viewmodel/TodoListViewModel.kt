package com.example.todolist.presentation.viewmodel

import android.content.Context
import android.os.Build
import android.os.Debug
import android.util.Log
import android.util.MutableInt
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.todolist.data.local.AppDataStore
import com.example.todolist.data.local.DataBaseSetup
import com.example.todolist.data.local.FolderDAO
import com.example.todolist.domain.model.FOLDERTYPE
import com.example.todolist.domain.model.Folder
import com.example.todolist.domain.model.PRIORITYLEVEL
import com.example.todolist.domain.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoListViewModel: ViewModel() {

    val folderDao = DataBaseSetup.appDataBase.getFolderDAO()
    val taskDao = DataBaseSetup.appDataBase.getTaskDao()

    private val _newTaskInput = MutableLiveData("")
    val newTaskInput: LiveData<String> = _newTaskInput

    var currentSelectedFolder by mutableIntStateOf(0)
        private set

    var currentEditingFolder by mutableStateOf(Folder(0, "Default", Icons.Filled.Email, FOLDERTYPE.FOLDER))
        private set

    val taskList: LiveData<List<Task>> = taskDao.getAllDataFromFolder(currentSelectedFolder).asLiveData()
    val folderList: LiveData<List<Folder>> = folderDao.getAllData()

    fun onNewTaskInputChanger(newText: String){
        _newTaskInput.value = newText
    }

    fun onFolderClick(folderid: Int){
        currentSelectedFolder = folderid
        //getAllTasksFromCurrentFolder()
    }

    fun isFolderCurrentSelectedFolder(folder: Folder): Boolean{
        return folder.id == currentSelectedFolder
    }

    fun getAllTasksFromCurrentFolder(){
        //taskList = taskDao.getAllDataFromFolder(currentSelectedFolder)
    }

    fun addFolder(folder: Folder){

        viewModelScope.launch(Dispatchers.IO){
            folderDao.addFolderData(folder)
            currentSelectedFolder = 1
        }

    }

    fun seedDefautFoldersFirstRun(context: Context){
        viewModelScope.launch {
            val dataStore = AppDataStore(context)
            if(dataStore.isFirstaRun()){
                addFolder(Folder(0, "", Icons.Filled.Menu, FOLDERTYPE.ADD, isFolderManager = true))
                addFolder(Folder(0, "Groceries", Icons.Filled.ShoppingCart, FOLDERTYPE.FOLDER))
                addFolder(Folder(0, "My Tasks", Icons.Filled.Checklist, FOLDERTYPE.FOLDER))

                dataStore.setFirstRunDone()
            }
        }
    }

    fun onIconSelectorClick(icon: ImageVector, navController: NavController){
        //TodoListObject.setFolderIcon(currentEditingFolder, icon)
        navController.popBackStack()
    }

    fun onFolderIconClick(folder: Folder, navController: NavController){
        currentEditingFolder = folder
        navController.navigate("todo_list_iconselector")
    }

    fun onFolderNameTextChange(folder: Folder, newText: String){
        //TodoListObject.setFolderName(folder.id, newText)
    }

    fun onFolderDeleteClick(folder: Folder){
        viewModelScope.launch(Dispatchers.IO) {
            folderDao.deleteFolderData(folder.id)
        }
    }

    fun onNewFolderButtonClick(){
        addFolder(Folder(0, "My new folder", Icons.Filled.Folder, FOLDERTYPE.FOLDER))
    }

    fun setFirstFolderAsCurrent(){
        //currentSelectedFolder = TodoListObject.getFirstFolderId()
    }

    fun isFolderManager(folderid: Int): Boolean{
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTask(text: String){
        if(text.isBlank()) return;
        //currentSelectedFolder = 1
        Log.d("ViewModel", "Adding task to folder ID: $currentSelectedFolder")
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.insertTask(
                Task(
                    text = text,
                    prioritylevel = PRIORITYLEVEL.NONE,
                    finished = false,
                    folderId = currentSelectedFolder,
                    creationDate = Date.from(Instant.now())
                )
            )
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.deleteTask(task)
        }
    }

    fun setTaskFinished(taskid: Int){
       // TodoListObject.setTaskFinished(currentSelectedFolder, taskid)
        getAllTasksFromCurrentFolder()
    }



}

