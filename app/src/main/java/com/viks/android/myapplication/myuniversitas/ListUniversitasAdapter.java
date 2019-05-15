package com.viks.android.myapplication.myuniversitas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListUniversitasAdapter extends RecyclerView.Adapter<ListUniversitasAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Universitas> listUniversitas;

    public ListUniversitasAdapter(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_universitas, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvNama.setText(getListUniversitas().get(position).getNama());
        categoryViewHolder.tvDaerah.setText(getListUniversitas().get(position).getDaerah());
        Glide.with(context)
                .load(getListUniversitas().get(position).getLogo())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgLogo);
    }

    @Override
    public int getItemCount() {
        return getListUniversitas().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvDaerah;
        ImageView imgLogo;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvDaerah = itemView.findViewById(R.id.tv_item_daerah);
            imgLogo = itemView.findViewById(R.id.img_item_logo);
        }
    }
}
