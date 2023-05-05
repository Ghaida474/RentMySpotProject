package com.example.rentmyspot;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    EditText username, password;
    Button signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

            username = findViewById(R.id.username1);
            password = findViewById(R.id.password1);
            signin = findViewById(R.id.signin1);
            DB = new DBHelper(this);

            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    if(user.equals("")||pass.equals(""))
                        Toast.makeText(SigninActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    else{
                        Boolean checkUser = DB.checkUsername(user);
                        if(!checkUser){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert){
                                Toast.makeText(SigninActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomepageActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SigninActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SigninActivity.this,"Already exists! please log in",Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            });

        }
    }
