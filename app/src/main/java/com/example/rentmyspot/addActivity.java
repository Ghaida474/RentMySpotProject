package com.example.rentmyspot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {
    String[] category = {"Weeding","outdoor","business workshops"};
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterCategorys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        autoCompleteTextView = findViewById(R.id.auto_complete_textview);

        adapterCategorys = new ArrayAdapter<String>(this,R.layout.list_item,category);

        autoCompleteTextView.setAdapter(adapterCategorys);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String category = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(addActivity.this,"category "+category , Toast.LENGTH_SHORT).show();

            }
        });

    }
}