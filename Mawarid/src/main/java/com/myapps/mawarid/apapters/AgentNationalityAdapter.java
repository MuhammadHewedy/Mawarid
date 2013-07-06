package com.myapps.mawarid.apapters;

import android.content.Context;

import com.myapps.mawarid.App;
import com.myapps.mawarid.model.Lookup;

import java.util.List;

/**
 * Created by mhewedy on 7/6/13.
 */
public class AgentNationalityAdapter extends AbstractArrayAdapter<List<Lookup>, Lookup> {

    public AgentNationalityAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId, null);
    }

    @Override
    protected void loadNextPage() {
        super.loadNextPage();
        App.get().getApi().getAgentNationalityLookup(this, this);
    }

    @Override
    public void onResponse(List<Lookup> response) {
        super.onResponse(response);
        mList.addAll(response);
        notifyDataSetChanged();
    }
}
