package com.example.android.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView list; //create a simple reference
    //define the data source
    String[] days = {"Monday", "Tuesday","Wednesdey","Thrusday","Friday","Saturday","Sunday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.ListView); //bring a view from XML to java. typecast
        //ArrayAdapter reads data from an array and convert it into a single view
        //parameters: context, layout type, the array itself
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        list.setAdapter(adapter); //adapter is responsible for fetching the data
        //we need an event handler (OnItemClickListener)
        list.setOnItemClickListener(this);
    }

    @Override
    //parameters: listview Clicked, the row clicked(textview contains it's reference), position, id of textview
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       TextView temp = (TextView) view;
        Toast.makeText(this, temp.getText()+" "+ position, Toast.LENGTH_SHORT).show();
    }
}
