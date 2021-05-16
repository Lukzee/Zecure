package com.example.zecure;

import android.content.ClipData;
import android.content.ClipboardManager;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Encoder extends AppCompatActivity {

    EditText etenc;
    EditText secKey1;
    TextView enctv;
    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);

        // scroll textview
        TextView tview1 = (TextView) findViewById(R.id.tvVar1);
        tview1.setMovementMethod(new ScrollingMovementMethod());

        // link the edittext and textview with its id
        etenc = findViewById(R.id.etVar1);
        secKey1 = findViewById(R.id.secretKey1);
        enctv = findViewById(R.id.tvVar1);

        // create a clipboard manager variable to copy text
        cpb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    // onClick function of encrypt button
    public void enc(View view) {
        // get text from edittext
        String temp = etenc.getText().toString();
        String keeey = secKey1.getText().toString();

        // pass the string to the encryption
        // algorithm and get the encrypted code
        String rv = Encode.encode(temp, keeey);

        // set the code to the edit text
        enctv.setText(rv);
    }

    // onClick function of copy text button
    public void cp2(View view) {
        // get the string from the textview and trim all spaces
        String data = enctv.getText().toString().trim();

        // check if the textview is not empty
        if (!data.isEmpty()) {

            // copy the text in the clip board
            ClipData temp = ClipData.newPlainText("text", data);
            cpb.setPrimaryClip(temp);

            // display message that the text has been copied
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }
    }
}