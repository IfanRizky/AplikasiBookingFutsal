package com.example.aplikasibookingfutsal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_admin);

        //Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_adm);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.profileadmin);

        //Perform SelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homeadmin:
                        startActivity(new Intent(getApplicationContext(),
                                HomeAdmin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.paymentadmin:
                        startActivity(new Intent(getApplicationContext(),
                                PaymentAdmin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profileadmin:
                        return true;
                }
                return false;
            }
        });
    }
}
