package com.myapps.mawarid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.myapps.mawarid.util.FontsUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FontsUtil.adjustFont((Button) findViewById(R.id.individual_button));
        FontsUtil.adjustFont((Button) findViewById(R.id.company_button));
        FontsUtil.adjustFont((Button) findViewById(R.id.followup_button));
    }

    public void openIndividualsActivity(View view) {
        Intent intent = new Intent(this, IndividualsRequestActivity.class);
        startActivity(intent);
    }

    public void openCompanyActivity(View view) {
        Intent intent = new Intent(this, CompanyRequestActivity.class);
        startActivity(intent);
    }

}
