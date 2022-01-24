package com.knowledge_tets.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.knowledge_tets.Data.listdatauser;
import com.knowledge_tets.R;

import java.util.List;

public class Config {
    private Context mContext;
    private ListAdapter mListAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<listdatauser> listdatausers, List<String> keys) {
        mContext = context;
        mListAdapter = new ListAdapter(listdatausers, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mListAdapter);
    }

    class ListDataUser extends RecyclerView.ViewHolder {
        private TextView panjang, mail, phone;
        private String key;

        public ListDataUser(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.listdata, parent, false));

            panjang = itemView.findViewById(R.id.tv_lengkap);
            mail    = itemView.findViewById(R.id.tv_Mail);
            phone   = itemView.findViewById(R.id.tv_no);

        }

        public void bind(listdatauser list, String key){
            panjang.setText(list.getNamalengkap());
            mail.setText(list.getEmail());
            phone.setText(list.getNohp());

            this.key = key;
        }
    }
    class ListAdapter extends RecyclerView.Adapter<ListDataUser>{
        private List<listdatauser> mListUser;
        private List<String> mKeys;

        public ListAdapter(List<listdatauser> mListUser, List<String> mKeys) {
            this.mListUser = mListUser;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ListDataUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ListDataUser(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ListDataUser holder, int position) {
            holder.bind(mListUser.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mListUser.size();
        }
    }
}
