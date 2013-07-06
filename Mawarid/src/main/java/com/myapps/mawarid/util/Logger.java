package com.myapps.mawarid.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by mohammad_abdullah on 6/26/13.
 */
public class Logger {

    private static final String DEFAULT_TAG = "Mawarid";

    private Logger() {
    }

    public static void d(String TAG, String msg, Object... args) {
        if (args != null && args.length > 0) {
            msg = String.format(msg, args);
        }
        Log.d(TextUtils.isEmpty(TAG) ? DEFAULT_TAG : TAG, msg);
    }

    public static void e(String TAG, Throwable t, String msg, Object... args) {
        if (args != null && args.length > 0) {
            msg = String.format(msg, args);
        }
        Log.e(TextUtils.isEmpty(TAG) ? DEFAULT_TAG : TAG, msg, t);
    }
}
