package com.myapps.mawarid.adapters;

import android.content.Context;

import com.myapps.mawarid.App;

/**
 * Created by mhewedy on 7/6/13.
 */
public class AgentNationalityAdapter extends LookupSpinnerAdapter {

    public AgentNationalityAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    protected void loadNextPage() {
        super.loadNextPage();
        mInFlightRequest = App.get().getApi().getAgentNationalityLookup(this, this);
    }
}
