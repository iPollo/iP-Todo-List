package com.example.todolist.data.local

import android.media.Image
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todolist.data.datasource.getImageVectorByName
import java.util.Date

class Converters {

    @TypeConverter
    fun fromImageVector(imageVector: ImageVector): String{
        return imageVector.name
    }

    @TypeConverter
    fun toImageVector(name: String): ImageVector{
        return getImageVectorByName(name)
    }

    @TypeConverter
    fun fromDate(date:Date):Long{
        return date.time
    }

    @TypeConverter
    fun toDate(time: Long):Date{
        return Date(time)
    }

}