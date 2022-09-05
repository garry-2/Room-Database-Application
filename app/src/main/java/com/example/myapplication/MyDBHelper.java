package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = Contacts.class,exportSchema = false,version = 1)
public abstract class MyDBHelper extends RoomDatabase {

    private static final String DATABASE_NAME = "ContactsDB" ;
    private static MyDBHelper instance;

    public static synchronized MyDBHelper getDB(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,MyDBHelper.class,DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract ContactsDao contactsDao();


}
