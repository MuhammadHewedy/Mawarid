package com.myapps.mawarid.adapters;

import android.content.Context;

import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/7/13.
 */
public class LookupSpinnerAdapter extends AbstractArrayAdapter<List<Lookup>, Lookup> {

    public LookupSpinnerAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId, null);
    }

    @Override
    public void onResponse(List<Lookup> response) {
        super.onResponse(response);
        mList.addAll(response);
        notifyDataSetChanged();
    }
}
