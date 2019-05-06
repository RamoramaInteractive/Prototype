package com.example.fdai3744.t_online20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private final String USERNAME = "Max.Mustermann";
    private final String PASSWORD = "Max1234";

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.clear();
        editor.apply();

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/century.ttf");

        TextView loginText000 = (TextView) findViewById(R.id.loginText000);
        loginText000.setTypeface(typeface);
        TextView loginText001 = (TextView) findViewById(R.id.loginText001);
        loginText001.setTypeface(typeface);
        TextView loginText002 = (TextView) findViewById(R.id.loginText002);
        loginText002.setTypeface(typeface);
        TextView loginText003 = (TextView) findViewById(R.id.loginText003);
        loginText003.setTypeface(typeface);
        TextView loginText004 = (TextView) findViewById(R.id.loginText004);
        loginText004.setTypeface(typeface);
        TextView loginText005 = (TextView) findViewById(R.id.loginText005);
        loginText005.setTypeface(typeface);
        TextView loginText006 = (TextView) findViewById(R.id.loginText006);
        loginText006.setTypeface(typeface);
        TextView loginText007 = (TextView) findViewById(R.id.loginText007);
        loginText007.setTypeface(typeface);
        TextView loginText008 = (TextView) findViewById(R.id.loginText008);
        loginText008.setTypeface(typeface);


        //tv.setTypeface(typeface);

        username = (EditText) findViewById(R.id.name_login);
        username.setTypeface(typeface);
        password = (EditText) findViewById(R.id.password_login);
        password.setTypeface(typeface);

        final Button login = (Button) findViewById(R.id.login);
        login.setTypeface(typeface);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startApp(v);
            }
        });
    }

    public void startApp(View v)
    {
        if (String.valueOf(username.getText()).equals(USERNAME) &&
            String.valueOf(password.getText()).equals(PASSWORD)) {
            Intent intent = new Intent(this, SecondActivity.class);
            this.startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Benutzername oder Passwort stimmen nicht überein.", Toast.LENGTH_LONG).show();
        }
    }
}
