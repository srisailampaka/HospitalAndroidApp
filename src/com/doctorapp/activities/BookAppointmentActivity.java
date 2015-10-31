package com.doctorapp.activities;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

public class BookAppointmentActivity extends Activity {
	private Button bookButton;
	private EditText date, time;
	private DatePickerDialog datePickerDialog;
	private TimePickerDialog timePickerDialog;
	private SimpleDateFormat dateFormatter;
	private Spinner name;
	private EditText reason;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book);

		bookButton = (Button) findViewById(R.id.book);
		date = (EditText) findViewById(R.id.date_et);
		time = (EditText) findViewById(R.id.time_et);
		name=(Spinner)findViewById(R.id.doctor_spinner);
		reason=(EditText)findViewById(R.id.reason_et);
		Calendar newCalendar = Calendar.getInstance();
		dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		date.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				datePickerDialog.show();
				return false;
			}
		});
		time.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				timePickerDialog.show();
				// TODO Auto-generated method stub
				return false;
			}
		});

		datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				Calendar newDate = Calendar.getInstance();
				newDate.set(year, monthOfYear, dayOfMonth);
				date.setText(dateFormatter.format(newDate.getTime()));
			}

		}, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
		
		Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
		timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
             @Override
             public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                 time.setText( selectedHour + ":" + selectedMinute);
             }
         }, hour, minute, true);//Yes 24 hour time
		
		bookButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Details details=new Details();
				details.setDate(date.getText().toString().trim());
				details.setName(name.getSelectedItem().toString());
				details.setTime(time.getText().toString().trim());
				details.setReason(reason.getText().toString().trim());
				
				(new DatabaseHelper(getApplicationContext())).bookTheDetails(details);
				Intent intent = new Intent(BookAppointmentActivity.this, BookSuccessActivity.class);
				startActivity(intent);

			}

		});

	}

}
