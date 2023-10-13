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

public class MainActivity extends AppCompatActivity {

    private CalculatorFragment calculatorFragment;

    private GradeFragment gradeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        Button calculatorButton = findViewById(R.id.calculatorButton);
        Button gradeButton = findViewById(R.id.gradeButton);

        calculatorFragment = new CalculatorFragment();
        gradeFragment = new GradeFragment();

        FragmentTransaction initTransaction = getSupportFragmentManager().beginTransaction();
        initTransaction.add(R.id.contentFrame, calculatorFragment);
        initTransaction.commit();

        calculatorButton.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentFrame, calculatorFragment);
            calculatorButton.setBackgroundTintMode(PorterDuff.Mode.LIGHTEN);
            gradeButton.setSelected(false);
            transaction.commit();
        });

        gradeButton.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentFrame, gradeFragment);
            transaction.commit();
        });
    }
}