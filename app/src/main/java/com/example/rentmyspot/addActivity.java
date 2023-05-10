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
import java.io.Serializable;

public class addActivity extends SigninActivity implements Serializable {
    EditText Sname ,Sprice, Sdescription;
    Button add1;
    String category;
    String[] categorys = {"Weeding","outdoor","business workshops"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterCategorys;
    Seating newSeating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        autoCompleteTextView = findViewById(R.id.auto_complete_textview);
        Sname = findViewById(R.id.Sname);
        Sprice = findViewById(R.id.Sprice);
        Sdescription = findViewById(R.id.Sdescription);
        add1 = findViewById(R.id.add1);
        adapterCategorys = new ArrayAdapter<String>(this,R.layout.list_item, categorys);
        autoCompleteTextView.setAdapter(adapterCategorys);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                category = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(addActivity.this,"category "+category , Toast.LENGTH_SHORT).show();
            }
        });

        add1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String username = (String)getIntent().getSerializableExtra("username");
                    newSeating = new Seating ( username, Sname.getText().toString(), category, Integer.parseInt(Sprice.getText().toString()), Sdescription.getText().toString());
                    Toast.makeText(addActivity.this, newSeating.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(addActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                    newSeating = new Seating("-" , "-1", "ERROR", 0 , "-");
                }
                boolean b = DB.addSeating(newSeating);
                Toast.makeText(addActivity.this, "added "+b, Toast.LENGTH_SHORT).show();
            }
        });
    }
}