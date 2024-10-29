package com.poteapp.calculator.factories;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.poteapp.calculator.R;

public class ResultTextViewFactory {

    private static final int PADDING_DP = 16;
    private static final int MARGIN_DP = 16;
    private static final int TEXT_SIZE_SP = 92;

    public static TextView createResultTextView(Context context) {
        TextView resultTextView = new TextView(context);
        resultTextView.setText("0");
        resultTextView.setTextSize(TEXT_SIZE_SP);
        resultTextView.setGravity(Gravity.END);

        int paddingPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, PADDING_DP, context.getResources().getDisplayMetrics());
        int marginPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, MARGIN_DP, context.getResources().getDisplayMetrics());

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