package com.example.maps_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MapsActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);

        ArrayList<Local> locais = new ArrayList<>();
        locais.add (new Local("ESECS", 39.739448, -8.811279));
        locais.add (new Local("ESTG", 39.734737, -8.820981));
        locais.add (new Local("ESSLEI", 39.732761, -8.820380));
        locais.add (new Local("ESTM", 39.365076, -9.403197));
        locais.add (new Local("ESAD", 39.395380, -9.135493));
        RecyclerView rc= findViewById(R.id.recyclerView);
        RecyclerViewAdapter ra = new RecyclerViewAdapter(this, locais);
        LinearLayoutManager layout= new LinearLayoutManager(this);
        rc.setAdapter(ra);
        rc.setLayoutManager(layout);

    }
}