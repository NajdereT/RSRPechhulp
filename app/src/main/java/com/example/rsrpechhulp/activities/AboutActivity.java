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

public class AboutActivity extends AppCompatActivity {
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over__rsr);
        new CheckConnectionClass().Check_Internet_Location(context);
        Toolbar MyToolbar = findViewById(R.id.MyToolbar_ID);
        setSupportActionBar(MyToolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            (Objects.requireNonNull(getSupportActionBar())).setDisplayShowTitleEnabled(false);
        }
        MyToolbar.setTitle("");
    }

    public void BackToMainActivity(View v) {
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // goes back to previous activity
    }
}
