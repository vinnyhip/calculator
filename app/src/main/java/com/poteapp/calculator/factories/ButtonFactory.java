package com.poteapp.calculator.factories;

import android.content.Context;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.GridLayout;

public class ButtonFactory {

    private static final int MARGIN_DP = 8;
    private static final int PADDING_DP = 16;
    private static final int TEXT_SIZE_SP = 20;
    private static final int COLUMNS = 4;

    public static void addButtonsToGrid(Context context, GridLayout gridLayout, String[] buttonTexts, int screenWidth) {

        // Calculate the total available width for buttons
        int availableWidth = screenWidth - (2 * PADDING_DP) - (2 * MARGIN_DP * COLUMNS);

        // Calculate the button size
        int buttonSizePx =  availableWidth / COLUMNS;

        for (String text : buttonTexts) {
            Button button = new Button(context);
            button.setText(text);
            button.setTextSize(TypedValue.COMPLEX_UNIT_SP, TEXT_SIZE_SP);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, buttonSizePx, context.getResources().getDisplayMetrics());
            params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, buttonSizePx, context.getResources().getDisplayMetrics());
            params.setMargins(
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, MARGIN_DP, context.getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, MARGIN_DP, context.getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, MARGIN_DP, context.getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, MARGIN_DP, context.getResources().getDisplayMetrics())
            );
            button.setLayoutParams(params);
            gridLayout.addView(button);
        }
    }
}