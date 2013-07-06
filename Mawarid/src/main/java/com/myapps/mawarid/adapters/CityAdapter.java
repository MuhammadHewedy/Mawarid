package com.myapps.mawarid.adapters;

import android.content.Context;

import com.myapps.mawarid.App;

/**
 * Created by mhewedy on 7/7/13.
 */
public class CityAdapter extends LookupSpinnerAdapter {

    public CityAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    protected void loadNextPage() {
        super.loadNextPage();
        mInFlightRequest = App.get().getApi().getCityLookup(this, this);
    }
}
