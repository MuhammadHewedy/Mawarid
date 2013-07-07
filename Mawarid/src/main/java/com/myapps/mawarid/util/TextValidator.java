package com.myapps.mawarid.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mohammad_abdullah on 7/7/13.
 */

public class TextValidator {

    // consider using this https://github.com/ragunathjawahar/android-saripaar

    public static boolean validate(final EditText editText, final String errorMsg) {

        if (editText == null)
            return false;

        if (editText.getText() == null || TextUtils.isEmpty(editText.getText().toString())) {
            editText.setError(errorMsg);
            return false;
        } else {
            editText.setError(null);
            return true;
        }
    }

    public static void addEmptyFieldValidator(final EditText editText, final String errorMsg) {

        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        if (TextUtils.isEmpty(editText.getText().toString())) {
                            editText.setError(errorMsg);
                        }
                    } else {
                        editText.setError(null);
                    }
                }
            });

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (TextUtils.isEmpty(editText.getText().toString())) {
                        editText.setError(errorMsg);
                    } else {
                        editText.setError(null);
                    }
                }
            });
        }
    }
}


