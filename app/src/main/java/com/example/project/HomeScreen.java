package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {
    ImageButton home_button;
    ImageButton search_button;
    ImageButton map_button;
    ImageButton oilchange_button;
    ImageButton myprofile_button;
    ImageButton aboutus_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getSupportActionBar().hide();

        home_button = findViewById(R.id.home_button);
        search_button = findViewById(R.id.search_button);
        map_button = findViewById(R.id.map_button);
        oilchange_button = findViewById(R.id.oilchange_button);
        myprofile_button = findViewById(R.id.myprofile_button);
        aboutus_button = findViewById(R.id.aboutus_button);

        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Brands.class);
                startActivity(intent);
            }
        });

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Search.class);
                startActivity(intent);
            }
        });

        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        oilchange_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, OilChange.class);
                startActivity(intent);
            }
        });

        myprofile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, MyProfile.class);
                startActivity(intent);
            }
        });

        aboutus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, AboutUs.class);
                startActivity(intent);
            }
        });

    }
}
