package com.example.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Finish this. Just save and retrieve a value. something simple.

    CustomDB customDB;
    TextView textViewName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customDB = new CustomDB(this);
        textViewName = findViewById(R.id.tv_name);

        saveValuesDB();
        readFromDB();
        textViewName.setText(name);
    }

    public void saveValuesDB(){
        SQLiteDatabase writeDB = customDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableConstants.UserDetails.NAME_COLUMN,"textViewName.getText().toString()");
        contentValues.put(TableConstants.UserDetails.BIRTHDAY_COLUMN,"textViewBirthday.getText().toString()");
        contentValues.put(TableConstants.UserDetails.USERNAME_COLUMN,"textViewUsername.getText().toString()");
        contentValues.put(TableConstants.UserDetails.PASSWORD_COLUMN,"textViewPassword.getText().toString()");
        contentValues.put(TableConstants.UserDetails.ADDRESS_COLUMN,"textViewAddress.getText().toString()");
        contentValues.put(TableConstants.UserDetails.COUNTRY_COLUMN,"textViewCountry.getText().toString()");
        contentValues.put(TableConstants.UserDetails.GENDER_COLUMN,"textViewGender.getText().toString()");
        if(writeDB.insert(TableConstants.UserDetails.TABLE_NAME,null,contentValues)>0){
            //todo positive case
            writeDB.insert(TableConstants.UserDetails.TABLE_NAME,null,contentValues);
        } else {
            //todo negative case
        }

    }

    public void readFromDB(){
        SQLiteDatabase readDB = customDB.getReadableDatabase();


        String[] columns = {
                TableConstants.UserDetails.NAME_COLUMN,
                TableConstants.UserDetails.ADDRESS_COLUMN
        };

        String selection =
                TableConstants.UserDetails.COUNTRY_COLUMN+
                        " LIKE ?";
        String[] selectionArgs = {"MEXICO"};
        String groupBy = TableConstants.UserDetails.GENDER_COLUMN;
        String orderBy = TableConstants.UserDetails.BIRTHDAY_COLUMN;
        readDB.query(
                TableConstants.UserDetails.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                groupBy,
                null,
                orderBy
        );
        Cursor cursor =
                readDB.query(TableConstants.UserDetails.TABLE_NAME,
                        columns,
                        null,
                        null,
                        null,
                        null,
                        null);
        while(cursor.moveToNext()){
            try {
                name = cursor.getString(cursor.getColumnIndexOrThrow(TableConstants.UserDetails.TABLE_NAME));
            } catch (Exception err){err.printStackTrace();}
        }

    }
}
