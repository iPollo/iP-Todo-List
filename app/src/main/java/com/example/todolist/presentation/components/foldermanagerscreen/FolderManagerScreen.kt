package com.example.todolist.presentation.components.foldermanagerscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolist.presentation.viewmodel.TodoListViewModel
import com.example.todolist.ui.theme.AppColor_Background


@Composable
fun FolderManagerScreen(viewModel: TodoListViewModel, navController: NavController){

    //Main Column
    LazyColumn(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(AppColor_Background)
            .padding(10.dp),
        state = rememberLazyListState()
    ) {
        item {
            FolderMangerAddButton()
        }
        items(2){
            FolderManagerFolderInfo()
        }
    }

}