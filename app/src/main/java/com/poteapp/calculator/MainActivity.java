package com.poteapp.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
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
        resultTextView.setId(View.generateViewId());
        resultTextView.setText("0");
        resultTextView.setTextSize(TEXT_SIZE_SP);
        resultTextView.setGravity(Gravity.CENTER);
        resultTextView.setPadding(PADDING_DP, PADDING_DP, PADDING_DP, PADDING_DP);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.setMargins(0, MARGIN_DP, 0, 0);
        resultTextView.setLayoutParams(params);

        return resultTextView;
    }
}