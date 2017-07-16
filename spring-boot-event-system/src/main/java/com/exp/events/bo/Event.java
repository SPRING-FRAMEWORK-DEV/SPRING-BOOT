package com.exp.events.bo;

import org.springframework.data.annotation.Id;

public class Event {

	@Id
	private String id;

	private String eventName;

	private String eventProvider;

	private String eventAddress;

	private Location geoLoaction;

	public Event(String eventName, String eventProvider, String eventAddress, Location geoLoaction) {
		super();
		this.eventName = eventName;
		this.eventProvider = eventProvider;
		this.eventAddress = eventAddress;
		this.geoLoaction = geoLoaction;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventProvider() {
		return eventProvider;
	}

	public void setEventProvider(String eventProvider) {
		this.eventProvider = eventProvider;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public Location getGeoLoaction() {
		return geoLoaction;
	}

	public void setGeoLoaction(Location geoLoaction) {
		this.geoLoaction = geoLoaction;
	}

}
