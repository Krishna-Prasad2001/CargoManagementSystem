package com.amdocs.CargoManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.CargoManagementSystem.entity.TruckEntity;
import com.amdocs.CargoManagementSystem.service.TruckService;

@RestController
@RequestMapping("/trucks")
public class TruckController {

	private TruckService truckserv;

	@Autowired
	public TruckController(TruckService truckserv) {
		//super();
		this.truckserv = truckserv;
	}
	//Basic URI for API Testing
	
	//http://localhost:8085/trucks
	
	//insert into truck_entity(modelname, purchase_date) values(?,?);
	
	@PostMapping("/insert")
	public TruckEntity saveTruck(@RequestBody TruckEntity truck)
	{
		return truckserv.saveTruck(truck);
	}
	
	//select *from truck_entity

	@GetMapping("/alltrucks")
	public List<TruckEntity> getAllTrucks()
	{
		return truckserv.getAllTrucks();
	}
	
	//select *from truck_entity where truckid=?

	@GetMapping("/{truckid}")
	public TruckEntity getTruckById(@PathVariable Long truckid)
	{
		return truckserv.getTruckById(truckid);
	}
	
	@PutMapping("/update/{truckid}")
	public TruckEntity updateTruck(@PathVariable Long truckid,@RequestBody TruckEntity truck)
	{
		return truckserv.updateTruck(truckid, truck);
	}
	
	@DeleteMapping("/delete/{truckid}")
	public void deleteTruck(@PathVariable Long truckid)
	{
		truckserv.deleteTruck(truckid);
	}
}