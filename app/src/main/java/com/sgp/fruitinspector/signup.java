package com.sgp.fruitinspector;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class signup extends AppCompatActivity {
    EditText name,email,password,phone;
    Button signUp;
    TextView skip2;
    //FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.appbar_layout);
        name = findViewById(R.id.Name);
        email= findViewById(R.id.EmailAddress2);
        phone = findViewById(R.id.Phone);
        password = findViewById(R.id.Password2);
        //fAuth = FirebaseAuth.getInstance();
        signUp = findViewById(R.id.signup1);
        skip2 = findViewById(R.id.skip2);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rname = name.getText().toString().trim();
                String remail = email.getText().toString().trim();
                String rphone = phone.getText().toString().trim();
                String rpassword = password.getText().toString().trim();
            }
        });
        skip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CaptureImage.class);
                startActivity(intent);
            }
        });
    }
}