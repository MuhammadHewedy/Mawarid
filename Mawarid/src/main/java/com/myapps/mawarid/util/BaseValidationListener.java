package com.myapps.mawarid.util;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.myapps.mawarid.App;

/**
 * Created by mhewedy on 7/8/13.
 */
public abstract class BaseValidationListener implements Validator.ValidationListener {

    @Override
    public void preValidation() {

    }

    @Override
    public abstract void onSuccess();

    @Override
    public void onFailure(View failedView, Rule<?> failedRule) {
        String message = failedRule.getFailureMessage();

        if (failedView instanceof EditText) {
            failedView.requestFocus();
            ((EditText) failedView).setError(message);
        } else {
            Toast.makeText(App.get(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onValidationCancelled() {

    }
}
