package com.doctorapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button doctorloginButton;
	private Button patientloginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		doctorloginButton = (Button) findViewById(R.id.edit_profile_button);

		doctorloginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, DoctorLoginActivity.class);
				startActivity(intent);

			}

		});
		patientloginButton = (Button) findViewById(R.id.bookings_button);
		patientloginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,PatientLoginActivity.class);
				startActivity(intent);
			}
		});

	}

}
