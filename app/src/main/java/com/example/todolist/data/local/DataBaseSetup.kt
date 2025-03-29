package com.example.todolist.data.local

import android.app.Application
import androidx.room.Room

class DataBaseSetup: Application() {

    companion object {
        lateinit var appDataBase: DataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            DataBase.NAME
        ).build()
    }

}