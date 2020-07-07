package com.example.aplikasibookingfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class Main2Activity extends AppCompatActivity {

    EditText textInputAdmin, textInputPassAdmin;
    Button bSignAdmin;
    String usernameAdmin, passwordAdmin;

    AwesomeValidation awesomeValidation;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1: {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Ini adalah tampilan User",
                        Toast.LENGTH_LONG).show();
            }break;

            case  R.id.item2: {
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
        setContentView(R.layout.activity_main2);

        textInputAdmin = findViewById(R.id.editAdmin);
        textInputPassAdmin = findViewById(R.id.editPass_admin);
        bSignAdmin = findViewById(R.id.btn_sign_admin);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //UsernameAdmin
        awesomeValidation.addValidation(this, R.id.editAdmin,
                RegexTemplate.NOT_EMPTY, R.string.invalid_admin);

        //PasswordAdmin
        awesomeValidation.addValidation(this, R.id.editPass_admin,
                RegexTemplate.NOT_EMPTY, R.string.invalid_pass_admin);

        bSignAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameAdmin = textInputAdmin.getText().toString();
                passwordAdmin = textInputPassAdmin.getText().toString();

                if (awesomeValidation.validate() && validateUsernameAdmin() && validatePsswordAdmin()) {
                    showDialog();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Silahkan Cek Ulang Format Login", Toast.LENGTH_LONG).show();
                }

//                if (awesomeValidation.validate() || textInputAdmin.equals("admin") && passwordAdmin.equals("admin")) {
//                    showDialog();
////                    Toast.makeText(MainActivity.this,
////                            "Login Sukses", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "Silahkan Cek Ulang Format Login", Toast.LENGTH_LONG).show();
//                }

//                if (usernameAdmin.equals("admin") && passwordAdmin.equals("admin")) {
//                    Toast.makeText(Main2Activity.this,
//                            "Login Sukses", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "Pasword Salah", Toast.LENGTH_LONG).show();
//                }
            }

            private boolean validateUsernameAdmin() {
                if (usernameAdmin.equals("admin")) {
                    return true;
                } else {usernameAdmin.equals("");
                    return false;
                }
            }

            private boolean validatePsswordAdmin() {
                if (passwordAdmin.equals("admin")) {
                    return true;
                } else {passwordAdmin.equals("");
                    return false;
                }
            }

            private void showDialog() {
                Intent i = new Intent(getApplicationContext(), HomeAdmin.class);
                startActivity(i);
                Toast.makeText(Main2Activity.this,
                        "Login Sukses", Toast.LENGTH_LONG).show();
            }
        });
    }
}
