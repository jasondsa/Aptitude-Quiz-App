package com.azamovhudstc.quizapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.azamovhudstc.quizapp.model.HistoryModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        db.execSQL("CREATE TABLE history (id INTEGER PRIMARY KEY AUTOINCREMENT, subject TEXT, correct INTEGER, incorrect INTEGER,overallPoints INTEGER, createdTime Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(Context context, String subject, int correct, int incorrect, String createdTime) {
        // Check if a record with the same createdTime already exists
        Cursor cursor = database.query("history", new String[]{"createdTime"}, "createdTime = ?", new String[]{createdTime}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            // Record already exists, display a Toast message and return
            Toast.makeText(context, "Record with this createdTime already exists", Toast.LENGTH_SHORT).show();
            cursor.close();
            return;
        }

        // If the record does not exist, insert the new record
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject", subject);
        contentValues.put("correct", correct);
        contentValues.put("incorrect", incorrect);
        contentValues.put("createdTime", createdTime);
        contentValues.put("overallPoints", correct - incorrect);

        long newRowId = database.insert("history", null, contentValues);

        if (newRowId == -1) {
            Toast.makeText(context, "Error with inserting data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<HistoryModel> getAllHistory() {
        ArrayList<HistoryModel> historyList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM history";

        Cursor cursor = database.rawQuery(selectQuery, null);

        // Define the date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String subject = cursor.getString(cursor.getColumnIndexOrThrow("subject"));
                int correct = cursor.getInt(cursor.getColumnIndexOrThrow("correct"));
                int incorrect = cursor.getInt(cursor.getColumnIndexOrThrow("incorrect"));
                int overallPoints = cursor.getInt(cursor.getColumnIndexOrThrow("overallPoints"));
                String createdTimeStr = cursor.getString(cursor.getColumnIndexOrThrow("createdTime"));

                // Convert createdTime from String to long
                long createdTime = 0;
                try {
                    Date date = sdf.parse(createdTimeStr);
                    if (date != null) {
                        createdTime = date.getTime();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Now use the long value for createdTime
                HistoryModel history = new HistoryModel(createdTime, subject, correct, incorrect, overallPoints);

                // Adding history to list
                historyList.add(history);
            } while (cursor.moveToNext());
        }

        // Return history list
        return historyList;
    }
}
