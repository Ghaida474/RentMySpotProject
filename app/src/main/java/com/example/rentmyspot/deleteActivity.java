package com.example.rentmyspot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class deleteActivity extends AppCompatActivity {
    EditText name;

    ListView list;
    Button btn_view;
    DBHelper db;
    ArrayAdapter seatArrayAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        name= findViewById(R.id.usernamedelete);
        btn_view = findViewById(R.id.btn_view);
        list=findViewById(R.id.seatlist);
        db = new DBHelper(this);
        ShowSeatsOnListView(db);
        btn_view.setOnClickListener( new View.OnClickListener() {

            public void onClick(View v){
                db = new DBHelper(deleteActivity.this);
                ShowSeatsOnListView(db);

            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Seating clickedSeat =(Seating) seatArrayAdapter.getItem(i);
                db.DeleteOne(clickedSeat);
                seatArrayAdapter.clear();
                ShowSeatsOnListView(db);
                Toast.makeText(deleteActivity.this, "Seating Deleted: " + clickedSeat.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }






    private void ShowSeatsOnListView(DBHelper dataBaseHelper) {
        seatArrayAdapter = new ArrayAdapter<Seating>(deleteActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.SeatingList(name.getText().toString()));
        list.setAdapter(seatArrayAdapter);
    }


}