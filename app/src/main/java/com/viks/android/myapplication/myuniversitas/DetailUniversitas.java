package com.viks.android.myapplication.myuniversitas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailUniversitas extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_universitas);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("img_logo") &&
                getIntent().hasExtra("txt_nama") &&
                getIntent().hasExtra("txt_daerah") &&
                getIntent().hasExtra("txt_sinopsis") &&
                getIntent().hasExtra("txt_singkatan") &&
                getIntent().hasExtra("txt_didirikan") &&
                getIntent().hasExtra("txt_alamat") &&
                getIntent().hasExtra("img_taman")){

            String imgLogo = getIntent().getStringExtra("img_logo");
            String txtNama = getIntent().getStringExtra("txt_nama");
            String txtDaerah = getIntent().getStringExtra("txt_daerah");
            String txtSinopsis = getIntent().getStringExtra("txt_sinopsis");
            String txtSingkatan = getIntent().getStringExtra("txt_singkatan");
            String txtDidirikan = getIntent().getStringExtra("txt_didirikan");
            String txtAlamat = getIntent().getStringExtra("txt_alamat");
            String imgTaman = getIntent().getStringExtra("img_taman");

            setDetail(imgLogo,txtNama,txtDaerah,txtSinopsis,txtSingkatan,txtDidirikan,txtAlamat,imgTaman);

        }
    }

    private void setDetail(String imgLogo, String txtNama, String txtDaerah, String txtSinopsis, String txtSingkatan, String txtDidrikan, String txtAlamat, String imgTaman){

        ImageView img_Logo = findViewById(R.id.img_detail_logo);
        TextView tvNama = findViewById(R.id.tv_detail_nama);
        TextView tvDaerah = findViewById(R.id.tv_detail_daerah);
        TextView tvSinopsis = findViewById(R.id.tv_detail_sinopsis);
        TextView tvSingkatan = findViewById(R.id.tv_detail_singkatan);
        TextView tvDidirikan = findViewById(R.id.tv_detail_born);
        TextView tvAlamat = findViewById(R.id.tv_detail_alamat);
        ImageView img_Taman = findViewById(R.id.img_detail_taman);

        Glide.with(this)
                .asBitmap()
                .load(imgLogo)
                .into(img_Logo);
        tvNama.setText(txtNama);
        tvDaerah.setText(txtDaerah);
        tvSinopsis.setText(txtSinopsis);
        tvSingkatan.setText(txtSingkatan);
        tvDidirikan.setText(txtDidrikan);
        tvAlamat.setText(txtAlamat);
        Glide.with(this)
                .asBitmap()
                .load(imgTaman)
                .into(img_Taman);
    }
}
