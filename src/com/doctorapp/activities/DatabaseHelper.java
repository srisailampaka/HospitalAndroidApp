package com.doctorapp.activities;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Logcat tag
	private static final String LOG = "DatabaseHelper";

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "docotor";

	// Table Names
	private static final String TABLE_BOOK = "book";

	// Common Column names
	private static final String KEY_ID = "id";
	private static final String KEY_DOCTOR_NAME = "dname";
	private static final String KEY_DATE = "date";
	private static final String KEY_TIME = "time";
	private static final String KEY_REASON = "reason";

	// Table Create Statements
	// Todo table create statement
	private static final String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_BOOK + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY," + KEY_DOCTOR_NAME + " TEXT," + KEY_DATE + " TEXT," + KEY_TIME + " TEXT,"
			+ KEY_REASON + " TEXT" + ")";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		db.execSQL(CREATE_TABLE_STUDENT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_STUDENT);

		// create new tables
		onCreate(db);
	}

	public long bookTheDetails(Details details) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DOCTOR_NAME, details.getName());
		values.put(KEY_DATE, details.getDate());
		values.put(KEY_TIME, details.getTime());

		values.put(KEY_REASON, details.getReason());

		// insert row
		long todo_id = db.insert(TABLE_BOOK, null, values);

		return todo_id;
	}

	public void updateTheValues(int id, String date, String time) {

		String selectQuery = "UPDATE  " + TABLE_BOOK + " SET " + KEY_DATE + "='" + date + "'," + KEY_TIME + "='"
				+ time + "' WHERE " + KEY_ID + "='" + id + "'";
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL(selectQuery);
	}

	public ArrayList<Details> getListOfPatients() {
		ArrayList<Details> list = new ArrayList<Details>();
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT *FROM " + TABLE_BOOK;

		Cursor c = db.rawQuery(selectQuery, null);
		if (c != null)
			c.moveToFirst();

		while (!c.isAfterLast()) {
			Details detail = new Details();
			detail.setId(c.getInt(c.getColumnIndex(KEY_ID)));
			detail.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
			detail.setName(c.getString(c.getColumnIndex(KEY_DOCTOR_NAME)));
			detail.setTime(c.getString(c.getColumnIndex(KEY_TIME)));
			detail.setReason(c.getString(c.getColumnIndex(KEY_REASON)));
			list.add(detail);
			c.moveToNext();

		}
		return list;
	}

	

}
