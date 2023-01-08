package com.example.carehospital_app.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "rumahsakit";

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE pasien (" +
                " id INTEGER PRIMARY KEY autoincrement," +
                " noAntrian TEXT not null," +
                " nama TEXT not null," +
                " alamat TEXT not null," +
                " keluhan TEXT not null )";

        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pasien");
    }

    public ArrayList<HashMap<String, String>> getAll(){
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String QUERY = "SELECT * FROM pasien";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("noAntrian", cursor.getString(1));
                map.put("nama", cursor.getString(2));
                map.put("alamat", cursor.getString(3));
                map.put("keluhan", cursor.getString(4));
                list.add(map);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void insert(String noAntrian, String nama, String alamat, String keluhan) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "INSERT INTO pasien (noAntrian, nama, jenisKelamin, tempatLahir, tanggalLahir, alamat, keluhan) VALUES ('"+noAntrian+"', '"+nama+"','"+alamat+"','"+keluhan+"')";

        database.execSQL(QUERY);
    }

    public void update(int id, String noAntrian, String nama, String alamat, String keluhan) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "UPDATE pasien SET noAntrian='"+noAntrian+"', nama='"+nama+"', alamat='"+alamat+"', keluhan='"+keluhan+"' ";
        database.execSQL(QUERY);
    }

    public void delete (int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "DELETE FROM pasien WHERE id = "+id;
        database.execSQL(QUERY);
    }


}
