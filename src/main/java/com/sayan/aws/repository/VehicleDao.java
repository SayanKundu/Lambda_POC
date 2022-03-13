package com.sayan.aws.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.sayan.aws.model.Vehicle;

@Repository
public class VehicleDao {
	 public List<Vehicle> buildVehicles(){
	        return Stream.of(
	                new Vehicle(101, "AUDI", 20000, 1),
	                new Vehicle(102, "BMW", 40000, 2),
	                new Vehicle(201, "BMW", 60000, 3),
	                new Vehicle(206, "MERCEDES", 80000, 4)
	        ).collect(Collectors.toList());
	    }
	
}
