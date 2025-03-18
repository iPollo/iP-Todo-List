package com.example.todolist.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolist.presentation.viewmodel.TodoListViewModel
import com.example.todolist.ui.theme.AppColor_AddButton
import com.example.todolist.ui.theme.AppColor_Background

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddTaskButton(viewModel: TodoListViewModel, onButtonClick: ()->Unit){

    FloatingActionButton(
        onClick = {onButtonClick()},
        modifier = Modifier.size(60.dp),
        shape = RoundedCornerShape(59.dp),
        containerColor = Color(15, 172, 15, 255),
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.AddCircle,
            modifier = Modifier.size(60.dp),
            contentDescription = "add",
            tint = Color.White
        )
    }
}

@Composable
fun RowScope.AddTaskTextField(viewModel: TodoListViewModel, taskText: String, onTaskTextChange: (String)->Unit){

    TextField(
        value = taskText,
        onValueChange = {onTaskTextChange(it)},
        modifier = Modifier
            .weight(2f)
            .padding(end = 10.dp)
            .size(260.dp, 60.dp),
        readOnly = false,
        singleLine = true,
        shape = RoundedCornerShape(25.dp),
        label = { Text("Digite sua tarefa aqui!") },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.White,
            unfocusedContainerColor = Color(20,20,20),
            focusedContainerColor = Color(20,20,20),
            focusedTextColor = Color.White,
            focusedIndicatorColor = Color(0,0,0,0),
            unfocusedIndicatorColor = Color(0,0,0,0),
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            focusedPlaceholderColor = Color.White,
            cursorColor = Color.White

        ),
        placeholder = { Text("") }
    )
}