package com.mrudul.gstore;

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

public class Login extends AppCompatActivity {

    private EditText username,password;
    private AppCompatButton loginBtn,cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                //check if the input fields are empty or not
                if (name.isEmpty() || pass.isEmpty()){

                    //display warning
                    Toast.makeText(Login.this,"fill the missing fields",Toast.LENGTH_SHORT).show();
                } else {

                    // logic for login
                    Toast.makeText(Login.this,name,Toast.LENGTH_SHORT).show();
                    Toast.makeText(Login.this,pass,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}