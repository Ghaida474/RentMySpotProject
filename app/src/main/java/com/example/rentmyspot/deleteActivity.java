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

public class deleteActivity extends SigninActivity {
    ListView list;
    ArrayAdapter seatArrayAdapter;
    String username;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);


        list = findViewById(R.id.seatlist);
         username = (String)getIntent().getSerializableExtra("username");
        ShowSeatsOnListView(DB);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Seating clickedSeat =(Seating) seatArrayAdapter.getItem(i);
                DB.DeleteOne(clickedSeat);
                seatArrayAdapter.clear();
                ShowSeatsOnListView(DB);
                Toast.makeText(deleteActivity.this, "Seating Deleted: " + clickedSeat.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ShowSeatsOnListView(DBHelper dataBaseHelper) {
        seatArrayAdapter = new ArrayAdapter<Seating>(deleteActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.SeatingList(username));
        list.setAdapter(seatArrayAdapter);
    }
}