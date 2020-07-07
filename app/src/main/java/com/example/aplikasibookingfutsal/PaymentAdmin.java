package com.example.aplikasibookingfutsal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PaymentAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_admin);

        //Initialize and Assign Varible
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_adm);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.paymentadmin);

        //Perform SwlectedListener
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
                        return true;

                    case R.id.profileadmin:
                        startActivity(new Intent(getApplicationContext(),
                                ProfileAdmin.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
