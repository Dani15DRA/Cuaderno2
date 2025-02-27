package com.example.cuaderno2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MaterialAdapter.OnMaterialClickListener {
    private RecyclerView recyclerView;
    private MaterialAdapter adapter;
    private List<Material> listaMateriales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaMateriales = new ArrayList<>();

        listaMateriales.add(new Material(
                "Acero 1020",
                50,
                R.drawable.acero,
                "Acero al carbono con 0.20% de carbono, excelente maleabilidad y soldabilidad",
                20));

        listaMateriales.add(new Material(
                "Acero Inoxidable",
                10,
                R.drawable.acero2,
                "Aleación de acero con un mínimo de 10.5% de cromo, resistente a la corrosión",
                15));

        listaMateriales.add(new Material(
                "Chapa Galvanizada",
                5,
                R.drawable.chapa,
                "Lámina de acero recubierta con una capa de zinc para prevenir la corrosión",
                10));


        adapter = new MaterialAdapter(listaMateriales, this);
        recyclerView.setAdapter(adapter);

        verificarBajoStock();
    }

    private void verificarBajoStock() {
        for (Material m : listaMateriales) {
            if (m.esBajoStock()) {
                Toast.makeText(this, "Alerta: Bajo stock de " + m.getNombre(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onMaterialClick(Material material, int position) {
        // Mostrar detalles del material cuando se hace clic
        Toast.makeText(this,
                "Detalle: " + material.getDetalle() + "\n" +
                        "Stock actual: " + material.getStock() + "\n" +
                        "Stock mínimo: " + material.getStockMinimo(),
                Toast.LENGTH_LONG).show();
    }
}
