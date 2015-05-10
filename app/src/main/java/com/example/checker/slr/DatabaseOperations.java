package com.example.checker.slr;

/**
 * Created by 3542 on 01/04/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;

    public String CREATE_QUERY = "CREATE TABLE sign_in_info (user_name TEXT ,password TEXT)";

    public DatabaseOperations(Context context){
        //  super(context,name,factory,version);
        super(context, "checker_info.db",null,1);
        Log.d("Database operations", "Database created");
    }
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations" , "Table created");
    }
    public void onUpgrade(SQLiteDatabase arg0 , int arg1 ,int arg2){

    }

    public void putInformation(DatabaseOperations dop ,String user_name ,String password){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME ,user_name);
        cv.put(TableData.TableInfo.PASSWORD , password);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations" , "One row inserted");
    }
}

