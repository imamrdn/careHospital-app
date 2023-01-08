package com.example.carehospital_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carehospital_app.R;
import com.example.carehospital_app.model.Data;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;

    public Adapter(Activity activity, List<Data> lists) {
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null && inflater != null) {
            view = inflater.inflate(R.layout.list_pasien, null);
        }

        if (view != null) {
            TextView noAntrian = view.findViewById(R.id.noAntrian);
            TextView nama = view.findViewById(R.id.nama);
            TextView alamat = view.findViewById(R.id.alamat);

            Data data = lists.get(i);
            noAntrian.setText(data.getNoAntrian());
            nama.setText(data.getNama());
            alamat.setText(data.getAlamat());
        }

        return view;

    }
}
