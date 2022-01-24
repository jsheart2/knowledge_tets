package com.knowledge_tets.Model;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.knowledge_tets.Data.listdatauser;

import java.util.ArrayList;
import java.util.List;

public class Listdatahelper {

    private FirebaseDatabase mdatabase;
    private DatabaseReference mreference;
    private List<listdatauser> listdatausers = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<listdatauser> list, List<String> keys);
    }

    public Listdatahelper() {
        mdatabase = FirebaseDatabase.getInstance("https://test-dbfe0-default-rtdb.asia-southeast1.firebasedatabase.app");
        mreference = mdatabase.getReference("Users");
    }

    public void readlist(final DataStatus dataStatus){
        mreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                listdatausers.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : datasnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    listdatauser Listdatauser = keyNode.getValue(listdatauser.class);
                    listdatausers.add(Listdatauser);
                }
                dataStatus.DataIsLoaded(listdatausers,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
