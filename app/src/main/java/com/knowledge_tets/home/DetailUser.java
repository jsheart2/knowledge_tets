package com.knowledge_tets.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.knowledge_tets.Adapter.myadapter;
import com.knowledge_tets.Model.model;
import com.knowledge_tets.R;

public class DetailUser extends AppCompatActivity {

    RecyclerView recview;
    myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance("https://test-dbfe0-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Users"), model.class)
                        .build();
        myadapter = new myadapter(options,this);
        recview.setAdapter(myadapter);

    }


    @Override
    protected void onStart(){
        super.onStart();
        myadapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        myadapter.stopListening();
    }

    public void kembali(View view){
        startActivity(new Intent(getApplicationContext(), Home.class));
    }

    public void update(View view){

    }

}