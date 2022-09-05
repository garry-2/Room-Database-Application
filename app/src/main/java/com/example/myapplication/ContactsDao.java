package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactsDao {

    @Query("SELECT * FROM ContactsTable")
    List<Contacts> getInfo();

    @Insert
    void addData(Contacts contacts);

    @Update
    void updateData(Contacts contacts);

    @Delete
    void deleteData(Contacts contacts);




}
