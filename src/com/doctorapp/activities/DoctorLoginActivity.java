package com.doctorapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorLoginActivity extends Activity {
	private Button loginButton;
	private EditText editid;
	private EditText editpassword;
	private String username, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctorlogin);
		editid = (EditText) findViewById(R.id.id_et);
		editpassword = (EditText) findViewById(R.id.password_et);

		loginButton = (Button) findViewById(R.id.login_dl);

		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				username = editid.getText().toString().trim();
				password = editpassword.getText().toString().trim();
				if (username.equalsIgnoreCase("james")
						&& password.equalsIgnoreCase("12345")) {
					Intent intent = new Intent(DoctorLoginActivity.this,
							BookingListActiivity.class);
					startActivity(intent);
					editid.setText("");
					editpassword.setText("");
				} else {
					Toast.makeText(getApplicationContext(),
							"Pleae check the credentials", Toast.LENGTH_LONG)
							.show();
				}
			}
		});

		
	}
}
