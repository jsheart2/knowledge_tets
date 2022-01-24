package com.knowledge_tets.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.knowledge_tets.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void create_user(View view) {
        startActivity(new Intent(getApplicationContext(), CreateUser.class));
        finish();
    }

    public void list_data(View view) {
        startActivity(new Intent(getApplicationContext(), ListData.class));
        finish();
    }

    public void detail_user(View view) {
        startActivity(new Intent(getApplicationContext(), DetailUser.class));
        finish();
    }
}