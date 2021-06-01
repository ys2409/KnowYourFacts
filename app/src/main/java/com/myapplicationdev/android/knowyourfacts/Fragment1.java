package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class Fragment1 extends Fragment {

    Button btnChangeBg;
    TextView tv;
    ArrayList<Integer> colorlist;
    ImageView iv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        colorlist = new ArrayList<>();
//        colorlist.add(android.R.color.holo_blue_bright);
//        colorlist.add(android.R.color.holo_purple);
//        colorlist.add(android.R.color.holo_green_dark);
//        colorlist.add(android.R.color.holo_red_dark);
//        colorlist.add(android.R.color.holo_orange_light);
//        colorlist.add(android.R.color.holo_blue_light);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tv = view.findViewById(R.id.tv);
        btnChangeBg = view.findViewById(R.id.btnChangeColor);
        iv = view.findViewById(R.id.imageView);

        String url = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Birds-Unihemispheric-Sleep.png";

//        Picasso.with(getContext()).load(url).into(iv);

        btnChangeBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Random r = new Random();
//                int i1 = r.nextInt(5);
//                view.setBackgroundColor(getResources().getColor(colorlist.get(i1)));
            Random r = new Random();
            int i1 = r.nextInt(256);
                int i2 = r.nextInt(256);
                int i3 = r.nextInt(256);
                view.setBackgroundColor(Color.rgb(i1,i2,i3));
            }
        });
        return view;
    }
}