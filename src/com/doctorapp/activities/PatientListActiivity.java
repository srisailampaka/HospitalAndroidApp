package com.doctorapp.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class PatientListActiivity extends Activity {
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patientlist);
		ListView listview = (ListView) findViewById(R.id.list);

		final ArrayList<Details> detailList = new ArrayList<Details>();

		Details detail = new Details();
		detail.setName("Hari");
		detail.setDate("22/7/2015");
	    detail.setTime("10:00am");
		detail.setReason("Fever");
		detailList.add(detail);

		Details detail1 = new Details();
		detail1.setName("raj");
		detail1.setDate("29/7/2015");
        detail1.setTime("10:00am");
		detail1.setReason("cold");
		detailList.add(detail1);

		Details detail2 = new Details();
		detail2.setName("sri");
		detail2.setDate("2/9/2015");
		detail2.setTime("09:00 AM");
		detail2.setReason("Viral Infection");
		detailList.add(detail2);

		PatientListAdapter adapter = new PatientListAdapter(getApplicationContext(), detailList);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(PatientListActiivity.this, NewPatientActivity.class);
				intent.putExtra("details", detailList.get(position));
                startActivity(intent);
			}
		});

	}

}
