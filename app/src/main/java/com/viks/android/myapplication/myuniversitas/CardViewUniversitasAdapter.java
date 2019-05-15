package com.viks.android.myapplication.myuniversitas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewUniversitasAdapter extends RecyclerView.Adapter<CardViewUniversitasAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Universitas> listUniversitas;

    public CardViewUniversitasAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Universitas> getListUniversitas() {
        return listUniversitas;
    }

    public void setListUniversitas(ArrayList<Universitas> listUniversitas) {
        this.listUniversitas = listUniversitas;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_universitas, viewGroup, false);
        return new CardViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        Universitas univ = getListUniversitas().get(i);
        Glide.with(context)
                .load(univ.getLogo())
                .apply(new RequestOptions().override(1200,1200))
                .into(cardViewHolder.imgLogo);
        cardViewHolder.tvNama.setText(univ.getNama());
        cardViewHolder.tvDaerah.setText(univ.getDaerah());

        cardViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent shareWeb = new Intent(Intent.ACTION_SEND);
                shareWeb.setType("text/plain");
                shareWeb.putExtra(Intent.EXTRA_SUBJECT, "My Favorite Campus");
                shareWeb.putExtra(Intent.EXTRA_TEXT, ""+getListUniversitas().get(position).getOfficial());
                context.startActivities(new Intent[]{Intent.createChooser(shareWeb, "Share my Favorite Campus via")});
            }
        }));
        cardViewHolder.btnOfficial.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent webOfficial = new Intent(Intent.ACTION_VIEW, Uri.parse(""+getListUniversitas().get(position).getOfficial()));
                context.startActivity(webOfficial);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListUniversitas().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView tvNama, tvDaerah;
        Button btnFavorite, btnOfficial;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_item_logo);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvDaerah = itemView.findViewById(R.id.tv_item_daerah);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnOfficial = itemView.findViewById(R.id.btn_set_official);
        }
    }
}
