package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.model.VehicleModel;
import com.java.repositories.VehicleDao;

@Service
public class VehicleService {
	@Autowired
	VehicleDao dao;
	@Transactional
	public int addVehicle(VehicleModel model)
	{
		return dao.insertVehicle(model);
	}
	@Transactional
	public int updateVehicle(VehicleModel model)
	{
		return dao.updateVehicle(model);
	}
	@Transactional
	public int deleteVehicle(int vId)
	{
		return dao.deleteVehicle(vId);
	}

}
