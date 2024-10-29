package com.poteapp.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String[] BUTTON_TEXTS = {
            "C", "±", "%", "÷",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            ".", "0", ",", "=",
    };

    private static final int PADDING_DP = 16;
    private static final int MARGIN_DP = 16;
    private static final int TEXT_SIZE_SP = 92;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout mainLayout = findViewById(R.id.main_layout);
        TextView resultTextView = createResultTextView();
        mainLayout.addView(resultTextView);

        GridLayout buttonGridLayout = findViewById(R.id.button_grid);
        ButtonFactory.addButtonsToGrid(this, buttonGridLayout, BUTTON_TEXTS, ScreenUtils.getScreenWidthInDp(this));
    }

    private TextView createResultTextView() {
        TextView resultTextView = new TextView(this);
        resultTextView.setText("0");
        resultTextView.setTextSize(TEXT_SIZE_SP);
        resultTextView.setGravity(Gravity.CENTER);

        int paddingPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, PADDING_DP, getResources().getDisplayMetrics());
        int marginPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, MARGIN_DP, getResources().getDisplayMetrics());

        resultTextView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.addRule(RelativeLayout.ABOVE, R.id.button_grid);
        params.setMargins(marginPx, 0, marginPx, 0);
        resultTextView.setLayoutParams(params);

        return resultTextView;
    }
}