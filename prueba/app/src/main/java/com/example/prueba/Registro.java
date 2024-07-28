package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText etnom, etuser, etemail, etpass;
    Button bt_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        etnom= findViewById((R.id.tv_nombre));
        etuser= findViewById(R.id.tv_usuario);
        etemail= findViewById(R.id.tv_email);
        etpass= findViewById(R.id.tv_password);

        bt_reg = findViewById(R.id.bt_reg);

        bt_reg.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        final String name=etnom.getText().toString();
        final String username=etuser.getText().toString();
        final String email=etemail.getText().toString();
        final String password=etpass.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean SUCCESS= jsonResponse.getBoolean("SUCCESS");

                    if (SUCCESS){
                        Intent intent= new Intent(Registro.this, MainActivity.class);
                        Registro.this.startActivity(intent);

                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("error en el registro")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        };

    RegisterRequest registerRequest= new RegisterRequest(name, username, email, password, respoListener);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);
    }
}