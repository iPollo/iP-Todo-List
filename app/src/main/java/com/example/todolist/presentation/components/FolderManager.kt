package com.example.todolist.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolist.presentation.viewmodel.TodoListViewModel
import com.example.todolist.ui.theme.AppColor_Background


@Composable
fun FolderList(){



}

@Composable
fun FolderManager(viewModel: TodoListViewModel, navController: NavController){

    //Main Column
    Column(modifier = Modifier.fillMaxSize().background(Color.Red).padding(10.dp)){

        Box(modifier = Modifier.weight(3f).fillMaxWidth().background(Color.Green)){}
        Box(modifier = Modifier.weight(0.5f).fillMaxWidth().background(Color.Cyan)){}
        Box(modifier = Modifier.weight(2f).fillMaxWidth().background(Color.DarkGray)){}
        //LazyColumn(modifier = Modifier.background(Color.Green).weight(2f)){}

    }


        // Folders list




        // Folder info






    }
