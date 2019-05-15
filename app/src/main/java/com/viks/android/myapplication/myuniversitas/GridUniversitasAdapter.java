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

public class GridUniversitasAdapter extends RecyclerView.Adapter<GridUniversitasAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Universitas> listUniversitas;

    public GridUniversitasAdapter(Context context) {
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
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_universitas, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int position) {
        gridViewHolder.tvNamaUniv.setText(getListUniversitas().get(position).getNama());
        Glide.with(context)
                .load(getListUniversitas().get(position).getLogo())
                .apply(new RequestOptions().override(1200, 1200))
                .into(gridViewHolder.imgLogo);

        gridViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent shareWeb = new Intent(Intent.ACTION_SEND);
                shareWeb.setType("text/plain");
                shareWeb.putExtra(Intent.EXTRA_SUBJECT, "My Favorite Campus");
                shareWeb.putExtra(Intent.EXTRA_TEXT, ""+getListUniversitas().get(position).getOfficial());
                context.startActivities(new Intent[]{Intent.createChooser(shareWeb, "Share my Favorite Campus via")});
            }
        }));

        gridViewHolder.btnOfficial.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
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

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView tvNamaUniv;
        Button btnFavorite, btnOfficial;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_item_logo);
            tvNamaUniv = itemView.findViewById(R.id.tv_namauniv);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btnOfficial = itemView.findViewById(R.id.btn_official);
        }
    }
}