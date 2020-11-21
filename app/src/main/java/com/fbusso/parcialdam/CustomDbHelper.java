package com.fbusso.parcialdam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CustomDb.db";
    final String CREATE_TABLE_QUERY = "CREATE TABLE custom_entity (id INTEGER PRIMARY KEY AUTOINCREMENT, value STRING)";
    final String SELECT_ALL_QUERY = "SELECT * FROM custom_entity";


    public CustomDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
        //onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS custom_entity");

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public void insert(CustomEntity e) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put("value", e.get_value());

        db.insert("custom_entity", null, row);
        db.close();
    }

    public List<String> getAllCustomEntities() {
        List<String> list  = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL_QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                CustomEntity customEntity = new CustomEntity();
                customEntity.set_id(Integer.parseInt(cursor.getString(0)));
                customEntity.set_value(cursor.getString(1));
                list.add(customEntity.toString());
            } while (cursor.moveToNext());
        }

        return list;
    }
}
