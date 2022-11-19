package com.example.maps_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    //Metodo que da inflate ao menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i=null;
        switch (item.getItemId()){
            case R.id.item1:
                i = new Intent(this,MapsActivity.class);
                break;
            case R.id.item2:
                i = new Intent(this,MapsActivity2.class);
                break;
            case R.id.item3:
                i = new Intent(this,MapsActivity3.class);
                break;
        }
        if(i!=null)
            startActivity(i);
        return super.onOptionsItemSelected(item);
    }

}