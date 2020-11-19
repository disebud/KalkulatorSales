package com.disebud.kalkulatorsales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class HasilActivity extends AppCompatActivity {

    TextView tvNama,tvHarga,tvDp,tvPokokHutang,tvBunga,tvTotalHutang,tvTotalAngsuran;
    String nama;
    Integer harga,dp,tenor,bunga,pokokHutang,totalHutang,totalBunga,totalAngsuran,totalDp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        tvNama = (TextView) findViewById(R.id.tvNama);
        tvHarga = (TextView) findViewById(R.id.tvHargaMotor);
        tvDp = (TextView) findViewById(R.id.tvDpMotor);
        tvPokokHutang = (TextView) findViewById(R.id.tvPokokUtang);
        tvBunga = (TextView) findViewById(R.id.tvTotalBunga);
        tvTotalHutang = (TextView) findViewById(R.id.tvTotalHutang);
        tvTotalAngsuran = (TextView) findViewById(R.id.tvTotalAngsuran);





        NumberFormat nf = NumberFormat.getInstance(new Locale("in","ID"));

        nama = getIntent().getStringExtra("nama");
        tvNama.setText(nama);

        harga = getIntent().getIntExtra("harga",0);
        String hargaMotor = "Rp." + nf.format(harga);
        tvHarga.setText(hargaMotor);

        dp = getIntent().getIntExtra("dp",0);
        totalDp = harga * dp/100 ;
        String totalDpRp = "Rp." + nf.format(totalDp);
        tvDp.setText(totalDpRp);

        tenor = getIntent().getIntExtra("tenor",0);
        pokokHutang = harga - totalDp ;
        String pokokHutangRp = "Rp." + nf.format(pokokHutang);
        tvPokokHutang.setText(pokokHutangRp);

        bunga = getIntent().getIntExtra("bunga",0);
        totalBunga =  tenor * bunga * pokokHutang /100;
        String totalBungaRp = "Rp." + nf.format(totalBunga);
        tvBunga.setText(totalBungaRp);

        totalHutang = pokokHutang + totalBunga ;
        String totalHutangRp = "Rp." + nf.format(totalHutang);
        tvTotalHutang.setText(totalHutangRp);

        totalAngsuran = totalHutang / tenor ;
        String totalAngsuranRp = "Rp." + nf.format(totalAngsuran);
        tvTotalAngsuran.setText(totalAngsuranRp);


    }

    public void homeMain(View view) {
        Intent explicit = new Intent(HasilActivity.this, MainActivity.class);
        startActivity(explicit);
    }


}