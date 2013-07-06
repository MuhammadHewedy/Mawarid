package com.myapps.mawarid.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.myapps.mawarid.util.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad_abdullah on 7/1/13.
 */
public abstract class AbstractArrayAdapter<RESPONSE_OBJ, ADAPTER_OBJ> extends ArrayAdapter<ADAPTER_OBJ> implements Response
        .Listener<RESPONSE_OBJ>,
        Response.ErrorListener {

    protected final ImageLoader mImageLoader;
    protected final List<ADAPTER_OBJ> mList = new ArrayList<ADAPTER_OBJ>();
    protected Request<?> mInFlightRequest;

    public AbstractArrayAdapter(Context context, int textViewResourceId, ImageLoader imageLoader) {
        super(context, textViewResourceId);
        this.mImageLoader = imageLoader;
    }

    // ArrayAdapter
    @Override
    public final int getCount() {
        return mList.size();
    }

    @Override
    public final ADAPTER_OBJ getItem(int position) {
        return mList.get(position);
    }

    @Override
    public final long getItemId(int position) {
        return getItem(position).hashCode();
    }
    //~ ArrayAdapter


    // Response

    /**
     * should override to add functionality
     */
    @Override
    public void onResponse(RESPONSE_OBJ response) {
        mInFlightRequest = null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        mInFlightRequest = null;
        Logger.e(null, error, error.toString());
    }
    //~ Response


    // Utils

    /**
     * do clean-ups before calling loadNextPage()
     *
     * @param query
     */
    public void query(String... query) {
        if (mInFlightRequest != null)
            mInFlightRequest.cancel();
        mInFlightRequest = null;

        mList.clear();
        notifyDataSetChanged();

        loadNextPage();
    }

    protected void loadNextPage() {
        if (mInFlightRequest != null) {
            return;
        }
    }

    public final void loadMore(int position) {
        if (position > (getCount() - 10)) {
            loadNextPage();
        }
    }
    //~ Utils
}
