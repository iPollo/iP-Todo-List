package com.example.todolist.presentation.components

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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.domain.model.PRIORITYLEVEL
import com.example.todolist.domain.model.Task
import org.w3c.dom.Text

@Composable
fun TaskSideButton(modifier: Modifier, imageVector: ImageVector, containerColor: Color, onButtonClick:()->Unit){
    Button(
        onClick = {onButtonClick()},
        modifier = modifier.size(35.dp),
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        contentPadding = PaddingValues(4.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "delete",
            modifier = Modifier.size(18.dp),
            tint = Color(255, 255, 255, 255)

        )
    }
}

@Composable
fun DrawTask(task: Task, onFinisTaskClick:()->Unit, onDeleteTaskClick:()->Unit, onTaskClick:()->Unit){

    val taskBackColor: Color = if(task.finished){Color(36, 36, 36)}else{Color(56, 56, 56)}
    val taskTextDecoration: TextDecoration = if(task.finished){TextDecoration.LineThrough}else{TextDecoration.None}
    val taskFinishedIcon: ImageVector = if(task.finished){Icons.Filled.Favorite}else{Icons.Filled.FavoriteBorder}

    // Main Button TASK
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth().height(65.dp).padding(bottom = 5.dp),
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = taskBackColor),
        border = BorderStroke(0.dp, Color(0,0,0,0)),
        contentPadding = PaddingValues(0.dp)
    ){

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            //DeleteTaskButton(Modifier.align(Alignment.CenterEnd).padding(end=10.dp))
            TaskSideButton(Modifier.align(Alignment.CenterEnd).padding(end=10.dp), Icons.Filled.Delete, Color(75, 75, 75, 100), onButtonClick = onDeleteTaskClick)
            TaskSideButton(Modifier.align(Alignment.CenterStart).padding(start=10.dp), taskFinishedIcon, Color(75, 75, 75, 0), onButtonClick = onFinisTaskClick)

            Text(
                text = task.text,
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 50.dp, end = 50.dp),
                textAlign = TextAlign.Left,
                color = Color.White,
                fontSize = 13.sp,
                maxLines = 3,
                lineHeight = 12.sp,
                textDecoration = taskTextDecoration
            )

            when(task.prioritylevel){
                PRIORITYLEVEL.TOP -> Box(modifier = Modifier.fillMaxWidth().height(3.dp).align(
                    Alignment.BottomCenter).background(Color(255,0,0,90)))
                PRIORITYLEVEL.LOW -> Box(modifier = Modifier.fillMaxWidth().height(3.dp).align(
                    Alignment.BottomCenter).background(Color(0,255,0,90)))
                PRIORITYLEVEL.MIDDLE -> Box(modifier = Modifier.fillMaxWidth().height(3.dp).align(
                    Alignment.BottomCenter).background(Color(0,0,255,90)))
                else -> Box(modifier = Modifier.fillMaxWidth().height(3.dp).align(Alignment.BottomCenter).background(
                    Color(0,0,255,0)
                ))
            }



        }

    }

}
