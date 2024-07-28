package com.example.prueba;

import android.hardware.biometrics.BiometricManager;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private  static  final  String LOGIN_REQUEST_URL="https://168.192.1.124/Login.php";  /*http://localhost/Register.php-----http://168.192.1.124/Register.php*/
    private Map<String,String> params;
    public LoginRequest(String username,String password, Response.Listener<String> listener){
        super (Request.Method.POST, LOGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();

        params.put("username",username);
        params.put("password",password);

    }

    @Nullable
    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
