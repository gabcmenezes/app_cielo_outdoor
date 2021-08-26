package com.example.app_cielo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_cielo.factories.DatabaseFactory;

public class Connection {

    public static SQLiteDatabase getInstance(Context context) {
        DatabaseFactory database = new DatabaseFactory(context);
        return database.getWritableDatabase();
    }
}
