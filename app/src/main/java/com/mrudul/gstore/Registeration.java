package com.mrudul.gstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registeration extends AppCompatActivity {

    private EditText username,password;
    private AppCompatButton registerBtn,rCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registeration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        username = findViewById(R.id.r_username);
        password = findViewById(R.id.r_password);
        registerBtn = findViewById(R.id.registerBtn);
        rCancelBtn = findViewById(R.id.rCancelBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if field is empty or not
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (name.isEmpty() || pass.isEmpty()){
                    //display warning
                    Toast.makeText(Registeration.this,"fill the missing fields",Toast.LENGTH_SHORT).show();

                } else {
                    //logic for registeration of new user and navigate to main activity.
                    Toast.makeText(Registeration.this,name,Toast.LENGTH_SHORT).show();
                    Toast.makeText(Registeration.this,pass,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Registeration.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        rCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}