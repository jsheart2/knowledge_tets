package com.knowledge_tets.Adapter;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.knowledge_tets.Model.model;
import com.knowledge_tets.R;
import com.knowledge_tets.home.DetailUser;

import java.util.HashMap;
import java.util.Map;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{
    private DetailUser context;
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options, DetailUser context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int i, @NonNull final model model)
    {
        holder.nm_lengkap.setText(model.getNamalengkap());
        holder.nm_panggilan.setText(model.getNamapanggilan());
        holder.hp.setText(model.getNohp());
        holder.Email.setText(model.getEmail());
        holder.jk.setText(model.getJeniskelamin());
        holder.alamat.setText(model.getAlamat());
        holder.pekerjaan.setText(model.getPekerjaan());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPlus dialog = DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(100,100,100,100)
                        .setContentHolder(new ViewHolder(R.layout.content))
                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();

                View holderView = (LinearLayout)dialog.getHolderView();

                EditText nmlengkap     = holderView.findViewById(R.id.nm_lengkap);
                EditText nmpanggilan   = holderView.findViewById(R.id.nm_panggilan);
                EditText phone         = holderView.findViewById(R.id.phonenumber);
                EditText mail          = holderView.findViewById(R.id.mailuser);
                EditText jkuser        = holderView.findViewById(R.id.jkuser);
                EditText alamat        = holderView.findViewById(R.id.alamatuser);
                EditText pekerjanuser = holderView.findViewById(R.id.pekerjaanuser);
                Button   update        = holderView.findViewById(R.id.btnupdate);

                nmlengkap.setText(model.getNamalengkap());
                nmpanggilan.setText(model.getNamapanggilan());
                phone.setText(model.getNohp());
                mail.setText(model.getEmail());
                jkuser.setText(model.getJeniskelamin());
                alamat.setText(model.getAlamat());
                pekerjanuser.setText(model.getPekerjaan());

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("namalengkap", nmlengkap.getText().toString());
                        map.put("namapanggilan", nmpanggilan.getText().toString());
                        map.put("nohp", phone.getText().toString());
                        map.put("email", mail.getText().toString());
                        map.put("jeniskelamin", jkuser.getText().toString());
                        map.put("alamat", alamat.getText().toString());
                        map.put("pekerjaan", pekerjanuser.getText().toString());

                        FirebaseDatabase.getInstance("https://test-dbfe0-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users")
                                .child(getRef(i).getKey())
                                .updateChildren(map)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        dialog.dismiss();
                                    }
                                });
                    }
                });

                dialog.show();
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailuser,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        EditText nm_lengkap, nm_panggilan, hp, Email, jk, alamat, pekerjaan;
        Button btn;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            nm_lengkap   = itemView.findViewById(R.id.edt_Nm_lengkap);
            nm_panggilan = itemView.findViewById(R.id.edt_Nm_panggilan);
            hp           = itemView.findViewById(R.id.edt_NoPhone);
            Email        = itemView.findViewById(R.id.edt_Emailuser);
            jk           = itemView.findViewById(R.id.edt_Kelamin);
            alamat       = itemView.findViewById(R.id.edt_Alamatuser);
            pekerjaan    = itemView.findViewById(R.id.edt_Pekerjaanuser);
            btn          = itemView.findViewById(R.id.btnupdate);
        }
    }

}
