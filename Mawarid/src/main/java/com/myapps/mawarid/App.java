package com.myapps.mawarid;

import android.app.Application;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.myapps.mawarid.api.ServerApi;

/**
 * Created by mhewedy on 7/6/13.
 */
public class App extends Application {

    private static App sInstance;

    public static App get() {
        return sInstance;
    }

    private final LruCache<String, Bitmap> mImageCache = new LruCache<String, Bitmap>(20);

    private ServerApi mApi;

    private ImageLoader mImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        RequestQueue queue = Volley.newRequestQueue(this);
        mApi = new ServerApi(queue);

        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public void putBitmap(String key, Bitmap value) {
                mImageCache.put(key, value);
            }

            @Override
            public Bitmap getBitmap(String key) {
                return mImageCache.get(key);
            }
        };

        mImageLoader = new ImageLoader(queue, imageCache);
    }

    public ServerApi getApi() {
        return mApi;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
