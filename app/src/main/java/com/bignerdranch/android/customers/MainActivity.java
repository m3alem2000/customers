package com.bignerdranch.android.customers;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ArrayList<String> mobileArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        cursor = databaseHelper.getCustomersFullName();

        if (cursor.moveToFirst()) {
            do {
                mobileArray.add(cursor.getString(0) +". "+ cursor.getString(1) + ", " + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        
            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    R.layout.activity_listview, mobileArray);
            final ListView listView = (ListView) findViewById(R.id.customer_list_view);
            listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditCustomer.class);
                int Id = Integer.parseInt(mobileArray.get(position).substring(0, mobileArray.get(position).indexOf(".")));
                intent.putExtra("Id",  Id);
                startActivities(new Intent[]{intent});
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void newCustomer(MenuItem item) {
        Intent intent = new Intent(this, NewCustomer.class);
        startActivity(intent);

    }
}

