package com.myapps.mawarid.api;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import java.util.Map;

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

    /**
     * @param page zero-based page number
     * @return
     */
    public static int[] getFromAndTo(int page) {
        int from = page * ServerApi.PAGE_SIZE + 1;
        int to = from + ServerApi.PAGE_SIZE - 1;
        return new int[]{from, to};
    }

    public Request<?> addToQueue(Request request){
        return mRequestQueue.add(request);
    }

    public void submitIndividualRequest(Map<String, String> params, Response.Listener<Void> listener,
                                        Response.ErrorListener errorListener){
        mRequestQueue.add(new SubmitIndividualRequest(params, listener, errorListener));
    }
}
