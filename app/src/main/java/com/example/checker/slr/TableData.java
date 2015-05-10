package com.example.checker.slr;

/**
 * Created by 3542 on 20/04/2015.
 */
import android.provider.BaseColumns;

public class TableData {
    public TableData(){

    }
    public static abstract class TableInfo implements BaseColumns{
        public static final String USER_NAME = "user_name";
        public static final String PASSWORD = "password";
        public static final String DATABASE_NAME = "checker_info.db";
        public static final String TABLE_NAME = "sign_in_info";
    }
}

