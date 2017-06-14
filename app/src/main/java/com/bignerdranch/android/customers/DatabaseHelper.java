package com.bignerdranch.android.customers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;

    private static final int DATABASE_VERSION = 3;
    private static final String DB_NAME = "customersDB";
    public static final String DB_TABLE_NAME = "customers";

    // Contacts Table Columns names
    public static final String ID = "id";
    public static final String FNAME = "first_name";
    public static final String LNAME = "last_name";
    public static final String EMAIL = "email";
    public static final String TEL = "tel";
    public static final String TEL_TYPE = "tel_type";
    public static final String ADDRESS = "address";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ZIP_CODE = "zip_code";

    private static final String DB_TABLE_CREATE =
            "Create Table if not exists " + DB_TABLE_NAME + " (" + ID + " Integer primary key autoincrement, " +
                    FNAME + " VarChar, " + LNAME + " VarChar, " + EMAIL + " VarChar, " + TEL +" VarChar, " +
                    TEL_TYPE + " VarChar, " + ADDRESS +" VarChar, " + CITY +" VarChar, " + STATE + " VarChar(2), " + ZIP_CODE +" int(5))";

    private static final String DB_TABLE_POPULATE = "Insert into " + DB_TABLE_NAME + " (" + FNAME + ", " + LNAME + ", " + EMAIL + ", " +
            TEL + ", " + TEL_TYPE + ", " + ADDRESS + ", " + CITY + ", " + STATE +", " + ZIP_CODE +") values ('Mohammad','Ramadan'," +
            "'m3alem@hotmail.com','614 705-5920','Work','123 Columbus Way','Columbus','OH','43016')";

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    // Create Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DB_TABLE_CREATE);
        db.execSQL(DB_TABLE_POPULATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public boolean addCustomer(Customer customer) {

        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();   // storage key/value pairs
        values.put(FNAME, customer.getFname());
        values.put(LNAME, customer.getLname());
        values.put(EMAIL, customer.getEmail());
        values.put(TEL, customer.getTel());
        values.put(TEL_TYPE, customer.getTel_type());
        values.put(ADDRESS, customer.getAddress());
        values.put(STATE, customer.getState());
        values.put(CITY, customer.getCity());
        values.put(ZIP_CODE, customer.getZip());
        long result = sqLiteDatabase.insert(DB_TABLE_NAME, null, values);
        if(result ==  -1){
            return false;
        }else {
            return true;
        }
    }

    public void editCustomerCommit(Customer customer) {

        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();   // storage key/value pairs
        values.put(FNAME, customer.getFname());
        values.put(LNAME, customer.getLname());
        values.put(EMAIL, customer.getEmail());
        values.put(TEL, customer.getTel());
        values.put(TEL_TYPE, customer.getTel_type());
        values.put(ADDRESS, customer.getAddress());
        values.put(STATE, customer.getState());
        values.put(CITY, customer.getCity());
        values.put(ZIP_CODE, customer.getZip());
        sqLiteDatabase.update(DB_TABLE_NAME, values, ID +" = " + customer.getId(), null);
        }

    protected Cursor getCustomersFullName() {
        sqLiteDatabase = this.getReadableDatabase();
        String DBQuery = "select " + ID +", " + LNAME + ", " + FNAME + " from " + DB_TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(DBQuery, null);
        return cursor;
    }

    protected Cursor getCustomerById(long Id ){
        sqLiteDatabase = this.getReadableDatabase();
        String DBQuery = "select * from " + DB_TABLE_NAME + " where  " + ID +" = " + Id;
        Cursor cursor = sqLiteDatabase.rawQuery(DBQuery, null);
        return cursor;
    }
}