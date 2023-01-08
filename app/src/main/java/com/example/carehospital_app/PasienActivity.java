package com.example.carehospital_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.carehospital_app.adapter.Adapter;
import com.example.carehospital_app.helper.Helper;
import com.example.carehospital_app.model.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PasienActivity extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> lists = new ArrayList<>();
    Adapter adapter;
    Helper db = new Helper(this);
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasien);

        db = new Helper(getApplicationContext());
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PasienActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.list_item);
        adapter = new Adapter(PasienActivity.this, lists);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String id = lists.get(i).getId();
                final String noAntrian = lists.get(i).getNoAntrian();
                final String nama = lists.get(i).getNama();
                final String alamat = lists.get(i).getAlamat();
                final String keluhan = lists.get(i).getKeluhan();
                final CharSequence[] dialogItem = {"Edit", "Hapus"};

                dialog = new AlertDialog.Builder(PasienActivity.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i) {
                            case 0:
                                Intent intent = new Intent(PasienActivity.this, EditorActivity.class);
                                intent.putExtra("id", id);
                                intent.putExtra("noAntrian", noAntrian);
                                intent.putExtra("nama", nama);
                                intent.putExtra("alamat", alamat);
                                intent.putExtra("keluhan", keluhan);
                                startActivity(intent);
                                break;
                            case 1:
                                db.delete(Integer.parseInt(id));
                                lists.clear();
                                getData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        getData();
    }

    private void getData(){
        ArrayList<HashMap<String, String>> rows = db.getAll();
        for (int i=0; i<rows.size(); i++) {
            String id = rows.get(i).get("id");
            String noAntrian = rows.get(i).get("noAntrian");
            String nama = rows.get(i).get("nama");
            String alamat = rows.get(i).get("alamat");
            String keluhan = rows.get(i).get("keluhan");

            Data data = new Data();
            data.setId(id);
            data.setNoAntrian(noAntrian);
            data.setNama(nama);
            data.setAlamat(alamat);
            data.setKeluhan(keluhan);

            lists.add(data);
        }

        adapter.notifyDataSetChanged();
    }
}