package com.example.myapplication.admin.adminAction;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;


public class Action extends AppCompatActivity {
    TextView tab1, tab2;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
//                        return new User();
                        return new ServiceProvider();
                    case 1:
                        return new User();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onPageSelected(int position) {
                select(position);
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void select(int position) {
        if (position == 0) {
//            tab1.setTextColor(R.color.colorAccent);
//            tab1.setBackgroundColor(R.color.colorPrimary);
            tab1.setTextSize(20);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                tab1.setTextColor(getColor(R.color.colorPrimaryDark));
                tab1.setBackgroundColor(getColor(R.color.tab2Color));
            }

//            tab2.setTextColor(R.color.colorPrimary);
//            tab2.setBackgroundColor(R.color.colorPrimaryDark);
            tab2.setTextSize(10);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                tab2.setTextColor(getColor(R.color.black));
                tab2.setBackgroundColor(getColor(R.color.tab1Color));
            }
        }
        if (position == 1) {
//            tab2.setTextColor(R.color.colorAccent);
//            tab2.setBackgroundColor(R.color.colorPrimary);
            tab2.setTextSize(20);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                tab2.setTextColor(getColor(R.color.colorPrimaryDark));
                tab2.setBackgroundColor(getColor(R.color.tab2Color));
            }

//            tab1.setTextColor(R.color.colorPrimary);
//            tab1.setBackgroundColor(R.color.colorPrimaryDark);
            tab1.setTextSize(10);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                tab1.setTextColor(getColor(R.color.black));
                tab1.setBackgroundColor(getColor(R.color.tab1Color));
            }
        }

    }
}
