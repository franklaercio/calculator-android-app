package com.github.calculator.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.github.calculator.R;
import com.github.calculator.fragments.CalculatorFragment;
import com.github.calculator.fragments.GradeFragment;

public class MainActivity extends AppCompatActivity {

    private Button calculatorButton;

    private Button gradeButton;

    private CalculatorFragment calculatorFragment;

    private GradeFragment gradeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        calculatorButton = findViewById(R.id.calculatorButton);
        gradeButton = findViewById(R.id.gradeButton);

        calculatorFragment = new CalculatorFragment();
        gradeFragment = new GradeFragment();

        FragmentTransaction initTransaction = getSupportFragmentManager().beginTransaction();
        initTransaction.add(R.id.contentFrame, calculatorFragment);
        initTransaction.commit();

        calculatorButton.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentFrame, calculatorFragment);
            transaction.commit();
        });

        gradeButton.setOnClickListener(view -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contentFrame, gradeFragment);
            transaction.commit();
        });
    }
}