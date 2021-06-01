package com.myapplicationdev.android.knowyourfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnReadLater;
    ViewPager vPager;

    MyFragmentAdapter adapter;
    ArrayList<Fragment> al;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReadLater = findViewById(R.id.btnReadLater);
        vPager = findViewById(R.id.viewpager1);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Fragment1());
        al.add(new Fragment2());
        al.add(new Fragment3());

        adapter = new MyFragmentAdapter(fm, al);

        vPager.setAdapter(adapter);

        btnReadLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_next) {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max - 1) {
                int nextPage = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(nextPage, true);

            }

        }
        else if (id == R.id.action_previous) {
            if (vPager.getCurrentItem() > 0) {
                int previousPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previousPage, true);

            }

        }
        else if(id == R.id.action_random){
            Random random = new Random();
            int max = vPager.getChildCount();
            int picker = random.nextInt(max);
            vPager.setCurrentItem(picker,true);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
        sharedpreferences = getApplicationContext().getSharedPreferences("pref",0);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Log.d("id", String.valueOf(vPager.getCurrentItem()));
        editor.putInt("pageId", vPager.getCurrentItem());
        editor.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedpreferences = getApplicationContext().getSharedPreferences("pref",0);
        if(sharedpreferences.contains("pageId")) {
            Integer id = sharedpreferences.getInt("pageId", -1);
            vPager.setCurrentItem(id);
        }
    }
}