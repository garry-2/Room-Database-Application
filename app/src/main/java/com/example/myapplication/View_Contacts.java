package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowId;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class View_Contacts extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar2;
    Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);

        window = getWindow();
        window.setBackgroundDrawableResource(R.drawable.gradient_color_3);

        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("All Contacts");

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        MyDBHelper myDBHelper = MyDBHelper.getDB(getApplicationContext());
        ArrayList<Contacts> arrContacts = (ArrayList<Contacts>) myDBHelper.contactsDao().getInfo();




        recycleViewAdapter recycleviewAdapter = new recycleViewAdapter(getApplicationContext(),arrContacts);
        recyclerView.setAdapter(recycleviewAdapter);


    }
}