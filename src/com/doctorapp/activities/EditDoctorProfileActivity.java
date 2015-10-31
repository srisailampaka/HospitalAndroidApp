package com.doctorapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditDoctorProfileActivity extends Activity {
	private Button submitButton;
	private EditText editname;
	private EditText editdate;
	private EditText edittime;
	private EditText editreason;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newpatient);
		
		
		
		submitButton=(Button)findViewById(R.id.submit_np);
		
		Details detail=(Details) getIntent().getExtras().get("details");
		submitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(EditDoctorProfileActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		
		editname=(EditText)findViewById(R.id.name_et);
		editdate=(EditText)findViewById(R.id.date_et);
		edittime=(EditText)findViewById(R.id.time_et);
		editreason=(EditText)findViewById(R.id.reason_et);
		editname.setText(detail.getName());
		editdate.setText(detail.getDate());
		edittime.setText(detail.getTime());
		editreason.setText(detail.getReason());
		
	}
	}
 



