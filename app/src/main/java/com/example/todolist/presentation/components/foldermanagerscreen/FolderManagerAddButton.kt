package com.example.todolist.presentation.components.foldermanagerscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FolderMangerAddButton(){

    Box(){}

    OutlinedButton(
        onClick = { },
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 10.dp)
            .height(50.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Companion.Green),
        border = BorderStroke(0.dp, Color(58, 177, 25, 255))
    ) {

        Icon(
            Icons.Filled.AddCircle,
            contentDescription = "addFolderButton",
            tint = Color.Companion.White,
            modifier = Modifier.Companion.size(50.dp)
        )
    }


}