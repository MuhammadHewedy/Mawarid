package com.myapps.mawarid.api;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.myapps.mawarid.App;
import com.myapps.mawarid.R;
import com.myapps.mawarid.util.Logger;

import java.io.UnsupportedEncodingException;

/**
 * Created by mohammad_abdullah on 7/1/13.
 */
public abstract class AbstractRequest<T> extends Request<T> {

    private final String mFunction;
    private final Response.Listener<T> mListener;

    public AbstractRequest(String function, String urlParams, Response.Listener<T> listener,
                           Response.ErrorListener errorListener) {
        super(Method.GET, App.get().getString(R.string.service_base_url) + urlParams,
                errorListener);
        this.mFunction = function;
        this.mListener = listener;
    }

    @Override
    protected final void deliverResponse(T response) {
        this.mListener.onResponse(response);
    }

    @Override
    protected final Response<T> parseNetworkResponse(NetworkResponse response) {
        String jsonString = null;
        try {
            jsonString = new String(response.data, ServerApi.API_CHARSET);
        } catch (UnsupportedEncodingException ex) {
            Logger.e(null, ex, ex.getMessage());
        }
        T object = getObjectFromJson(jsonString);
        return Response.success(object, getCacheEntry());
    }

    public abstract T getObjectFromJson(String json);
}
