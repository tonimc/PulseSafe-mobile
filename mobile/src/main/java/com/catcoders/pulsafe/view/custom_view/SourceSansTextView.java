package com.catcoders.pulsafe.view.custom_view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class SourceSansTextView extends TextView {
    public SourceSansTextView(Context context) {

        super(context);

        if (!isInEditMode())
            init(context);
    }

    public SourceSansTextView(Context context, AttributeSet attrs) {

        super(context, attrs);

        if (!isInEditMode())
            init(context);
    }

    public SourceSansTextView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            init(context);

    }

    private void init(Context context) {

        Typeface t = Typeface.createFromAsset(context.getAssets(), "SourceSansPro.ttf");
        this.setTypeface(t);
    }
}
