package com.catcoders.pulsafe.helper;

import android.content.Context;
import android.content.res.Resources;

import com.catcoders.pulsafe.R;

/**
 * Created by tonimc on 17/4/15.
 */
public class ResourceHelper {

    public static int getDrawableInt(String name) {
        try {
            return R.drawable.class.getField(name).getInt(null);
        } catch (IllegalAccessException e) {
        } catch (NoSuchFieldException e) {
        }
        return 0;
    }


}
