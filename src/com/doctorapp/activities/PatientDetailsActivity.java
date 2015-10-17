package com.doctorapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PatientDetailsActivity extends Activity {
	private Button createappointmentButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patientdetails);

		createappointmentButton = (Button) findViewById(R.id.create_apt);

		createappointmentButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PatientDetailsActivity.this, MainActivity.class);
				startActivity(intent);

			}

		});
	
	}

}



