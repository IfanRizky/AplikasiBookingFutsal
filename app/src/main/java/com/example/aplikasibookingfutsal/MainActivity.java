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

public class MainActivity extends AppCompatActivity {

    EditText editUser, editPass_user;
    Button bSignUser;
    String usernameUser, passwordUser;

    AwesomeValidation awesomeValidation;

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

        editUser = findViewById(R.id.editUser);
        editPass_user = findViewById(R.id.editPass_user);
        bSignUser = findViewById(R.id.btn_sign_user);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //UsernameUser
        awesomeValidation.addValidation(this, R.id.editUser,
                RegexTemplate.NOT_EMPTY, R.string.invalid_username);

        //PasswordUser
        awesomeValidation.addValidation(this, R.id.editPass_user,
                RegexTemplate.NOT_EMPTY, R.string.invalid_pass_user);


        bSignUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameUser = editUser.getText().toString();
                passwordUser = editPass_user.getText().toString();

                if (awesomeValidation.validate() && validateUsernameUser() && validatePsswordUser()) {
                    showDialog();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Silahkan Cek Ulang Format Login", Toast.LENGTH_LONG).show();
                }

//                if (awesomeValidation.validate()) {
//                    showDialog();
//
//                } else if (editUser.equals("user") && editPass_user.equals("user")){
//                    showDialog();
//
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "Silahkan Cek Ulang Format Login", Toast.LENGTH_LONG).show();
//                }
            }

            private boolean validateUsernameUser() {
                if (usernameUser.equals("user")) {
                    return true;
                } else {usernameUser.equals("");
                    return false;
                }
            }

            private boolean validatePsswordUser() {
                if (passwordUser.equals("user")) {
                    return true;
                } else {passwordUser.equals("");
                    return false;
                }
            }

            private void showDialog() {
                Intent i = new Intent(getApplicationContext(), HomeUser.class);
                startActivity(i);
                Toast.makeText(MainActivity.this,
                        "Login Sukses", Toast.LENGTH_LONG).show();
            }
        });

//        @Override
//        public void onClick(View v) {
//            if (editUser.equals("user") && editPass_user.equals("user")) {
//                Toast.makeText(getApplicationContext(),
//                        "Silahkan Cek Ulang Format Login", Toast.LENGTH_LONG).show();
//
//            } else if (awesomeValidation.validate()) {
//                Intent i = new Intent(getApplicationContext(),HomeUser.class);
//                startActivity(i);
//                Toast.makeText(getApplicationContext(),
//                        "Login Sukses", Toast.LENGTH_LONG).show();
//
//            } else {
//                Toast.makeText(getApplicationContext(),
//                        "Silahkan Cek Ulang Format Login", Toast.LENGTH_LONG).show();
//            }
//        }
    }
}
}
