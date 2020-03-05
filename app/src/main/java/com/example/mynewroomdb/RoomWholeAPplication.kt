package com.example.mynewroomdb

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class RoomWholeAPplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this

        coroutineScope = CoroutineScope(Dispatchers.Main)
    }


    companion object {
        lateinit var instance: RoomWholeAPplication

        lateinit var coroutineScope: CoroutineScope

    }

}