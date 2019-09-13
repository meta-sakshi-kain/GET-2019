package com.metacube.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.dao.VehicleDao;
import com.metacube.model.pojo.Vehicle;
import com.metacube.service.VehicleService;
@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		
		return vehicleDao.addVehicle(vehicle);
	}

}
