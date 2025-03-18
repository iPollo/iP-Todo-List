package com.example.todolist

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.domain.model.FOLDERTYPE
import com.example.todolist.domain.model.PRIORITYLEVEL
import com.example.todolist.domain.model.Task
import com.example.todolist.presentation.components.AddTaskButton
import com.example.todolist.presentation.components.AddTaskTextField
import com.example.todolist.presentation.components.DrawTask
import com.example.todolist.presentation.components.FoldersButton
import com.example.todolist.presentation.viewmodel.TodoListViewModel
import com.example.todolist.ui.theme.AppColor_Background
import com.example.todolist.ui.theme.AppColor_FolderButtonContainer
import com.example.todolist.ui.theme.TodoListTheme
import java.time.Instant
import java.util.Date
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.todolist.domain.model.Folder
import com.example.todolist.presentation.components.FolderButtonComponent
import com.example.todolist.presentation.components.NavigationGrph

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = TodoListViewModel()

        viewModel.addFolder(Folder(0, "", Icons.Filled.Menu , FOLDERTYPE.ADD, mutableListOf<Task>()))
        viewModel.addFolder(Folder(0, "Market", Icons.Filled.ShoppingCart, FOLDERTYPE.FOLDER, mutableListOf<Task>()))
        viewModel.addFolder(Folder(0, "My Tasks", Icons.Filled.DateRange, FOLDERTYPE.FOLDER, mutableListOf<Task>()))

        viewModel.setFirstFolderAsCurrent()

        setContent {
            TodoListTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationGrph(viewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListApp(viewModel: TodoListViewModel, navController: NavHostController){

    var inputTask by remember { mutableStateOf("")}
    val todoList by viewModel.taskList.observeAsState()
    val foldersList by viewModel.folderList.observeAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(AppColor_Background)){

        // Bottom row (Add text field + add button)
        Row(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(top = 30.dp, bottom = 30.dp, start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AddTaskTextField(viewModel, inputTask, onTaskTextChange = {inputTask = it})
            AddTaskButton(viewModel, onButtonClick = {viewModel.addTask(inputTask); inputTask = ""})
        }

        // Top Row Folders
        foldersList?.let{
            LazyRow(modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 60.dp, start = 10.dp, end = 10.dp),
                state = rememberLazyListState(),
                verticalAlignment = Alignment.CenterVertically,
                userScrollEnabled = true,
            ){
                itemsIndexed(it){_, folder: Folder ->
                    if(!viewModel.isFolderManager(folder.id)) FolderButtonComponent(viewModel, folder, onButtonClick = {viewModel.onFolderClick(folder.id)})
                    else FolderButtonComponent(viewModel, folder, onButtonClick = {navController.navigate("todo_list_foldermanager")})
                }
            }
        }


        // Middle Column (Tasks)
        todoList?.let{
            LazyColumn(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top=225.dp,start = 10.dp, end = 10.dp, bottom = 105.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                state = rememberLazyListState(),
                content = {
                    itemsIndexed(it){ _, item: Task ->
                        DrawTask(item, onDeleteTaskClick = {viewModel.deleteTask(item)}, onTaskClick = {}, onFinisTaskClick = {viewModel.setTaskFinished(item.id)})
                    }
                }
            )
        }

    }

}