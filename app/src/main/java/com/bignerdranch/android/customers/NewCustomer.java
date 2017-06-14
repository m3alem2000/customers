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

public class NewCustomer extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Intent intent;
    String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_customer);
        addItemsOnSpinner();
    }

    public void newCustomer(View view) {
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
            Customer customer = new Customer(fname.getText().toString(), lname.getText().toString(),
                    email.getText().toString(), tel.getText().toString(), tel_type,
                    address.getText().toString(), city.getText().toString(),
                    state.getText().toString(), zip.getText().toString());

            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            boolean status = databaseHelper.addCustomer(customer);
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