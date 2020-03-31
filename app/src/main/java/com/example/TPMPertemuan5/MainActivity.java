package com.example.TPMPertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.TPMPertemuan5.Database.AppDataBase;
import com.example.TPMPertemuan5.Database.DataDiri;

public class MainActivity extends AppCompatActivity {
    private AppDataBase appDatabase;
    private EditText etNama,etAlamat,etJK;
    private Button bSubmit,bRead;
    private Button btnInput,btnTampilkan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase= AppDataBase.initDb(getApplicationContext());
        etNama= findViewById(R.id.etNama);
        etAlamat= findViewById(R.id.etAlamat);
        etJK= findViewById(R.id.etJK);
        btnInput= findViewById(R.id.btnInput);
        btnTampilkan= findViewById(R.id.btnTampilkan);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
    });

        btnTampilkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextReadActivity();
            }
        });
    }
    private void insertData()
    {
        String nama= etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        char jk= etJK.getText().toString().charAt(0);



        DataDiri item = new DataDiri();
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJk(jk);

        appDatabase.dao().insertData(item);

        etNama.setText("");
        etAlamat.setText("");
        etJK.setText("");
    }

    public void nextReadActivity(){
        Intent intent = new Intent(this,ReadActivity.class);
        this.startActivity(intent);
    }
}
