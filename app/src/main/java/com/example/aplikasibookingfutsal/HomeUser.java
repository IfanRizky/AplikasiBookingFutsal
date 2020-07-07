package com.example.aplikasibookingfutsal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        //Initialize and Assign Varible
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_user);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.homeuser);

        //Perform SwlectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.booking:
                        startActivity(new Intent(getApplicationContext(),
                                Booking.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.homeuser:
                        return true;

                    case R.id.paymentuser:
                        startActivity(new Intent(getApplicationContext(),
                                PaymentUser.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profileuser:
                        startActivity(new Intent(getApplicationContext(),
                                ProfileUser.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
