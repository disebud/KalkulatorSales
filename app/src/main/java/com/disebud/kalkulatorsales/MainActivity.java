package com.disebud.kalkulatorsales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnHitung;
    EditText etNama,etHarga,etDp,etTenor,etBunga;
    String nama;
    Integer harga,dp,tenor,bunga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHitung = (Button) findViewById(R.id.btnHitung);
        etNama      = (EditText) findViewById(R.id.etNama);
        etHarga     = (EditText) findViewById(R.id.etHargaMotor);
        etDp      = (EditText) findViewById(R.id.etDpMotor);
        etTenor     = (EditText) findViewById(R.id.etTenorMotor);
        etBunga     = (EditText) findViewById(R.id.etBungaMotor);

          btnHitung.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            nama = etNama.getText().toString();
            harga = Integer.parseInt(etHarga.getText().toString());
            dp = Integer.parseInt(etDp.getText().toString());
            tenor = Integer.parseInt(etTenor.getText().toString());
            bunga = Integer.parseInt(etBunga.getText().toString());

            Intent i = new Intent(MainActivity.this,HasilActivity.class);

            if(nama.equals("") || harga.equals("") || dp.equals("") || tenor.equals("") || bunga.equals("")){
                Toast.makeText(MainActivity.this, " Tidak boleh kosong !", Toast.LENGTH_LONG).show();
            }else{
                i.putExtra("nama",nama);
                i.putExtra("harga",harga);
                i.putExtra("dp",dp);
                i.putExtra("tenor",tenor);
                i.putExtra("bunga",bunga);
                startActivity(i);
            }


        }
    });

    }
}