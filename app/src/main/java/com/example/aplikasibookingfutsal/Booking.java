package com.example.aplikasibookingfutsal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Booking extends AppCompatActivity {

    private Button getBtnPesan;
    private Button showDialogButton;

    Calendar myCalendar;
    Button btnPesan, btnKembali;
    DatePickerDialog.OnDateSetListener date;
    EditText textInputNamaPemesan,
            textInputPilihTanggal,
            textInputUangMuka,
            textInputMulai,
            textInputSampai;

    AwesomeValidation awesomeValidation;

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        textInputPilihTanggal.setText(sdf.format(myCalendar.getTime()));
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //Set Title Dialog
        alertDialogBuilder.setTitle("Konfirmasi...");

        //Set Pesan Dialog
        alertDialogBuilder
                .setMessage("Apakah data yang Anda masukkan sudah benar?")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Jika tombol diklik, maka akan ke activity 2
                        Intent i = new Intent(getApplicationContext(), PaymentUser.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Jika tombol diklik, akan menutup dialog dan tak terjadi apa-apa
                        dialog.cancel();
                    }
                });

        //Membuat Alert Dialog dari Builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        //Menampilkan Alert Dialog
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        textInputNamaPemesan = findViewById(R.id.textInputNamaPemesan);
        textInputPilihTanggal = findViewById(R.id.textInputPilihTanggal);
        textInputUangMuka = findViewById(R.id.textInputUangMuka);
        textInputMulai = findViewById(R.id.textInputMulai);
        textInputSampai = findViewById(R.id.textInputSampai);

        btnPesan = findViewById(R.id.btnPesan);
        btnKembali = findViewById(R.id.btnKembali);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //NamaPemesan
        awesomeValidation.addValidation(this,R.id.textInputNamaPemesan,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //UangMuka
        awesomeValidation.addValidation(this, R.id.textInputUangMuka,
                RegexTemplate.NOT_EMPTY, R.string.invalid_uang);

        //Mulai
        awesomeValidation.addValidation(this, R.id.textInputMulai,
                RegexTemplate.NOT_EMPTY, R.string.invalid_mulai);

        //Sampai
        awesomeValidation.addValidation(this, R.id.textInputSampai,
                RegexTemplate.NOT_EMPTY, R.string.invalid_sampai);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        textInputPilihTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Booking.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        getBtnPesan = (Button) findViewById(R.id.btnPesan);
        getBtnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ShowDialog
                if (awesomeValidation.validate()) {
                    showDialog();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Mohon isi Data Yang Kosong", Toast.LENGTH_SHORT).show();
                }
            }

//        textInputTglLahir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,
//                        "Tanggal :" + textInputTglLahir.getEditText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


        });

        //Initialize and Assign Varible
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_user);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.booking);

        //Perform SelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.booking:
                        return true;

                    case R.id.homeuser:
                        startActivity(new Intent(getApplicationContext(),
                                HomeUser.class));
                        overridePendingTransition(0,0);
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
