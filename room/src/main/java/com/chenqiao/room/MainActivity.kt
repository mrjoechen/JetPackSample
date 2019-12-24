package com.chenqiao.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlin.concurrent.thread

/**
 *
 */
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity-TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = Room.databaseBuilder(applicationContext,
                AbstractAppDatabase::class.java, "user_database").build()

        thread { db.userDao().insertAll(User("test1FirstName", "test1LastName"))

            val all = db.userDao().all.toString()
            Log.i(TAG, all)
        }



    }
}
