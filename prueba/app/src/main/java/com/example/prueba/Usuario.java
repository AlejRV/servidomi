package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Usuario extends AppCompatActivity {


    TextView tvNombre, tvUsuario, tvEmail, tvPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usuario);

        tvNombre = findViewById(R.id.tv_nom2);
        tvUsuario = findViewById(R.id.tv_user2);
        tvEmail = findViewById(R.id.tv_email2);
        tvPassword = findViewById(R.id.tv_pass2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");

        tvNombre.setText(name);
       tvUsuario.setText(username);
       tvEmail.setText(email);
       tvPassword.setText(password);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}