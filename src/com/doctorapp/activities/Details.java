package com.doctorapp.activities;

import java.io.Serializable;

public class Details  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String date;
	private String time;
	private String reason;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
