package com.myapps.mawarid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Regex;
import com.mobsandgeeks.saripaar.annotation.Required;
import com.mobsandgeeks.saripaar.annotation.SpinnerNotChosen;
import com.myapps.mawarid.R;
import com.myapps.mawarid.adapters.LookupSpinnerAdapter;
import com.myapps.mawarid.api.AgentNatLookupRequest;
import com.myapps.mawarid.api.CityRequest;
import com.myapps.mawarid.api.HowKnowRequest;
import com.myapps.mawarid.api.LookupRequest;
import com.myapps.mawarid.api.RequestJobRequest;
import com.myapps.mawarid.api.RequestNatRequest;
import com.myapps.mawarid.api.SectorRequest;
import com.myapps.mawarid.util.BaseValidationListener;
import com.myapps.mawarid.util.FontsUtil;

/**
 * Created by mhewedy on 7/6/13.
 */
public class IndividualsRequestActivity extends Activity {

    @SpinnerNotChosen(order = 6, messageResId = R.string.error_gender_text)
    private Spinner mGenderSpinner;
    @SpinnerNotChosen(order = 10, messageResId = R.string.error_city_text)
    private Spinner mCitySpinner;
    @SpinnerNotChosen(order = 12, messageResId = R.string.error_sector_text)
    private Spinner mSectorSpinner;
    @SpinnerNotChosen(order = 15, messageResId = R.string.error_sal_text)
    private Spinner mSalSpinner;
    @SpinnerNotChosen(order = 16, messageResId = R.string.error_required_job_text)
    private Spinner mRequiredJobSpinner;
    @SpinnerNotChosen(order = 17, messageResId = R.string.error_required_nat_text)
    private Spinner mRequiredNatSpinner;
    private Spinner mAgentNatSpinner;
    private Spinner mHowKnowSpinner;
    @Required(order = 1, messageResId = R.string.error_fname_text)
    private EditText mFirstNameEditText;
    @Required(order = 2, messageResId = R.string.error_family_text)
    private EditText mFamilyNameEditText;
    @Required(order = 3, messageResId = R.string.error_mobile_text)
    private EditText mMobilePhoneEditText;
    @Required(order = 4, messageResId = R.string.error_email_text)
    @Email(order = 5, messageResId = R.string.error_invalid_email_text)
    private EditText mEmailEditText;
    @Required(order = 7, messageResId = R.string.error_bdate_text)
    @Regex(order = 8, patternResId = R.string.regex_date,
            messageResId = R.string.error_invalid_date_text)
    private EditText mbirthDateEditText;
    @Required(order = 9, messageResId = R.string.error_id_text)
    private EditText mIdEditText;
    @Required(order = 11, messageResId = R.string.error_dist_text)
    private EditText mDistrictEditText;
    @Required(order = 13, messageResId = R.string.error_work_text)
    private EditText mWorkEditText;
    @Required(order = 14, messageResId = R.string.error_job_text)
    private EditText mJobEditText;
    private EditText mOtherPhoneEditText;
    private EditText mGFatherEditText;
    private EditText mFatherNameEditText;
    private EditText mPermanentPhoneEditText;
    private EditText mReqNumberEditText;
    private EditText mNotesEditText;
    private Button mRegisterRequestButton;
    private EditText[] mAllEditTextRef;
    private Spinner[] mAllSpinnerRef;
    private Validator mValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individuals_request);

        ViewFinder viewFinder = new ViewFinder();
        mAllEditTextRef = viewFinder.findEditTextsById();
        mAllSpinnerRef = viewFinder.findSpinnersById();
        mRegisterRequestButton = (Button) findViewById(R.id.register_request_button);

        mValidator = new Validator(this);
        mValidator.setValidationListener(new BaseValidationListener() {
            @Override
            public void onSuccess() {
                registerIndividualRequest();
            }
        });

        adjustEditTextProperties();
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

    private void adjustEditTextProperties() {
        for (int i = 0; i < mAllEditTextRef.length; i++) {
            EditText editText = mAllEditTextRef[i];
            FontsUtil.adjustFont(editText);
        }
        FontsUtil.adjustFont(mRegisterRequestButton);
    }

    public void registerRequestClicked(View view) {
        mValidator.validate();
    }

    private void registerIndividualRequest() {
        Toast.makeText(this, "Register on Server succeed!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // todo show warning dialog
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
