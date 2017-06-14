package com.bignerdranch.android.customers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class DbOperations {

    private DatabaseHelper dbHelper;

    public DbOperations(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Add a new customer in the DB
    public void addCustomer(Customer customer) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();   // storage key/value pairs
        values.put(dbHelper.FNAME, customer.getFname());
        values.put(dbHelper.LNAME, customer.getLname());
        values.put(dbHelper.EMAIL, customer.getEmail());
        values.put(dbHelper.TEL, customer.getTel());
        values.put(dbHelper.TEL_TYPE, customer.getTel_type());
        values.put(dbHelper.ADDRESS, customer.getAddress());
        values.put(dbHelper.STATE, customer.getState());
        values.put(dbHelper.CITY, customer.getCity());
        values.put(dbHelper.ZIP_CODE, customer.getZip());
        db.insert(dbHelper.DB_TABLE_NAME, null, values);

        db.close();
    }

    protected String[] readCustomerFullName() {
        String getAllCustomers = "select " + dbHelper.FNAME + ", " + dbHelper.LNAME + " from " + dbHelper.DB_TABLE_NAME;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from customers", null);
//        Cursor cursor = db.rawQuery(getAllCustomers, null);
        String[] contactList = new String[cursor.getColumnCount()];
        try {
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    do {
                        String name = "";
                        name = cursor.getString(2) + ", " + cursor.getString(3);
                        contactList[i] = name;
                        i++;
                    } while (cursor.moveToNext());

                    db.close();
                }
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } finally {
            if (db != null)
                db.execSQL("DELETE FROM " + dbHelper.DB_TABLE_NAME);
            db.close();
        }return contactList;
    }
}




//    private void openAndQueryDatabase() {
//        try {
//            DBHelper dbHelper = new DBHelper(this.getApplicationContext());
//            newDB = dbHelper.getWritableDatabase();
//            Cursor c = newDB.rawQuery("SELECT FirstName, Age FROM " +
//                    tableName +
//                    " where Age > 10 LIMIT 4", null);
//
//            if (c != null ) {
//                if (c.moveToFirst()) {
//                    do {
//                        String firstName = c.getString(c.getColumnIndex("FirstName"));
//                        int age = c.getInt(c.getColumnIndex("Age"));
//                        results.add("Name: " + firstName + ",Age: " + age);
//                    }while (c.moveToNext());
//                }
//            }
//        } catch (SQLiteException se ) {
//            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
//        } finally {
//            if (newDB != null)
//                newDB.execSQL("DELETE FROM " + tableName);
//            newDB.close();
//        }