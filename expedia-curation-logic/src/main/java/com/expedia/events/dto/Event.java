package com.expedia.events.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.expedia.events.utils.EventDateFormat;

public class Event {

	/**
	 * <pre>
	Fields
	To have a useful list of events, we need to ensure that the following information is available for each event [Mandatory]:
	1.	Event ID
	2.	Event Source ID
	3.	Event Source Provider Name
	4.	Event Name
	5.	Event Lat/Long
	6.	Event Start Date
	7.	Event End Date
	 * </pre>
	 */

	private String eventId;
	private String eventSourceId;
	private String eventSourceProviderName;

	// valid
	@NotEmpty(message = "Event Name Required")
	@Pattern(regexp = "^[^\\<>]*$", message = "Event Name contains Invalid Characters")
	private String eventName;

	// valid
	@NotEmpty(message = "Latitude Required")
	@Range(min = -90, max = 90)
	private String latitude;

	// valid
	@NotEmpty(message = "Longitude Required")
	@Range(min = -180, max = 180)
	private String longitude;

	// valid
	@EventDateFormat(format = "MM/dd/yyyy")
	private String eventStartDate;
	// valid
	@EventDateFormat(format = "MM/dd/yyyy")
	private String eventEndDate;

	private OptionalEventDataPoint dataPoint;

	private String expEventId;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventSourceId() {
		return eventSourceId;
	}

	public void setEventSourceId(String eventSourceId) {
		this.eventSourceId = eventSourceId;
	}

	public String getEventSourceProviderName() {
		return eventSourceProviderName;
	}

	public void setEventSourceProviderName(String eventSourceProviderName) {
		this.eventSourceProviderName = eventSourceProviderName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public OptionalEventDataPoint getDataPoint() {
		return dataPoint;
	}

	public void setDataPoint(OptionalEventDataPoint dataPoint) {
		this.dataPoint = dataPoint;
	}

	public String getExpEventId() {
		return expEventId;
	}

	public void setExpEventId(String expEventId) {
		this.expEventId = expEventId;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

}
