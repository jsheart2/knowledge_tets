package com.knowledge_tets.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.knowledge_tets.Data.Create;
import com.knowledge_tets.R;


public class CreateUser extends AppCompatActivity {

    EditText NamaLengkap, NamaPanggilan, Number, Email, JenisKelamin, AlamatUser, PekerjaanUser;
    Button btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        NamaLengkap = findViewById(R.id.edt_NamaLengkap);
        NamaPanggilan = findViewById(R.id.edt_NamaPanggilan);
        Number = findViewById(R.id.edt_Number);
        Email = findViewById(R.id.edt_email);
        JenisKelamin = findViewById(R.id.edt_JenisKelamin);
        AlamatUser = findViewById(R.id.edt_Alamat);
        PekerjaanUser = findViewById(R.id.edt_Pekerjaan);
        btn = findViewById(R.id.btn_create);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance("https://test-dbfe0-default-rtdb.asia-southeast1.firebasedatabase.app");
                reference = rootNode.getReference("Users");

                Toast.makeText(CreateUser.this,"Data Sudah Di Input ke data base", Toast.LENGTH_SHORT).show();

                //Mendapatkan semua values
                String Nama_Lengkap   = NamaLengkap.getText().toString();
                String Nama_Panggilan = NamaPanggilan.getText().toString();
                String Number_Phone   = Number.getText().toString();
                String Email_User     = Email.getText().toString();
                String Jenis_Kelamin  = JenisKelamin.getText().toString();
                String Alamat         = AlamatUser.getText().toString();
                String Pekerjaan      = PekerjaanUser.getText().toString();

                Create create = new Create(Nama_Lengkap, Nama_Panggilan, Number_Phone, Email_User, Jenis_Kelamin, Alamat, Pekerjaan);

                reference.child(Nama_Lengkap).setValue(create);
            }
        });
    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), Home.class));
    }
}