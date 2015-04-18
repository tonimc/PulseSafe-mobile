package com.catcoders.pulsafe.helper;

import android.content.Context;

import com.catcoders.pulsafe.R;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

/**
 * Created by tonimc on 17/4/15.
 */
public class MessageHelper {

    public static void showMessage(Context context, String message) {
        Snackbar loadingSnackBar = Snackbar.with(context)
                .text(message)
                .actionLabel(context.getString(R.string.close))
                .duration(Snackbar.SnackbarDuration.LENGTH_INDEFINITE)
                .color(context.getResources().getColor(R.color.primary))
                .actionColor(context.getResources().getColor(R.color.accent));

        SnackbarManager.show(loadingSnackBar);
    }
}
