package com.example.todolist.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.TodoListApp
import com.example.todolist.presentation.components.foldermanagerscreen.FolderManagerScreen
import com.example.todolist.presentation.viewmodel.TodoListViewModel

@Composable
fun NavigationGrph(viewModel: TodoListViewModel){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "todo_list_main"){
        composable("todo_list_main"){TodoListApp(viewModel, navController)}
        composable("todo_list_foldermanager"){ FolderManagerScreen(viewModel, navController) }
    }

}