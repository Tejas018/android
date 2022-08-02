package com.example.ongcclaim;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper2 extends SQLiteOpenHelper {
    public DBHelper2(@Nullable Context context) {
        super(context, "GeneralDetails" , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB2) {
        DB2.execSQL("create Table GeneralDetails (CPFNumber primary key , designation TEXT , name TEXT , husbandname TEXT , dateofjoining TEXT , doc TEXT , ofc TEXT , accountno TEXT , ifsc TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB2, int i, int i1) {
        DB2.execSQL("drop table if exists GeneralDetails");
    }

    public Boolean insert (String CPFNumber ,String designation, String name , String hushbandname , String dateofjoining ,  String doc , String ofc , String accountno , String ifsc ) {
        SQLiteDatabase DB2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CPFNumber" , CPFNumber);
        contentValues.put("designation" , designation);
        contentValues.put("name" , name);
        contentValues.put("Husband Name" , hushbandname);
        contentValues.put("Date of joining" , dateofjoining);
        contentValues.put("DOC" , doc);
        contentValues.put("OFC" , ofc);
        contentValues.put("Account number" , accountno);
        contentValues.put("IFSC Code" , ifsc);


        long result = DB2.insert("GeneralDetails" , null , contentValues);
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
