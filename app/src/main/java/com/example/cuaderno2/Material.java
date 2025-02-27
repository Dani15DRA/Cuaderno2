package com.example.cuaderno2;
public class Material {
    private String nombre;
    private int stock;
    private int imagenResId; // ID de recurso en lugar de URL
    private String detalle;
    private int stockMinimo;

    public Material(String nombre, int stock, int imagenResId, String detalle, int stockMinimo) {
        this.nombre = nombre;
        this.stock = stock;
        this.imagenResId = imagenResId;
        this.detalle = detalle;
        this.stockMinimo = stockMinimo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public boolean esBajoStock() {
        return stock < stockMinimo;
    }
}
