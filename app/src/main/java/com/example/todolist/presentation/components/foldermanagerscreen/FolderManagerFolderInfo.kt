package com.example.todolist.presentation.components.foldermanagerscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.domain.model.Folder
import com.example.todolist.presentation.viewmodel.TodoListViewModel

@Composable
fun FolderManagerFolderInfo(folder: Folder, onIconClick:()->Unit, onDeleteClick:()-> Unit, viewModel: TodoListViewModel){

    OutlinedButton(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 2.dp)
            .height(100.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(20,20,20)),
        border = BorderStroke(2.dp, Color(40,40,40, 255)),
        contentPadding = PaddingValues(0.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()){

            TextField(
                value = folder.folderName,
                modifier = Modifier.align(Alignment.Center),
                textStyle = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),
                onValueChange = {viewModel.onFolderNameTextChange(folder, it)},
                readOnly = false,
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    disabledTextColor = Color.Transparent,
                    errorTextColor = Color.Unspecified,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    cursorColor = Color.Transparent,
                    errorCursorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedLeadingIconColor = Color.Transparent,
                    unfocusedLeadingIconColor = Color.Transparent,
                    disabledLeadingIconColor = Color.Transparent,
                    errorLeadingIconColor = Color.Transparent,
                    focusedTrailingIconColor = Color.Transparent,
                    unfocusedTrailingIconColor = Color.Transparent,
                    disabledTrailingIconColor = Color.Transparent,
                    errorTrailingIconColor = Color.Transparent,
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent,
                    disabledLabelColor = Color.Transparent,
                    errorLabelColor = Color.Transparent,
                    focusedPlaceholderColor = Color.Transparent,
                    unfocusedPlaceholderColor = Color.Transparent,
                    disabledPlaceholderColor = Color.Transparent,
                    errorPlaceholderColor = Color.Transparent,
                    focusedSupportingTextColor = Color.Transparent,
                    unfocusedSupportingTextColor = Color.Transparent,
                    disabledSupportingTextColor = Color.Transparent,
                    errorSupportingTextColor = Color.Transparent,
                    focusedPrefixColor = Color.Transparent,
                    unfocusedPrefixColor = Color.Transparent,
                    disabledPrefixColor = Color.Transparent,
                    errorPrefixColor = Color.Transparent,
                    focusedSuffixColor = Color.Transparent,
                    unfocusedSuffixColor = Color.Transparent,
                    disabledSuffixColor = Color.Transparent,
                    errorSuffixColor = Color.Transparent
                )
            )

            Button(
                onClick = onIconClick,
                Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
                    .size(50.dp),
                contentPadding = PaddingValues(1.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0,0,0,0))
            ){
                Icon(
                    folder.folderIcon,
                    contentDescription = "addFolderButton",
                    tint = Color.Companion.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            Button(
                onClick = onDeleteClick,
                Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp)
                    .size(50.dp),
                contentPadding = PaddingValues(1.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0,0,0,0))
            ){
                Icon(
                    Icons.Filled.Close,
                    contentDescription = "addFolderButton",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

    }

}