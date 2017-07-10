package com.example.admin.sqliteconnectionsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class DataEntry extends AppCompatActivity {

    DatabaseHandler db;
    EditText nameEdtxt, phoneEdtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        nameEdtxt = (EditText) findViewById(R.id.editText1);
        phoneEdtxt = (EditText) findViewById(R.id.editText2);
        db = new DatabaseHandler(this);

//        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<Contact> contacts = db.getAllContacts();
//
//        for (Contact cn : contacts) {
//            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            String name = nameEdtxt.getText().toString();
            String phone = phoneEdtxt.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            } else if (phone.isEmpty()) {
                Toast.makeText(this, "Enter Contact Number", Toast.LENGTH_SHORT).show();
            } else {
                db.addContact(new Contact(name, phone));
                Toast.makeText(this, "Contact added successfully!", Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId() == R.id.button2){
            // Reading all contacts
        List<Contact> contacts = db.getAllContacts();
            for (Contact cn : contacts) {
                String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                Log.d("Name: ", log);
                Toast.makeText(this, log, Toast.LENGTH_LONG).show();
            }
        }
    }
}
