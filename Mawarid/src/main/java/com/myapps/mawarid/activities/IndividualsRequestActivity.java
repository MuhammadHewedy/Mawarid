package com.myapps.mawarid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.myapps.mawarid.R;
import com.myapps.mawarid.adapters.LookupSpinnerAdapter;
import com.myapps.mawarid.api.AgentNatLookupRequest;
import com.myapps.mawarid.api.CityRequest;
import com.myapps.mawarid.api.HowKnowRequest;
import com.myapps.mawarid.api.LookupRequest;
import com.myapps.mawarid.api.RequestJobRequest;
import com.myapps.mawarid.api.RequestNatRequest;
import com.myapps.mawarid.api.SectorRequest;
import com.myapps.mawarid.util.FontsUtil;

/**
 * Created by mhewedy on 7/6/13.
 */
public class IndividualsRequestActivity extends Activity {

    private Spinner mAgentNatSpinner;
    private Spinner mCitySpinner;
    private Spinner mSectorSpinner;
    private Spinner mRequiredJobSpinner;
    private Spinner mRequiredNatSpinner;
    private Spinner mHowKnowSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individuals_request);

        adjustTextViewFont(new int[]{
                R.id.birth_date_text_view,
                R.id.district_text_view,
                R.id.email_text_view,
                R.id.family_name_text_view,
                R.id.father_name_text_view,
                R.id.first_name_text_view,
                R.id.g_father_text_view,
                R.id.id_text_view,
                R.id.job_text_view,
                R.id.mobile_phone_text_view,
                R.id.other_phone_text_view,
                R.id.permanent_phone_text_view,
                R.id.work_text_view,
                R.id.register_request_button
        });

        setupSpinners();
    }

    private void setupSpinners() {

        LookupSpinnerAdapter spinnerAdapter;

        mAgentNatSpinner = (Spinner) findViewById(R.id.agent_nationality_spinner);
        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mAgentNatSpinner, spinnerAdapter, new AgentNatLookupRequest(spinnerAdapter,
                spinnerAdapter));

        mCitySpinner = (Spinner) findViewById(R.id.city_spinner);
        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mCitySpinner, spinnerAdapter, new CityRequest(spinnerAdapter, spinnerAdapter));

        mSectorSpinner = (Spinner) findViewById(R.id.sector_spinner);
        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mSectorSpinner, spinnerAdapter, new SectorRequest(spinnerAdapter, spinnerAdapter));

        mRequiredJobSpinner = (Spinner) findViewById(R.id.req_job_spinner);
        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mRequiredJobSpinner, spinnerAdapter, new RequestJobRequest(spinnerAdapter, spinnerAdapter));

        mRequiredNatSpinner = (Spinner) findViewById(R.id.req_nat_spinner);
        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mRequiredNatSpinner, spinnerAdapter, new RequestNatRequest(spinnerAdapter,
                spinnerAdapter));

        mHowKnowSpinner = (Spinner) findViewById(R.id.how_know_spinner);
        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mHowKnowSpinner, spinnerAdapter, new HowKnowRequest(spinnerAdapter, spinnerAdapter));
    }

    private void fillSpinner(Spinner spinner, LookupSpinnerAdapter spinnerAdapter,
                             LookupRequest lookupRequest) {
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.setLookupRequest(lookupRequest);
        spinnerAdapter.query();
    }

    private void adjustTextViewFont(int[] textViewIds) {
        for (Integer textViewId : textViewIds) {
            FontsUtil.adjustFont((TextView) findViewById(textViewId));
        }
    }

    public void registerRequestClicked(View view) {
        finish();
    }
}
