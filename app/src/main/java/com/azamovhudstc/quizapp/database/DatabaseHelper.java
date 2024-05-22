package com.azamovhudstc.quizapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase database;
    public DatabaseHelper(@Nullable Context context) {
        super(context, "QuizApp.db", null, 1);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE history (id INTEGER PRIMARY KEY AUTOINCREMENT, subject TEXT, correct INTEGER, incorrect INTEGER, createdTime Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(Context context, String subject, int correct, int incorrect, String createdTime) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject", subject);
        contentValues.put("correct", correct);
        contentValues.put("incorrect", incorrect);
        contentValues.put("createdTime", createdTime);

        long newRowId = database.insert("history", null, contentValues);

        if (newRowId == -1) {
            Toast.makeText(context, "Error with inserting data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
