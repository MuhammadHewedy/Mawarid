package com.myapps.mawarid.util;

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
}
