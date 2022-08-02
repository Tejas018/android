package com.example.ongcclaim;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "Userdata.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails (CPFNumber TEXT primary key , name TEXT , NomineeID TEXT , Phone TEXT , Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
DB.execSQL("drop table if exists UserDetails");
    }

    public Boolean insertuserdata (String CPFNumber , String name , String NomineeID , String Phone ,  String Password ) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CPFNumber" , CPFNumber);
        contentValues.put("name" , name);
        contentValues.put("NomineeID" , NomineeID);
        contentValues.put("Phone" , Phone);
        contentValues.put("Password" , Password);

        long result = DB.insert("Userdetails" , null , contentValues);
        if(result == -1)
        {
            return false;

        }
        else
        {
            return true;
        }
    }


}
