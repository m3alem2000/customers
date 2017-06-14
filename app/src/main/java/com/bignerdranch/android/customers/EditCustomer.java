package com.bignerdranch.android.customers;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class EditCustomer extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Intent intent;
    long Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_customer);
        addItemsOnSpinner();

            intent = getIntent();
            Id = Long.parseLong(intent.getExtras().get("Id").toString());
            databaseHelper = new DatabaseHelper(this);
            Cursor cursor = databaseHelper.getCustomerById(Id);
            if(cursor.moveToFirst()){
                String i_fname = cursor.getString(1);
                String i_name = cursor.getString(2);
                String i_email = cursor.getString(3);
                String i_tel = cursor.getString(4);
                String i_tel_type = cursor.getString(5);
                String i_address = cursor.getString(6);
                String i_city = cursor.getString(7);
                String i_state = cursor.getString(8);
                String i_zip = cursor.getString(9);


                EditText fname = (EditText) findViewById(R.id.fname);
                EditText lname = (EditText) findViewById(R.id.lname);
                EditText email = (EditText) findViewById(R.id.email);
                EditText tel = (EditText) findViewById(R.id.tel);
                Spinner mySpinner = (Spinner) findViewById(R.id.tel_type);
                EditText address = (EditText) findViewById(R.id.address);
                EditText city = (EditText) findViewById(R.id.city);
                EditText state = (EditText) findViewById(R.id.state);
                EditText zip = (EditText) findViewById(R.id.zip_code);

                fname.setText(i_fname);
                lname.setText(i_name);
                email.setText(i_email);
                tel.setText(i_tel);
                mySpinner.setSelection(((ArrayAdapter<String>)mySpinner.getAdapter()).getPosition(i_tel_type));
                address.setText(i_address);
                city.setText(i_city);
                state.setText(i_state);
                zip.setText(i_zip);
            }
    }

    public void editCustomer(View view) {
        EditText fname = (EditText) findViewById(R.id.fname);
        EditText lname = (EditText) findViewById(R.id.lname);
        EditText email = (EditText) findViewById(R.id.email);
        EditText tel = (EditText) findViewById(R.id.tel);
        Spinner spinner = (Spinner) findViewById(R.id.tel_type);
        String tel_type = spinner.getSelectedItem().toString();
        EditText address = (EditText) findViewById(R.id.address);
        EditText city = (EditText) findViewById(R.id.city);
        EditText state = (EditText) findViewById(R.id.state);
        EditText zip = (EditText) findViewById(R.id.zip_code);
        Customer customer = new Customer((int) Id, fname.getText().toString(), lname.getText().toString(),
                email.getText().toString(), tel.getText().toString(), tel_type,
                address.getText().toString(), city.getText().toString(),
                state.getText().toString(), zip.getText().toString());

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.editCustomerCommit(customer);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void addItemsOnSpinner() {

        Spinner tel_type = (Spinner) findViewById(R.id.tel_type);
        List<String> list = new ArrayList<String>();
        list.add("Mobile");
        list.add("Home");
        list.add("Office");
        list.add("Misc");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tel_type.setAdapter(dataAdapter);
    }
}