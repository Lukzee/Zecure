package com.example.zecure;

import android.content.Intent;
//import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class Home extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);

        Button enc = (Button) view.findViewById(R.id.btVar1);
        Button dec = (Button) view.findViewById(R.id.btVar2);

        // onClick function for encryption
        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent function to move to another activity
                Intent intent = new Intent(getActivity(), Encoder.class);
                startActivity(intent);
            }
        });

        // onClick function for decryption
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent function to move to another activity
                Intent intent = new Intent(getActivity(), Decoder.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

