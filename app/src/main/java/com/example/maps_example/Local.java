package com.example.maps_example;

public class Local {
    private String nome;
    private double latitude;
    private double longitude;
    public Local(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getNome() {
        return nome;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
}