package com.myapps.mawarid.api;

import com.android.volley.RequestQueue;

/**
 * Created by mohammad_abdullah on 6/26/13.
 */
public class ServerApi {

    public static final String API_CHARSET = "UTF-8";
    private static final int PAGE_SIZE = 20;

    private final RequestQueue mRequestQueue;

    public ServerApi(RequestQueue mRequestQueue) {
        this.mRequestQueue = mRequestQueue;
    }

    /*public Request<?> search(String query, int pageNum, Listener<PartSearchReturn> listener,
                             ErrorListener errorListener) {
        return mRequestQueue.add(new PartSearchRequest(query, pageNum, listener, errorListener));
    }*/


    /**
     * @param page zero-based page number
     * @return
     */
    public static int[] getFromAndTo(int page){
        int from = page * ServerApi.PAGE_SIZE + 1;
        int to = from + ServerApi.PAGE_SIZE - 1;
        return new int[]{from, to};
    }
}
