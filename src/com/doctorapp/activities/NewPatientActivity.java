package com.doctorapp.activities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class NewPatientActivity extends Activity {
	private Button submitButton;
	private EditText editname;
	private EditText editdate;
	private EditText edittime;
	private EditText editreason;
	private DatePickerDialog datePickerDialog;
	private TimePickerDialog timePickerDialog;
	private SimpleDateFormat dateFormatter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newpatient);

		final Details detail = (Details) getIntent().getExtras().get("details");
		editname = (EditText) findViewById(R.id.name_et);
		editdate = (EditText) findViewById(R.id.date_et);
		edittime = (EditText) findViewById(R.id.time_et);
		editreason = (EditText) findViewById(R.id.reason_et);
		editname.setText(detail.getName());
		editdate.setText(detail.getDate());
		edittime.setText(detail.getTime());
		editreason.setText(detail.getReason());
		editname.setEnabled(false);
		editreason.setEnabled(false);

		Calendar newCalendar = Calendar.getInstance();
		dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		editdate.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				datePickerDialog.show();
				return false;
			}
		});
		edittime.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				timePickerDialog.show();
				return false;
			}
		});

		datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				Calendar newDate = Calendar.getInstance();
				newDate.set(year, monthOfYear, dayOfMonth);
				editdate.setText(dateFormatter.format(newDate.getTime()));
			}

		}, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

		Calendar mcurrentTime = Calendar.getInstance();
		int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
		int minute = mcurrentTime.get(Calendar.MINUTE);
		timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
				edittime.setText(selectedHour + ":" + selectedMinute);
			}
		}, hour, minute, true);// Yes 24 hour time

		submitButton = (Button) findViewById(R.id.submit_np);

		submitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				(new DatabaseHelper(getApplicationContext())).updateTheValues(detail.getId(), editdate.getText().toString().trim(),
						edittime.getText().toString().trim());
				finish();
			}
		});

	}
}
