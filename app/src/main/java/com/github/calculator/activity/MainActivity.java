package com.github.calculator.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.github.calculator.R;
import com.github.calculator.fragments.CalculatorFragment;
import com.github.calculator.fragments.GradeFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private CalculatorFragment calculatorFragment;

    private GradeFragment gradeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        calculatorFragment = new CalculatorFragment();
        gradeFragment = new GradeFragment();

        FragmentTransaction initTransaction = getSupportFragmentManager().beginTransaction();
        initTransaction.add(R.id.contentFrame, calculatorFragment);
        initTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        FragmentTransaction calcFragment = getSupportFragmentManager().beginTransaction();
                        calcFragment.replace(R.id.contentFrame, calculatorFragment);
                        calcFragment.commit();
                        break;
                    case 1:
                        FragmentTransaction graFragment = getSupportFragmentManager().beginTransaction();
                        graFragment.replace(R.id.contentFrame, gradeFragment);
                        graFragment.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}