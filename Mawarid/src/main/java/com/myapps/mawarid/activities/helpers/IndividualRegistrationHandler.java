package com.myapps.mawarid.activities.helpers;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.myapps.mawarid.App;
import com.myapps.mawarid.R;
import com.myapps.mawarid.activities.IndividualsRequestActivity;
import com.myapps.mawarid.adapters.LookupSpinnerAdapter;
import com.myapps.mawarid.model.Lookup;
import com.myapps.mawarid.util.Logger;

import java.util.HashMap;
import java.util.Map;

public class IndividualRegistrationHandler implements Response.Listener, Response.ErrorListener {

    private static final String[] TEXT_PARAM_NAMES = {"BirthDate", "DistrictName", "Email", "FamilyName",
            "SecondName", "FirstName", "ThirdName", "IDNumber", "__JOB_ID_", "MobileNumber", "OtherPhone", "LandLine", "WorkName",
            "Number", "Notes"};
    private static final String[] SPINNER_PARAM_NAMES = {"NationalityID", "CityID", "SectorID", "ReqProfessionID",
            "ReqNationalityID", "HowComeID", "SexId", "Salary"};
    private final IndividualsRequestActivity mIndividualsRequestActivity;


    public IndividualRegistrationHandler(IndividualsRequestActivity individualsRequestActivity) {
        mIndividualsRequestActivity = individualsRequestActivity;
    }

    public void register() {
        App.get().getApi().submitIndividualRequest(getPostData(), this, this);
    }

    private Map<String, String> getPostData() {
        Map<String, String> map = new HashMap<String, String>();

        EditText[] allEditText = mIndividualsRequestActivity.getAllTextEditRef();
        Spinner[] allSpinner = mIndividualsRequestActivity.getAllSpinnerRef();

        for (int i = 0; i < allEditText.length; i++) {
            map.put(TEXT_PARAM_NAMES[i], allEditText[i].getText().toString());
        }

        for (int i = 0; i < allSpinner.length; i++) {

            String selectedCode = "";

            if (allSpinner[i].getAdapter() instanceof LookupSpinnerAdapter){
                Lookup lookup = (Lookup) allSpinner[i].getSelectedItem();
                selectedCode = String.valueOf(lookup.getCode());
            }else{
                selectedCode = String.valueOf(allSpinner[i].getSelectedItemPosition());
            }

            map.put(SPINNER_PARAM_NAMES[i], selectedCode);
        }
        Logger.d(null, map.toString());
        return map;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Logger.e(null, error, error.getMessage());
        Toast.makeText(App.get(), mIndividualsRequestActivity.getString(R.string.registration_error_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(Object response) {
        Toast.makeText(App.get(), mIndividualsRequestActivity.getString(R.string.registration_success_text), Toast.LENGTH_SHORT).show();
        mIndividualsRequestActivity.finish();
    }
}