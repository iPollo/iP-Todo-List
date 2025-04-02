package com.example.todolist.domain.model

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folders")
data class Folder(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var folderName: String,
    var folderIcon: ImageVector,
    var folderType: FOLDERTYPE,
    var isDefault: Boolean = false,
    var isFolderManager: Boolean = false,
)
