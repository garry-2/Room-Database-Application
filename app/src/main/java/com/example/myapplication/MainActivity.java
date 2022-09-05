package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Room Database");

        /*Steps to make Room Database
        STEP - 1: Add room persistence dependency ,
        STEP - 2 : Make Entity as Table with its name and Columns
        STEP - 3 : Make Dao ( Data Access Object ) for accessing Queries on database(Interface class)
        STEP - 3: Make abstract Database Helper class for using database at runtime
         */

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.opt_menu1,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemid = item.getItemId();
        MyDBHelper myDBHelper = MyDBHelper.getDB(getApplicationContext());
        if(itemid == R.id.add_contacts){

            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.add_contacts_dialog_layout);

            EditText nameEditText,ph_noEditText;
            AppCompatButton btn;
            nameEditText = dialog.findViewById(R.id.DialogName);
            ph_noEditText = dialog.findViewById(R.id.DialogPhoneNumber);
            btn = dialog.findViewById(R.id.DialogBtn);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    String name1 = nameEditText.getText().toString();
                    String ph_no1 = ph_noEditText.getText().toString();
                    myDBHelper.contactsDao().addData(
                            new Contacts(name1,ph_no1)
                    );
                    dialog.dismiss();
                }

            });
            dialog.show();
        }

        if(itemid == R.id.view_contacts){
            Intent intent;
            intent = new Intent(MainActivity.this,View_Contacts.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}