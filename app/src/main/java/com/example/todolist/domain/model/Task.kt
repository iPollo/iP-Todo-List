package com.example.todolist.domain.model

import android.adservices.adid.AdId
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(
    tableName = "tasks",
)
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var text: String,
    var prioritylevel: PRIORITYLEVEL,
    var finished: Boolean,
    var creationDate: Date,
    val folderId: Int
)
