package com.myapps.mawarid;

import android.app.Application;
import android.content.Context;

/**
 * Created by mhewedy on 7/6/13.
 */
public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
