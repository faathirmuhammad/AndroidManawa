package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText field_namalengkap = findViewById(R.id.editText8);
        final EditText field_email = findViewById(R.id.editText3);
        final EditText field_password = findViewById(R.id.editText);
        final EditText field_konfirmasi = findViewById(R.id.editText10);

        Button register = findViewById(R.id.button);
        final ConstraintLayout bg = findViewById(R.id.background);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("mencoba", "BEGIN TEST");
                Log.d("mencoba", field_namalengkap.getText().toString());
                Log.d("mencoba", field_email.getText().toString());
                Log.d("mencoba", field_password.getText().toString());
                Log.d("mencoba", field_konfirmasi.getText().toString());
                Log.d("mencoba", "done");

                if(TextUtils.isEmpty(field_namalengkap.getText().toString()) || TextUtils.isEmpty(field_email.getText().toString()) || TextUtils.isEmpty(field_password.getText().toString()) || TextUtils.isEmpty(field_konfirmasi.getText().toString())){
                    Snackbar.make(bg, "Data diri belum lengkap!", Snackbar.LENGTH_LONG).show();
                }else{
                    if(!field_password.getText().toString().equals(field_konfirmasi.getText().toString())){
                        Snackbar.make(bg, "Konfirmasi password salah!", Snackbar.LENGTH_LONG).show();
                    }else{
                        String id = mDatabase.push().getKey();
                        User user = new User("test@test.com", "test1", "test");
                        mDatabase.child(id).setValue(user);
                    }
                }
            }
        });

        TextView login = findViewById(R.id.textView6);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}

