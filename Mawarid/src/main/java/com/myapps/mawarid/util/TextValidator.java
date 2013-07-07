package com.myapps.mawarid.util;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by mohammad_abdullah on 7/7/13.
 */

public class TextValidator {

    public static void validateEmptyField(final Activity ownerActivity, int textViewResourceId,
                                          final int errorMsgResourceId) {

        final EditText editText = (EditText) ownerActivity.findViewById(textViewResourceId);
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (editText.getText() != null) {
                        String editTextString = editText.getText().toString();

                        if (TextUtils.isEmpty(editTextString)) {
                            editText.setError(ownerActivity.getResources().getString(errorMsgResourceId));
                        }
                    }
                }
            });
        }


    }
}


