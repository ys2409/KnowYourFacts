package com.myapplicationdev.android.knowyourfacts;

import android.os.Bundle;

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
    ArrayList<Integer> colorlist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        colorlist = new ArrayList<>();
        colorlist.add(android.R.color.holo_blue_bright);
        colorlist.add(android.R.color.holo_purple);
        colorlist.add(android.R.color.holo_green_dark);
        colorlist.add(android.R.color.holo_red_dark);
        colorlist.add(android.R.color.holo_orange_light);
        colorlist.add(android.R.color.holo_blue_light);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        tv = view.findViewById(R.id.tv);
        btnChange = view.findViewById(R.id.changeColor);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int i1 = r.nextInt(5);
                view.setBackgroundColor(getResources().getColor(colorlist.get(i1)));
            }
        });
        return view;
    }
}