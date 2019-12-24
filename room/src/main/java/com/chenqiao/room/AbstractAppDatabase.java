package com.chenqiao.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AbstractAppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
