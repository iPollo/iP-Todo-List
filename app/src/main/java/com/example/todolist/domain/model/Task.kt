package com.example.todolist.domain.model

import java.util.Date

data class Task(
    var id: Int,
    var text: String,
    var prioritylevel: PRIORITYLEVEL,
    var finished: Boolean,
    var creationDate: Date,
)
