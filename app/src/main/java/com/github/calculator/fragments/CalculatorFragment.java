package com.github.calculator.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.calculator.R;

public class CalculatorFragment extends Fragment {

    private TextView visor;
    private TextView calculation;
    private String inputText = "";
    private String inputNumber = "";
    private double num1 = 0, num2 = 0;
    private String operator = "";

    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        visor = view.findViewById(R.id.calculationTextView);
        calculation = view.findViewById(R.id.resultCalculationTextView);

        Button btn1 = view.findViewById(R.id.oneNumberButton);
        btn1.setOnClickListener(v -> {
            inputText += "1";
            visor.setText(inputText);
        });

        Button btn2 = view.findViewById(R.id.twoOneButton);
        btn2.setOnClickListener(v -> {
            inputText += "2";
            visor.setText(inputText);
        });

        Button btn3 = view.findViewById(R.id.threeNumberButton);
        btn3.setOnClickListener(v -> {
            inputText += "3";
            visor.setText(inputText);
        });

        Button btn4 = view.findViewById(R.id.fourNumberButton);
        btn4.setOnClickListener(v -> {
            inputText += "4";
            visor.setText(inputText);
        });

        Button btn5 = view.findViewById(R.id.fiveNumberButton);
        btn5.setOnClickListener(v -> {
            inputText += "5";
            visor.setText(inputText);
        });

        Button btn6 = view.findViewById(R.id.sixNumberButton);
        btn6.setOnClickListener(v -> {
            inputText += "6";
            visor.setText(inputText);
        });

        Button btn7 = view.findViewById(R.id.sevenNumberButton);
        btn7.setOnClickListener(v -> {
            inputText += "7";
            visor.setText(inputText);
        });

        Button btn8 = view.findViewById(R.id.eigthNumberButton);
        btn8.setOnClickListener(v -> {
            inputText += "8";
            visor.setText(inputText);
        });

        Button btn9 = view.findViewById(R.id.nineNumberButton);
        btn9.setOnClickListener(v -> {
            inputText += "9";
            visor.setText(inputText);
        });

//        Button btn10 = view.findViewById(R.id.zeroNumberButton);
//        btn10.setOnClickListener(v -> {
//            inputText += "0";
//            visor.setText(inputText);
//        });

        Button btn11 = view.findViewById(R.id.sumSignalButton);
        btn11.setOnClickListener(v -> {
            inputText += "+";
            visor.setText(inputText);
            onOperatorClick(view);
        });

        Button btn12 = view.findViewById(R.id.minusSignalButton);
        btn12.setOnClickListener(v -> {
            inputText += "-";
            visor.setText(inputText);
            onOperatorClick(view);
        });

        Button btn13 = view.findViewById(R.id.multiplicationSignalButton);
        btn13.setOnClickListener(v -> {
            inputText += "x";
            visor.setText(inputText);
            onOperatorClick(view);
        });

        Button btn14 = view.findViewById(R.id.divideSignalButton);
        btn14.setOnClickListener(v -> {
            inputText += "/";
            visor.setText(inputText);
            onOperatorClick(view);
        });

        Button btn15 = view.findViewById(R.id.deleteButton);
        btn15.setOnClickListener(v -> onClearClick(view));

        Button btn16 = view.findViewById(R.id.resultButton);
        btn16.setOnClickListener(v -> {
            onEqualsClick(view);
        });

        return view;
    }

    private void calculate() {
        if (!inputNumber.isEmpty()) {
            num2 = Double.parseDouble(inputNumber);
            inputNumber = "";

            switch (operator) {
                case "+":
                    num1 = num1 + num2;
                    break;
                case "-":
                    num1 = num1 - num2;
                    break;
                case "*":
                    num1 = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        num1 = num1 / num2;
                    } else {
                        Toast.makeText(getActivity(), "Divisão por zero", Toast.LENGTH_LONG).show();
                        return;
                    }
                    break;
            }

            calculation.setText(String.valueOf(num1));
            inputNumber = String.valueOf(num1);
            operator = "";
        }
    }

    public void onEqualsClick(View view) {
        calculate();
        operator = "";
        visor.setText("");
    }

    public void onOperatorClick(View view) {
        if (!inputNumber.isEmpty()) {
            if (!operator.isEmpty()) {
                calculate();
            }
            operator = ((Button) view).getText().toString();
            num1 = Double.parseDouble(inputNumber);
        } else {
            inputNumber = inputText.replaceAll("[+\\-*/]","");
        }
    }

    public void onClearClick(View view) {
        inputNumber = "";
        inputText = "";
        num1 = 0;
        num2 = 0;
        operator = "";
        visor.setText("");
        calculation.setText("");
    }
}