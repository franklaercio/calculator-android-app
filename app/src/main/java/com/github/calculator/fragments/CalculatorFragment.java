package com.github.calculator.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.calculator.R;

import org.mariuszgromada.math.mxparser.Expression;

public class CalculatorFragment extends Fragment {

    private TextView resultTextView;
    private TextView calculationTextView;

    private boolean isNewNumber = true;
    private boolean isOperatorClicked = true;


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
        resultTextView = view.findViewById(R.id.resultCalculationTextView);
        calculationTextView = view.findViewById(R.id.calculationTextView);

        Button btn1 = view.findViewById(R.id.oneNumberButton);
        btn1.setOnClickListener(v -> onNumberClick(1));

        Button btn2 = view.findViewById(R.id.twoOneButton);
        btn2.setOnClickListener(v -> onNumberClick(2));

        Button btn3 = view.findViewById(R.id.threeNumberButton);
        btn3.setOnClickListener(v -> onNumberClick(3));

        Button btn4 = view.findViewById(R.id.fourNumberButton);
        btn4.setOnClickListener(v -> onNumberClick(4));

        Button btn5 = view.findViewById(R.id.fiveNumberButton);
        btn5.setOnClickListener(v -> onNumberClick(5));

        Button btn6 = view.findViewById(R.id.sixNumberButton);
        btn6.setOnClickListener(v -> onNumberClick(6));

        Button btn7 = view.findViewById(R.id.sevenNumberButton);
        btn7.setOnClickListener(v -> onNumberClick(7));

        Button btn8 = view.findViewById(R.id.eigthNumberButton);
        btn8.setOnClickListener(v -> onNumberClick(8));

        Button btn9 = view.findViewById(R.id.nineNumberButton);
        btn9.setOnClickListener(v -> onNumberClick(9));

        Button btn10 = view.findViewById(R.id.nineNumberButton2);
        btn10.setOnClickListener(v -> onNumberClick(0));

        Button btn11 = view.findViewById(R.id.sumSignalButton);
        btn11.setOnClickListener(v -> onOperatorClick("+"));

        Button btn12 = view.findViewById(R.id.minusSignalButton);
        btn12.setOnClickListener(v -> onOperatorClick("-"));

        Button btn13 = view.findViewById(R.id.multiplicationSignalButton);
        btn13.setOnClickListener(v -> onOperatorClick("*"));

        Button btn14 = view.findViewById(R.id.divideSignalButton);
        btn14.setOnClickListener(v -> onOperatorClick("/"));

        Button btn15 = view.findViewById(R.id.deleteButton);
        btn15.setOnClickListener(v -> onClearClick());

        Button btn16 = view.findViewById(R.id.resultButton);
        btn16.setOnClickListener(v -> onEqualsClick());

        return view;
    }

    private void onNumberClick(int number) {
        String currentText = calculationTextView.getText().toString();
        calculationTextView.setText(currentText.concat(String.valueOf(number)));
        calculate();
    }

    public void onEqualsClick() {
        calculationTextView.setText(resultTextView.getText().toString());
        resultTextView.setText("");
    }

    public void onOperatorClick(String operator) {
        String currentText = calculationTextView.getText().toString();
        calculationTextView.setText(currentText.concat(String.valueOf(operator)));
    }

    private void calculate() {
        Expression e = new Expression(calculationTextView.getText().toString());
        double v = e.calculate();

        if(Double.isNaN(v)) {
            Toast.makeText(getActivity(), "Divisão por zero", Toast.LENGTH_LONG).show();
            onClearClick();
        } else {
            resultTextView.setText(String.valueOf(v));
        }
    }

    public void onClearClick() {
        resultTextView.setText("");
        calculationTextView.setText("");
    }
}