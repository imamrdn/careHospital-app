package com.example.carehospital_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carehospital_app.Model.HospitalDataModel;
import com.example.carehospital_app.R;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HolderData> {
    private Context context;
    private List<HospitalDataModel> rumahsakit;

    public HospitalAdapter(Context context, List<HospitalDataModel> rumahsakit) {
        this.context = context;
        this.rumahsakit = rumahsakit;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_hospital, parent, false);
        HolderData holder = new HolderData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        HospitalDataModel dm = rumahsakit.get(position);

        holder.textId.setText(String.valueOf(dm.getId()));
        holder.textNama.setText(dm.getNama());
        holder.textAlamat.setText(dm.getAlamat());
        holder.textKota.setText(dm.getKota());
    }

    @Override
    public int getItemCount() {
        return rumahsakit.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView textId, textNama, textAlamat, textKota;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            textId = itemView.findViewById(R.id.id_rumahsakit);
            textNama = itemView.findViewById(R.id.nama_rumahsakit);
            textAlamat = itemView.findViewById(R.id.alamat_rumahsakit);
            textKota = itemView.findViewById(R.id.kota_rumahsakit);
        }
    }
}
