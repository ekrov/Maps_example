package com.example.maps_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.MHolder> {
        Context context;
        ArrayList<Local> locais;
        RecyclerViewAdapter(Context context, ArrayList<Local> locais) {
        this.context = context;

            this.locais = locais;
        }
    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        return new MHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        holder.bindView(position);
    }
    @Override
    public int getItemCount() {
        return locais.size();
    }
    public class MHolder extends RecyclerView.ViewHolder implements
            OnMapReadyCallback {
        MapView mapView;
        TextView title;
        GoogleMap map;
        View layout;
        public MHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView;
            mapView = layout.findViewById(R.id.mapView);
            title = layout.findViewById(R.id.textView);
            if (mapView != null) {
                mapView.onCreate(null);
                mapView.getMapAsync(this);
            }
        }
        @Override
        public void onMapReady(GoogleMap googleMap) {
            MapsInitializer.initialize(context.getApplicationContext());
            map = googleMap;
            setMapLocation();
        }
        private void setMapLocation() {
            if (map == null) return;
            Local data = (Local) mapView.getTag();
            if (data == null) return;
            LatLng location = new LatLng(data.getLatitude(),
                    data.getLongitude());
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 13));
            map.addMarker(new MarkerOptions().position(location));
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
        private void bindView(int pos) {
            Local item = locais.get(pos);
            layout.setTag(this);
            mapView.setTag(item);
            title.setText(item.getNome());
        }
    }
}

