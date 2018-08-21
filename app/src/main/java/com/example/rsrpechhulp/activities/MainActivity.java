package com.example.rsrpechhulp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rsrpechhulp.R;
import com.example.rsrpechhulp.connection_class.CheckConnectionClass;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar MyToolbar = findViewById(R.id.MyToolbar_ID);
        setSupportActionBar(MyToolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            (Objects.requireNonNull(getSupportActionBar())).setDisplayShowTitleEnabled(false);
        }
        MyToolbar.setTitle("");
        new CheckConnectionClass().Check_Internet_Location(context);//here it checks if you are connected to internet or have tour location turned on
        setSupportActionBar(MyToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }

    }

    //starts the About Activty//
    public void ToAboutRSRActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
        finish();
    }
    //starts the Maps Activty//

    public void ToMapsActivity(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
        finish();
    }
}
