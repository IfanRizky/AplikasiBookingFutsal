package com.example.aplikasibookingfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1: {
                Toast.makeText(getApplicationContext(), "Ini adalah tampilan User",
                        Toast.LENGTH_LONG).show();
            }break;

            case  R.id.item2: {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Ini adalah tampilan Admin",
                        Toast.LENGTH_LONG).show();
            }break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
