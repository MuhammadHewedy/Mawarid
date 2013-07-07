package com.myapps.mawarid.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapps.mawarid.App;
import com.myapps.mawarid.api.LookupRequest;
import com.myapps.mawarid.model.Lookup;
import com.myapps.mawarid.util.FontsUtil;

import java.util.List;

/**
 * Created by mhewedy on 7/7/13.
 */
public class LookupSpinnerAdapter extends AbstractArrayAdapter<List<Lookup>, Lookup> {

    private LookupRequest mLookupRequest;

    public LookupSpinnerAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId, null);
    }

    public static LookupSpinnerAdapter newInstance(Context context) {
        return new LookupSpinnerAdapter(context, android.R.layout.simple_spinner_item);
    }

    public void setLookupRequest(LookupRequest lookupRequest) {
        this.mLookupRequest = lookupRequest;
    }

    @Override
    public void onResponse(List<Lookup> response) {
        super.onResponse(response);
        mList.addAll(response);
        notifyDataSetChanged();
    }

    @Override
    protected void loadNextPage() {
        super.loadNextPage();
        if (mLookupRequest == null) {
            throw new IllegalStateException("LookupRequest couldn't be null");
        }
        mInFlightRequest = App.get().getApi().addToQueue(mLookupRequest);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        FontsUtil.adjustFont((TextView) view);
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        FontsUtil.adjustFont((TextView) view);
        return view;
    }
}
