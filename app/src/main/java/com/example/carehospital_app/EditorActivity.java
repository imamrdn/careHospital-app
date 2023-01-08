package com.example.carehospital_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carehospital_app.helper.Helper;

public class EditorActivity extends AppCompatActivity {

    private EditText editNoAntrian, editNama, editAlamat, editKeluhan;
    private Button buttonSave;
    private Helper db = new Helper(this);
    private String id, noAntrian, nama, alamat, keluhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        editNoAntrian = findViewById(R.id.editNoAntrian);
        editNama      = findViewById(R.id.editNama);
        editAlamat = findViewById(R.id.editAlamat);
        editKeluhan = findViewById(R.id.editKeluhan);
        buttonSave = findViewById(R.id.buttonSave);

        id = getIntent().getStringExtra("id");
        noAntrian = getIntent().getStringExtra("noAntrian");
        nama = getIntent().getStringExtra("nama");
        alamat = getIntent().getStringExtra("alamat");
        keluhan = getIntent().getStringExtra("keluhan");

        if (id == null || id.equals("")) {
            setTitle("Tambah Pasien");
        } else {
            setTitle("Edit Pasien");
            editNoAntrian.setText(noAntrian);
            editNama.setText(nama);
            editAlamat.setText(alamat);
            editKeluhan.setText(keluhan);
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (id == null || id.equals("")) {
                            db.insert(
                                    editNoAntrian.getText().toString(),
                                    editNama.getText().toString(),
                                    editAlamat.getText().toString(),
                                    editKeluhan.getText().toString() );
                            finish();
                        } else {
                            db.update(
                                    Integer.parseInt(id),
                                    editNoAntrian.getText().toString(),
                                    editNama.getText().toString(),
                                    editAlamat.getText().toString(),
                                    editKeluhan.getText().toString() );
                            finish();
                        }
                    } catch (Exception e) {
                        Log.e("Saving", e.getMessage());
                    }
                }
            });
        }
    }
}