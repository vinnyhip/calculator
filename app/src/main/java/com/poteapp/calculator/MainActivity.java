package com.poteapp.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;

public class MainActivity extends Activity {

    private static final String[] BUTTON_TEXTS = {
            "C", "±", "%", "÷",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            ".", "0", ",", "=",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout buttonGridLayout = findViewById(R.id.button_grid);
        ButtonFactory.addButtonsToGrid(this, buttonGridLayout, BUTTON_TEXTS, ScreenUtils.getScreenWidthInDp(this));
    }
}