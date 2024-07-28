package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Response;

public class MainActivity extends AppCompatActivity {
TextView tv_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


     /*
        et_usuario= (TextView) findViewById(R.id.TV_usu);
        et.password= (TextView) findViewById(R.id.TV_pas)

       */
        tv_registrar= (TextView) findViewById(R.id.tv_registrar);
/*
        btn_log= (Button) findViewById(R.id,Btn_iniciar);
*/
        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intenReg);
            }
        });
/*
        btn_log.setOnClickListener(new  View.OnClickListener() {
           @Override
           public void onClick(View view) {

               final String username= et_user.getText().toString();
               final String password= et_pass.getText().toString();

               Response.Listener<String> listener= new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                String name = jsonResponse.getString("name");
                               String  email = jsonResponse.getString("email");

                               Intent intent = new Intent(MainActivity.this, Usuario.class);

                               Intent.putExtra("name", name);
                              Intent.putExtra("username", username);
                              Intent.putExtra("email", email);
                              Intent.putExtra("password", password);

                              MainActivity.this.starActivity(intent);

                            }else{
                           AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("error, datos no encontrados...")
                                .setNegativeButton("Retry",null)
                                .create().show();
                            }

                    }   catch (JSONException e){
                                e.printStackTrace();
                    }
               }
};

               LoginRequest loginRequest= new LoginRequest(username, password, responseListener);

           RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(loginRequest);

           }
        });*/


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}