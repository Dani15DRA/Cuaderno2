package com.example.cuaderno2;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.MaterialViewHolder> {
    private List<Material> listaMateriales;
    private OnMaterialClickListener listener;

    public interface OnMaterialClickListener {
        void onMaterialClick(Material material, int position);
    }

    public MaterialAdapter(List<Material> listaMateriales, OnMaterialClickListener listener) {
        this.listaMateriales = listaMateriales;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_material, parent, false);
        return new MaterialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialViewHolder holder, int position) {
        Material material = listaMateriales.get(position);

        holder.nombre.setText(material.getNombre());
        holder.detalle.setText(material.getDetalle());
        holder.stock.setText("Stock: " + material.getStock());

        // Establecer imagen local
        holder.imagen.setImageResource(material.getImagenResId());

        if (material.esBajoStock()) {
            holder.stock.setTextColor(Color.RED);
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFEBEE"));
        } else {
            holder.stock.setTextColor(Color.BLACK);
            holder.cardView.setCardBackgroundColor(Color.WHITE);
        }

        // Configurar listener de click
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMaterialClick(material, position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaMateriales.size();
    }

    public static class MaterialViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, stock, detalle;
        ImageView imagen;
        CardView cardView;

        public MaterialViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            nombre = itemView.findViewById(R.id.tvNombre);
            detalle = itemView.findViewById(R.id.tvDetalle);
            stock = itemView.findViewById(R.id.tvStock);
            imagen = itemView.findViewById(R.id.ivMaterial);
        }
    }
}
