package com.example.todolist.presentation.components

import android.util.Log
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.domain.model.FOLDERTYPE
import com.example.todolist.domain.model.Folder
import com.example.todolist.presentation.viewmodel.TodoListViewModel

@Composable
fun FolderButtonComponent(viewModel: TodoListViewModel, folder: Folder, onButtonClick:()-> Unit){

    val totalTasks: Int = folder.taskList.count()
    val totalFinishedTasks: Int = folder.taskList.count(){it.finished}
    val folderProgress: Float = if(totalFinishedTasks == 0){0f}else{(totalFinishedTasks.toFloat()/totalTasks.toFloat())}
    val folderBackColor: Color = if(viewModel.isFolderCurrentSelectedFolder(folder)) Color(255,255,255,10) else Color(20,20,20)
    var folderBorderColor: Color = if(viewModel.isFolderCurrentSelectedFolder(folder)) Color(255,255,255,255) else Color(40,40,40)
    val baseFontSize = 20.0f
    val minFontSize = 10.0f
    val dynamicFontSize = (baseFontSize - ((folder.folderName.length * 0.5))).sp


    OutlinedButton(
        onClick = onButtonClick,
        modifier = Modifier
            .size(150.dp)
            .padding(end = 5.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = folderBackColor),
        border = BorderStroke(2.dp, folderBorderColor)

    ){
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
            Icon(
                imageVector = folder.folderIcon,
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center),
                contentDescription = "editButtons",
                tint = Color.White,
            )

            if(folder.folderType == FOLDERTYPE.FOLDER){
                Text(
                    folder.folderName,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 10.dp),
                    fontSize = dynamicFontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "$totalFinishedTasks / $totalTasks",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

                LinearProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(6.dp)
                        .clip(
                            RoundedCornerShape(20.dp)
                        ),
                    color = Color.White,
                    progress = {folderProgress},
                    trackColor = Color.DarkGray,
                )
            }
        }
    }


}