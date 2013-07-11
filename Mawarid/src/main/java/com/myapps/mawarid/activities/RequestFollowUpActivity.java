package com.myapps.mawarid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.myapps.mawarid.R;
import com.myapps.mawarid.util.FontsUtil;

/**
 * Created by mohammad_abdullah on 7/11/13.
 */
public class RequestFollowUpActivity extends Activity {

    private EditText mIdEditText;
    private EditText mRequestNoEditText;
    private Button mSearchButton;
    private Button mQueryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_request);

        mIdEditText = (EditText) findViewById(R.id.id_edit_text);
        mRequestNoEditText = (EditText) findViewById(R.id.request_no_edit_text);
        mSearchButton = (Button) findViewById(R.id.search_button);
        mQueryButton = (Button) findViewById(R.id.query_button);

        adjustUIProperties();
    }

    private void adjustUIProperties(){
        FontsUtil.adjustFont(mIdEditText);
        FontsUtil.adjustFont(mRequestNoEditText);
        FontsUtil.adjustFont(mSearchButton);
        FontsUtil.adjustFont(mQueryButton);
    }
}
