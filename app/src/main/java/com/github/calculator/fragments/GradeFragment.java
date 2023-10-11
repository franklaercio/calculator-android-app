package com.github.calculator.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.calculator.R;
import com.github.calculator.domain.GradeStatus;

import java.util.Objects;

public class GradeFragment extends Fragment {

    private TextView textView;
    private EditText grade1Input;
    private EditText grade2Input;
    private EditText grade3Input;

    public GradeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        grade1Input = view.findViewById(R.id.grade1Input);
        grade2Input = view.findViewById(R.id.grade2Input);
        grade3Input = view.findViewById(R.id.grade3Input);

        Button calculate = view.findViewById(R.id.calculateGradeButton);
        calculate.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            GradeStatus gradeStatus = calculateGrade();
            textView = view.findViewById(R.id.resultTextView);

            if (textView != null) {
                Toast.makeText(getActivity(), gradeStatus.getValue(), Toast.LENGTH_LONG).show();
                textView.setText(gradeStatus.getValue());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grade, container, false);
    }

    private GradeStatus calculateGrade() {
        String input1 = grade1Input.getText().toString().trim();
        String input2 = grade2Input.getText().toString().trim();
        String input3 = grade3Input.getText().toString().trim();

        boolean isValidInput1 = validateGrade(input1, grade1Input);
        boolean isValidInput2 = validateGrade(input2, grade2Input);
        boolean isValidInput3 = validateGrade(input3, grade3Input);

        if(isValidInput1 && isValidInput2 && isValidInput3) {
            double result = (Double.parseDouble(input1)
                    + Double.parseDouble(input2) + Double.parseDouble(input3)) / 3;

            if(result >= 7.0) {
                return GradeStatus.APROVADO;
            } else if(result < 7.0 && result >= 5.0) {
                return GradeStatus.APROVADO_POR_NOTA;
            } else {
                return GradeStatus.REPROVADO;
            }
        } else {
            return GradeStatus.NAO_VALIDADO;
        }
    }

    private boolean validateGrade(String input, EditText editText) {
        try {
            double grade = Double.parseDouble(input);

            if (grade < 0 || grade > 10) {
                editText.setError("Nota inválida. Informe um valor entre 0 e 10.");
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            editText.setError("Não foi possível converter o valor numérico.");
            return false;
        }
    }
}