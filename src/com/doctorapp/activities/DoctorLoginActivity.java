package com.doctorapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DoctorLoginActivity extends Activity {
	
	private Button loginButton;
	private EditText editid;
	private EditText editpassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctorlogin);
		
		
		
		loginButton=(Button)findViewById(R.id.login_dl);
		
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoctorLoginActivity.this,PatientListActiivity.class);
				startActivity(intent);
			}
		});
		
		editid=(EditText)findViewById(R.id.id_et);
		editpassword=(EditText)findViewById(R.id.password_et);
	}
	}
 
