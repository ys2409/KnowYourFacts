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


public class Fragment3 extends Fragment {

    TextView tv;
    Button btnChange;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        tv = view.findViewById(R.id.content);
        btnChange = view.findViewById(R.id.changeColor);

        tv.setText("In 1386, a pig in France was executed by public hanging for the murder of a child\n" +
                "\n" +
                "A cockroach can live several weeks with its head cut off!\n" +
                "\n" +
                "Human thigh bones are stronger than concrete.");

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