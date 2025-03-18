package com.example.todolist.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.domain.model.FOLDERTYPE


@Composable
fun FoldersButton(type: FOLDERTYPE, icon: ImageVector, iconColor: Color, backColor: Color, borderColor: Color){

    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .size(150.dp)
            .padding(end = 5.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = backColor),
        border = BorderStroke(2.dp, borderColor)

    ){
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
            Icon(
                imageVector = icon,
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
                contentDescription = "editButtons",
                tint = iconColor,
            )

            if(type == FOLDERTYPE.FOLDER){
                Text(
                    "Mercado",
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 10.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    "4 / 10",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

                LinearProgressIndicator(
                    modifier = Modifier.align(Alignment.BottomCenter).padding(6.dp).clip(
                        RoundedCornerShape(20.dp)
                    ),
                    color = Color.White,
                    progress = { 0.8f },
                    trackColor = Color.DarkGray,
                )
            }
        }
    }


}
