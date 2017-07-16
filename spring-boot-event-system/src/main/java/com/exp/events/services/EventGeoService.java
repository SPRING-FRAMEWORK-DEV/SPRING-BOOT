package com.exp.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import com.exp.events.bo.Event;
import com.exp.events.dto.EventRepresentation;
import com.exp.events.repository.EventGeoRepository;

@Component
public class EventGeoService {

	@Autowired
	private EventGeoRepository eventGeoRepository;

	public void createEvent(EventRepresentation eventRepresentation) {

		Event eventPersistenceModel = new Event();
		eventPersistenceModel.setEventName(eventRepresentation.getEventName());
		eventPersistenceModel.setEventProvider(eventRepresentation.getEventProvider());
		eventPersistenceModel.setEventAddress(eventRepresentation.getEventAddress());
		eventPersistenceModel.setGeoLoaction(eventRepresentation.getGeoLoaction());

		eventGeoRepository.insertEvent(eventPersistenceModel);
	}

	public List<Event> findAll() {
		return eventGeoRepository.selectAllEvents();
	}

	public List<Event> findByDistance(Double longitude, Double latitude, Float distance) {

		System.out.println(longitude+"--"+latitude+"--"+distance);
		Point basePoint = new Point(longitude, latitude);
		Distance radius = new Distance(distance, Metrics.KILOMETERS);
		Circle area = new Circle(basePoint, radius);

		System.out.println(area);
		return eventGeoRepository.selectAllEventsByDistance(area);
	}
}
