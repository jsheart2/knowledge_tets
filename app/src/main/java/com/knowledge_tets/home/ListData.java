package com.knowledge_tets.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.knowledge_tets.Data.listdatauser;
import com.knowledge_tets.Model.Config;
import com.knowledge_tets.Model.Listdatahelper;
import com.knowledge_tets.R;

import java.util.List;

public class ListData extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        mRecyclerView = findViewById(R.id.recyclerview_listdata);


        new Listdatahelper().readlist(new Listdatahelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<listdatauser> list, List<String> keys) {
                new Config().setConfig(mRecyclerView, ListData.this, list, keys);
            }
        });
    }

    public void Back(View view){
        startActivity(new Intent(getApplicationContext(), Home.class));
    }
}