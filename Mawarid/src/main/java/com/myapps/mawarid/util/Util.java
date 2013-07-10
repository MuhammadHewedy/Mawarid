package com.myapps.mawarid.util;

import android.widget.Toast;

import com.myapps.mawarid.App;

/**
 * Created by mohammad_abdullah on 7/7/13.
 */
public class Util {

    public static boolean in(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n)
                return true;
        }
        return false;
    }

    public static void showToast(String msg){
        Toast.makeText(App.get(), msg, Toast.LENGTH_SHORT).show();
    }
}
