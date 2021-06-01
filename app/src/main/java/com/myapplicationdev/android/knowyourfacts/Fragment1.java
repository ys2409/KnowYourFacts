package com.myapplicationdev.android.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.util.Random;

public class Fragment1 extends Fragment {

    Button btnChangeBg, btnRss;
    TextView tv, tvRss;
    ArrayList<Integer> colorlist;
    ImageView iv;
    private String finalUrl = "https://www.singstat.gov.sg/rss";
    private HandleXML obj;
    String RssString;

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
        btnRss = view.findViewById(R.id.btnRSS);
        tvRss = view.findViewById(R.id.tvRSS);

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

        btnRss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj = new HandleXML(finalUrl);
                obj.fetchXML();

                while(obj.parsingComplete) {
                    RssString = obj.getTitle() + "\n" + obj.getDescription() + "\n" + obj.getLink();
                    tvRss.setText(RssString);
                }
            }
        });
        return view;
    }
}