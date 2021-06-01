package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Fragment2 extends Fragment {

    Button btnChange;
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        tv = view.findViewById(R.id.content);
        btnChange = view.findViewById(R.id.changeColor);

        tv.setText("What is called a \"French kiss\" in the English speaking world is known as an \"English kiss\" in France.\n" +
                "\n" +
                "\"Almost\" is the longest word in the English language with all the letters in alphabetical order.\n" +
                "\n" +
                "\"Rhythm\" is the longest English word without a vowel.");

        btnChange.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Random random = new Random();

                float r = random.nextFloat();
                float g = random.nextFloat();
                float b = random.nextFloat();

                getView().setBackgroundColor(Color.rgb(r, g, b));
            }
        });
        return view;
    }
}