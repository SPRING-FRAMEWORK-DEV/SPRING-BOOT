package com.exp.events.bo;

public class Location {

	private Float longitude;
	private Float latitude;
	public Location(Float longitude, Float latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
