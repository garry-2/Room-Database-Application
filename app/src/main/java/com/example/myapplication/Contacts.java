package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ContactsTable")
public class Contacts {

    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String ph_no;

    public Contacts(int id, String name, String ph_no) {
        this.id = id;
        this.name = name;
        this.ph_no = ph_no;
    }

    @Ignore
    public Contacts(String name, String ph_no) {
        this.name = name;
        this.ph_no = ph_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
}
