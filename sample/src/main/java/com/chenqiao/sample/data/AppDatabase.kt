package com.chenqiao.sample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.chenqiao.sample.data.model.Follow
import com.chenqiao.sample.data.model.Repos
import com.chenqiao.sample.data.model.User
import com.chenqiao.sample.utils.DATABASE_NAME

/**
 * Created by chenqiao on 2019-12-26.
 * e-mail : mrjctech@gmail.com
 */

@Database(entities = [Follow::class, Repos::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun UserDao(): User
    abstract fun FollowDao(): Follow
    abstract fun ReposDao(): Repos


    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                        }
                    })
                    .build()
        }
    }
}