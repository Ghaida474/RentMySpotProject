package com.example.rentmyspot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {
    EditText sname, sprice,Sdescription;
    Button ADD;
    DBHelper DB;
    int y;
    String[] category = {"Weeding","outdoor","business workshops"};
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterCategorys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        sname = findViewById(R.id.sname);
        autoCompleteTextView = findViewById(R.id.auto_complete_textview);
        sprice = findViewById(R.id.Sprice);
        Sdescription = findViewById(R.id.Sdescription);
        ADD = findViewById(R.id.add1);

        DB = new DBHelper(this);
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

        ADD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String nameTXT = sname.getText().toString();
                String scategoryTXT = autoCompleteTextView.getText().toString();
                int spriceTXT = Integer.parseInt(sprice.getText().toString());
                String SdescriptionTXT = Sdescription.getText().toString();

                Seating newseat = new Seating(nameTXT, scategoryTXT, spriceTXT, SdescriptionTXT);


                Boolean checkinsertdata = DB.addSeating(newseat);
                if (checkinsertdata == true)
                    Toast.makeText(addActivity.this, "Seating Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(addActivity.this, "Seating Not Added", Toast.LENGTH_SHORT).show();
            }
        });
    }}




