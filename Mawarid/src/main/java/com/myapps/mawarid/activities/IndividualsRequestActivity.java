package com.myapps.mawarid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.myapps.mawarid.R;
import com.myapps.mawarid.apapters.AbstractArrayAdapter;
import com.myapps.mawarid.apapters.AgentNationalityAdapter;
import com.myapps.mawarid.model.Lookup;
import com.myapps.mawarid.util.FontsUtil;

/**
 * Created by mhewedy on 7/6/13.
 */
public class IndividualsRequestActivity extends Activity {

    Spinner mAgentNationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individuals_request);

        adjustTextView(new int[]{
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
        mAgentNationSpinner = (Spinner) findViewById(R.id.agent_nationality_spinner);
        fillSpinner(mAgentNationSpinner, new AgentNationalityAdapter(this,
                android.R.layout.simple_spinner_item));
    }

    private void fillSpinner(Spinner spinner, AbstractArrayAdapter abstractArrayAdapter) {
        abstractArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(abstractArrayAdapter);
        abstractArrayAdapter.query();
    }

    private void adjustTextView(int[] textViewIds) {
        for (Integer textViewId : textViewIds) {
            FontsUtil.adjustFont((TextView) findViewById(textViewId));
        }
    }

    public void registerRequestClicked(View view) {

        Lookup selectedItem = (Lookup) mAgentNationSpinner.getSelectedItem();

        Toast.makeText(this, "todo: Send request to server: " + selectedItem.getValue(),
                Toast.LENGTH_SHORT).show();
        finish();
    }
}
