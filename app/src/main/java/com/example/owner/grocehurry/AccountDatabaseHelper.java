package com.example.owner.grocehurry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Owner on 26/01/2018.
 */

public class AccountDatabaseHelper extends SQLiteOpenHelper {
    final String createTableQuery = "create table accounts (id int not null primary key," +
            " username varchar(300) not null, password varchar(300) not null);";

    public AccountDatabaseHelper(Context ctx){
        super(ctx,"accounts.db",null, 0);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int major, int minor){
        onCreate(db);
    }



}
