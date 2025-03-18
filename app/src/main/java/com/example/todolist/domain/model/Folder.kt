package com.example.todolist.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Folder(
    var id: Int,
    var folderName: String,
    var folderIcon: ImageVector,
    var folderType: FOLDERTYPE,
    var taskList: MutableList<Task>
)
