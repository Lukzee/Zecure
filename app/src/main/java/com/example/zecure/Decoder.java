package com.example.zecure;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Decoder extends AppCompatActivity {
    EditText etdec;
    EditText secKey2;
    TextView dectv;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);

        // scroll textview
        TextView stv2 = (TextView) findViewById(R.id.tvVar2);
        stv2.setMovementMethod(new ScrollingMovementMethod());

        // link the edittext and textview with its id
        etdec = findViewById(R.id.etVar1);
        secKey2 = findViewById(R.id.secretKey2);
        dectv = findViewById(R.id.tvVar2);

        // create a clipboard manager variable to copy text
        cplboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    // onClick function of encrypt button
    public void dec(View view) {
        // get code from edittext
        String temp = etdec.getText().toString();
        String keey = secKey2.getText().toString();
        Log.e("dec", "text - " + temp);

        // pass the string to the decryption algorithm
        // and get the decrypted text
        String rv = Decode.decode(temp, keey);

        // set the text to the edit text for display
        dectv.setText(rv);
        Log.e("dec", "text - " + rv);
    }

    // onClick function of copy text button
    public void cpl(View view) {
        // get the string from the textview and trim all spaces
        String data = dectv.getText().toString().trim();

        // check if the textview is not empty
        if (!data.isEmpty()) {

            // copy the text in the clip board
            ClipData temp = ClipData.newPlainText("text", data);

            // display message that the text has been copied
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }
    }
}