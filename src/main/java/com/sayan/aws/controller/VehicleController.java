package com.sayan.aws.controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.aws.model.Vehicle;
import com.sayan.aws.repository.VehicleDao;

@RestController
public class VehicleController {

	@Autowired
	private VehicleDao vehicleDao;

	@Bean
	public Supplier<List<Vehicle>> vehicles() {
		return () -> vehicleDao.buildVehicles();
	}

	@Bean
	public Function<String, List<Vehicle>> findVehicleByName() {
		return (input) -> vehicleDao.buildVehicles().stream().filter((order) -> order.getName().equals(input))
				.collect(Collectors.toList());
	}

//	@Bean
//	public Function<APIGatewayProxyRequestEvent,List<Vehicle>> findOrderByName(){
//		return (requestEvent)->vehicleDao.buildOrders().stream()
//				.filter((order)->order.getName().equals(requestEvent.getQueryStringParameters().get("orderName")))
//				.collect(Collectors.toList());
//	}
}
