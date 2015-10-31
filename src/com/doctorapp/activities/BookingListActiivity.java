package com.doctorapp.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class BookingListActiivity extends Activity {
	private ListView listview;
	private ArrayList<Details> patientList;
	private BookingListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patientlist);
		listview = (ListView) findViewById(R.id.list);

		patientList = (new DatabaseHelper(getApplicationContext())).getListOfPatients();

		adapter = new BookingListAdapter(getApplicationContext(), patientList);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(BookingListActiivity.this, NewPatientActivity.class);
				intent.putExtra("details", patientList.get(position));
				startActivity(intent);
			}
		});

	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		patientList = (new DatabaseHelper(getApplicationContext())).getListOfPatients();
		adapter = new BookingListAdapter(getApplicationContext(), patientList);
		listview.setAdapter(adapter);
	}
}
