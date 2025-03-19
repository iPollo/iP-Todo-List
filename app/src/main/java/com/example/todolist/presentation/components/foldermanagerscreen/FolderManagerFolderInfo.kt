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
import androidx.compose.material.icons.filled.Email
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
fun FolderManagerFolderInfo(){

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
            Button(
                onClick = {},
                Modifier.align(Alignment.CenterStart).padding(start = 10.dp).size(50.dp),
                contentPadding = PaddingValues(1.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0,0,0,0))
            ){
                Icon(
                    Icons.Filled.Email,
                    contentDescription = "addFolderButton",
                    tint = Color.Companion.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }

    }

}