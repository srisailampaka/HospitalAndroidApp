package com.doctorapp.activities;

import java.util.ArrayList;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BookingListAdapter extends ArrayAdapter<Details> {
	private ArrayList<Details> detailsList;
	private Context mContext;

	public BookingListAdapter(Context mContext, ArrayList<Details> detailsList) {
		super(mContext, R.id.item_list);

		this.detailsList = detailsList;
		this.mContext = mContext;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return detailsList.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.pl_item_list, null);

		TextView name = (TextView) view.findViewById(R.id.name_pl);
		TextView dateandime = (TextView) view.findViewById(R.id.date_time);
		TextView reason = (TextView) view.findViewById(R.id.reason_pl);

		Details details = detailsList.get(position);
		name.setText(details.getName());
		reason.setText(details.getReason());
		dateandime.setText(details.getDate()+","+details.getTime());

		return view;
	}
}
