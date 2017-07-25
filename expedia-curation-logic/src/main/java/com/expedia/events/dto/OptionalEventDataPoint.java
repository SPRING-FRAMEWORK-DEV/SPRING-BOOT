package com.expedia.events.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class OptionalEventDataPoint {


	/**
	<pre>
	Additionally, we would like to collect the following data points when they are available [Optional]:
	8.	Event category (Business, Leisure, MICE, etc.)
	9.	Recurring Event Flag
	10.	Bank Holiday Flag
	11.	Event Address
	12.	Event City
	13.	Event Country
	</pre>
	*/
	
	// valid
	@NotEmpty(message="Event Category Required")
	@Pattern(regexp="^[^\\<>]*$",message="Event Category contains Invalid Characters")
	private String eventCategory;
	
	private boolean isRecurringEvent;
	private boolean isBankHoliday;
	private String eventAddress;
	private String city;
	private String country;
	public OptionalEventDataPoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OptionalEventDataPoint(String eventCategory, boolean isRecurringEvent, boolean isBankHoliday,
			String eventAddress, String city, String country) {
		super();
		this.eventCategory = eventCategory;
		this.isRecurringEvent = isRecurringEvent;
		this.isBankHoliday = isBankHoliday;
		this.eventAddress = eventAddress;
		this.city = city;
		this.country = country;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public boolean isRecurringEvent() {
		return isRecurringEvent;
	}
	public void setRecurringEvent(boolean isRecurringEvent) {
		this.isRecurringEvent = isRecurringEvent;
	}
	public boolean isBankHoliday() {
		return isBankHoliday;
	}
	public void setBankHoliday(boolean isBankHoliday) {
		this.isBankHoliday = isBankHoliday;
	}
	public String getEventAddress() {
		return eventAddress;
	}
	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
