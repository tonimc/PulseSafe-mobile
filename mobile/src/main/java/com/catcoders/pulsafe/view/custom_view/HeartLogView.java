package com.catcoders.pulsafe.view.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catcoders.pulsafe.R;

/**
 * Created by tonimc on 17/4/15.
 */
public class HeartLogView extends LinearLayout {

    private TextView mValueTextView;
    private TextView mUnitTextView;

    public HeartLogView(Context context) {
        this(context, null);
    }

    public HeartLogView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.HeartLogView, 0, 0);
        String unitText = a.getString(R.styleable.HeartLogView_unitLog);
        String valueText = a.getString(R.styleable.HeartLogView_valueLog);
        int colorText = a.getColor(R.styleable.HeartLogView_colorLog, android.R.color.primary_text_dark);
        a.recycle();


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.heart_log, this, true);

        mValueTextView = (TextView) ((LinearLayout)getChildAt(0)).getChildAt(0);
        mUnitTextView = (TextView) ((LinearLayout)getChildAt(0)).getChildAt(1);

        mUnitTextView.setText("BPM");

        setValue(valueText);
        setColor(colorText);

    }

    public HeartLogView(Context context, AttributeSet attrs, int defStyleAttr) {

        this(context, attrs);


    }

    public HeartLogView setColor(int color) {
        mValueTextView.setTextColor(color);
        mUnitTextView.setTextColor(color);
        return this;
    }

    public HeartLogView setValue(String value) {
        mValueTextView.setText(value);
        return this;
    }


}
