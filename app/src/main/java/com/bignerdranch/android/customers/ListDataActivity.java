//package com.bignerdranch.android.customers;
//
//import android.database.Cursor;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//    public class ListDataActivity extends AppCompatActivity {
//        DatabaseHelper databaseHelper;
//        private ListView mListView;
////    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
////            "WebOS","Ubuntu","Windows7","Max OS X"};
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_listview);
//
//            mListView = (ListView) findViewById(R.id.mobile_list);
//            databaseHelper = new DatabaseHelper(this);
//            populateListView();
//        }
//
//        public void populateListView() {
//            Cursor cursor = databaseHelper.readCustomerFullName();
//            ArrayList <String> listData = new ArrayList<>();
//            if(cursor.moveToFirst()) {
//                do {
//                    listData.add(cursor.getString(1));
//                    Log.i("cursor ", cursor.getString(1));
//                }while(cursor.moveToNext());
//            }
//                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
//                mListView.setAdapter(listAdapter);
//
//            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
////                    String name = adapterView.getItemIdAtPosition(position);
//                }
//            });
//        }
//    }
////        ArrayAdapter adapter = new ArrayAdapter<String>(this,
////                R.layout.activity_listview, mobileArray);
////
////        ListView listView = (ListView) findViewById(R.id.mobile_list);
////        listView.setAdapter(adapter);
