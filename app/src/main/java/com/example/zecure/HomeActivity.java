package com.example.zecure;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button enc, dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // link both the button variables with its id
        enc = findViewById(R.id.btVar1);
        dec = findViewById(R.id.btVar2);

        // onClick function for encryption
        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent function to move to another activity
                Intent intent = new Intent(getApplicationContext(), Encoder.class);
                startActivity(intent);
            }
        });

        // onClick function for decryption
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent function to move to another activity
                Intent intent = new Intent(getApplicationContext(), Decoder.class);
                startActivity(intent);
            }
        });
    }
}
