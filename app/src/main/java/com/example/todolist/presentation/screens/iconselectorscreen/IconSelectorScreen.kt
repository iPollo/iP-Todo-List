package com.example.todolist.presentation.screens.iconselectorscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.example.todolist.data.datasource.IconList.folderIconsList
import com.example.todolist.presentation.viewmodel.TodoListViewModel
import com.example.todolist.ui.theme.AppColor_Background

@Composable
fun IconSelectorScreen(viewModel: TodoListViewModel, navController: NavController){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        modifier = Modifier.fillMaxSize().background(AppColor_Background).padding(start = 10.dp, end=10.dp, top = 50.dp),
        //contentPadding = PaddingValues(vertical = 10.dp, horizontal = 10.dp)
    ) {
        items(folderIconsList.size){ index->
            IconButton(onIconClick = {viewModel.onIconSelectorClick(folderIconsList[index], navController)}, icon = folderIconsList[index])
        }
    }
}

    //Box(modifier = Modifier.fillMaxSize().background(Color.Red)){}



