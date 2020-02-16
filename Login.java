package com.collanomics.android.rajit_wmscustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.collanomics.android.rajit_wmscustomer.api.RetrofitClient;
import com.collanomics.android.rajit_wmscustomer.models.LoginResponse;

import org.json.JSONException;
import org.json.JSONObject;


import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static retrofit2.Response.success;

public class LogIn extends AppCompatActivity  {

    private static final String TAG = "LogIn";

    EditText  etemail, etpassword, eturl;
    Button b1;
  //  String email, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        etemail = findViewById(R.id.ed1);
        etpassword = findViewById(R.id.ed2);
        eturl = findViewById(R.id.ed3);


     //   email = etemail.getText().toString();
     //   url = eturl.getText().toString();


        b1 = findViewById(R.id.b1);

      /*  b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
              //  saveData(email,url);
            }
        });
    }*/

   b1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

           Log.d(TAG, "onFailure: ");

        String email = etemail.getText().toString().trim();
        String password = etpassword.getText().toString().trim();
        String url = eturl.getText().toString().trim();


        Call<LoginResponse> call = RetrofitClient
                .getInstance().getApi().login(email,password,url);
           Log.d(TAG, "onFailure: ");

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                Log.d(TAG, "onFailure: ");

                if(loginResponse==success){

                    Log.d(TAG, "onFailure: ");
                    Intent i = new Intent(LogIn.this,ThankYou_Mottainai.class);
                    startActivity(i);
                }
               else {
                    Toast.makeText(LogIn.this, "Else",Toast.LENGTH_LONG).show();
               }
            }



            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Toast.makeText(LogIn.this,"Error",Toast.LENGTH_LONG).show();

                Log.d(TAG, "onFailure: ");

            }
        });

       }
   });

    }


}





