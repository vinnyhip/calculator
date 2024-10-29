package com.poteapp.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.poteapp.calculator.factories.ButtonFactory;
import com.poteapp.calculator.factories.ResultTextViewFactory;
import com.poteapp.calculator.utils.ScreenUtils;

public class MainActivity extends Activity {

    private static final String[] BUTTON_TEXTS = {
            "C", "±", "%", "÷",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            ".", "0", ",", "=",
    };

    private Calculator calculator;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();

        RelativeLayout mainLayout = findViewById(R.id.main_layout);
        resultTextView = ResultTextViewFactory.createResultTextView(this);
        mainLayout.addView(resultTextView);

        GridLayout buttonGridLayout = findViewById(R.id.button_grid);
        ButtonFactory.addButtonsToGrid(this, buttonGridLayout, BUTTON_TEXTS, ScreenUtils.getScreenWidthInDp(this));

        setButtonListeners(buttonGridLayout);
    }

    private void setButtonListeners(GridLayout buttonGridLayout) {
        for (int i = 0; i < buttonGridLayout.getChildCount(); i++) {
            Button button = (Button) buttonGridLayout.getChildAt(i);
            button.setOnClickListener(v -> {
                String buttonText = button.getText().toString();
                handleButtonClick(buttonText);
            });
        }
    }

    private void handleButtonClick(String buttonText) {
        switch (buttonText) {
            case "C":
                calculator.clear();
                resultTextView.setText("0");
                break;
            case "+":
            case "-":
            case "*":
            case "÷":
                calculator.addOperator(buttonText);
                resultTextView.setText(buttonText);
                break;
            case "=":
                String result = calculator.calculate();
                resultTextView.setText(result);
                break;
            default:
                calculator.append(buttonText);
                resultTextView.setText(calculator.getCurrentInput());
                break;
        }
    }
}