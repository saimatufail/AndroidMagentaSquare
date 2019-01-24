package com.sitpros.retrofitexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText loginPassword,loginEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        loginPassword = findViewById(R.id.loginPassword);
        loginEmail = findViewById(R.id.loginEmail);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObject raw = new JsonObject();
                raw.addProperty("username", loginEmail.getText().toString());
                raw.addProperty("password", loginPassword.getText().toString());
                ApiClient.getWebServices().getLoginUser(raw).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,""+response.body(),Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                          //  Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();

                            intent.putExtra("gettbasicemail", String.valueOf(""+response.body()));

                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
