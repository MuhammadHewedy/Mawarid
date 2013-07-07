package com.myapps.mawarid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.myapps.mawarid.R;
import com.myapps.mawarid.adapters.LookupSpinnerAdapter;
import com.myapps.mawarid.api.*;
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
    private Spinner mGenderSpinner;
    private Spinner mSalSpinner;
    private EditText mbirthDateEditText;
    private EditText mDistrictEditText;
    private EditText mEmailEditText;
    private EditText mFamilyNameEditText;
    private EditText mFatherNameEditText;
    private EditText mFirstNameEditText;
    private EditText mGFatherEditText;
    private EditText mIdEditText;
    private EditText mJobEditText;
    private EditText mMobilePhoneEditText;
    private EditText mOtherPhoneEditText;
    private EditText mPermanentPhoneEditText;
    private EditText mWorkEditText;
    private EditText mReqNumberEditText;
    private EditText mNotesEditText;
    private Button mRegisterRequestButton;
    private EditText[] mAllEditTextRef;
    private Spinner[] mAllSpinnerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individuals_request);

        ViewFinder viewFinder = new ViewFinder();
        mAllEditTextRef = viewFinder.findEditTextsById();
        mAllSpinnerRef = viewFinder.findSpinnersById();
        mRegisterRequestButton = (Button) findViewById(R.id.register_request_button);

        adjustTextViewFont();

        setupSpinners();
    }

    private void setupSpinners() {
        LookupSpinnerAdapter spinnerAdapter;

        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mAgentNatSpinner, spinnerAdapter, new AgentNatLookupRequest(spinnerAdapter, spinnerAdapter));

        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mCitySpinner, spinnerAdapter, new CityRequest(spinnerAdapter, spinnerAdapter));

        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mSectorSpinner, spinnerAdapter, new SectorRequest(spinnerAdapter, spinnerAdapter));

        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mRequiredJobSpinner, spinnerAdapter, new RequestJobRequest(spinnerAdapter, spinnerAdapter));

        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mRequiredNatSpinner, spinnerAdapter, new RequestNatRequest(spinnerAdapter, spinnerAdapter));

        spinnerAdapter = LookupSpinnerAdapter.newInstance(this);
        fillSpinner(mHowKnowSpinner, spinnerAdapter, new HowKnowRequest(spinnerAdapter, spinnerAdapter));

        fillLocalSpinner(mGenderSpinner, R.array.gender_array);
        fillLocalSpinner(mSalSpinner, R.array.salary_array);
    }

    private void fillSpinner(Spinner spinner, LookupSpinnerAdapter spinnerAdapter,
                             LookupRequest lookupRequest) {
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.setLookupRequest(lookupRequest);
        spinnerAdapter.query();
    }

    // todo fix font on old devices -- need to override ArrayAdapter.getView and getDropDownView
    private void fillLocalSpinner(Spinner spinner, int arrayId) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrayId,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void adjustTextViewFont() {
        for (EditText editText : mAllEditTextRef) {
            FontsUtil.adjustFont(editText);
        }
        FontsUtil.adjustFont(mRegisterRequestButton);
    }

    public void registerRequestClicked(View view) {
        Toast.makeText(this, "تم تسجيل طلبك بنجاح !", Toast.LENGTH_SHORT).show();
        finish();
    }

    class ViewFinder {
        private EditText[] findEditTextsById() {
            EditText[] allEditTextRef = new EditText[15];
            allEditTextRef[0] = mbirthDateEditText = (EditText) findViewById(R.id.birth_date_edit_text);
            allEditTextRef[1] = mDistrictEditText = (EditText) findViewById(R.id.district_edit_text);
            allEditTextRef[2] = mEmailEditText = (EditText) findViewById(R.id.email_edit_text);
            allEditTextRef[3] = mFamilyNameEditText = (EditText) findViewById(R.id.family_name_edit_text);
            allEditTextRef[4] = mFatherNameEditText = (EditText) findViewById(R.id.father_name_edit_text);
            allEditTextRef[5] = mFirstNameEditText = (EditText) findViewById(R.id.first_name_edit_text);
            allEditTextRef[6] = mGFatherEditText = (EditText) findViewById(R.id.g_father_edit_text);
            allEditTextRef[7] = mIdEditText = (EditText) findViewById(R.id.id_edit_text);
            allEditTextRef[8] = mJobEditText = (EditText) findViewById(R.id.job_edit_text);
            allEditTextRef[9] = mMobilePhoneEditText = (EditText) findViewById(R.id.mobile_phone_edit_text);
            allEditTextRef[10] = mOtherPhoneEditText = (EditText) findViewById(R.id.other_phone_edit_text);
            allEditTextRef[11] = mPermanentPhoneEditText = (EditText) findViewById(R.id.permanent_phone_edit_text);
            allEditTextRef[12] = mWorkEditText = (EditText) findViewById(R.id.work_edit_text);
            allEditTextRef[13] = mReqNumberEditText = (EditText) findViewById(R.id.req_number_edit_text);
            allEditTextRef[14] = mNotesEditText = (EditText) findViewById(R.id.notes_edit_text);
            return allEditTextRef;
        }

        private Spinner[] findSpinnersById() {
            Spinner[] allEditTextRef = new Spinner[8];
            allEditTextRef[0] = mAgentNatSpinner = (Spinner) findViewById(R.id.agent_nationality_spinner);
            allEditTextRef[1] = mCitySpinner = (Spinner) findViewById(R.id.city_spinner);
            allEditTextRef[2] = mSectorSpinner = (Spinner) findViewById(R.id.sector_spinner);
            allEditTextRef[3] = mRequiredJobSpinner = (Spinner) findViewById(R.id.req_job_spinner);
            allEditTextRef[4] = mRequiredNatSpinner = (Spinner) findViewById(R.id.req_nat_spinner);
            allEditTextRef[5] = mHowKnowSpinner = (Spinner) findViewById(R.id.how_know_spinner);
            allEditTextRef[6] = mGenderSpinner = (Spinner) findViewById(R.id.gender_spinner);
            allEditTextRef[7] = mSalSpinner = (Spinner) findViewById(R.id.sal_spinner);
            return allEditTextRef;
        }
    }
}
