package com.exp.events.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.exp.events.bo.Event;

@Repository
public class EventGeoRepository {

	@Autowired
	private MongoOperations mongoOperations;

	public void insertEvent(Event event) {
		mongoOperations.save(event);
	}

	public List<Event> selectAllEvents() {
		return mongoOperations.findAll(Event.class);
	}

	public List<Event> selectAllEventsByDistance(Circle circle) {

		Query query = new Query();
		query.addCriteria(Criteria.where("geoLoaction").withinSphere(circle));
		query.addCriteria(Criteria.where("eventAddress").in("bangalore"));
		return mongoOperations.find(query, Event.class);
	}
}
