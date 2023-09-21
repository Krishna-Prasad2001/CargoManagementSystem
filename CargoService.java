package com.amdocs.CargoManagementSystem.service;

import java.util.List;
import com.amdocs.CargoManagementSystem.entity.Cargo;

public interface CargoService {

	public boolean saveCargoId(Cargo cargo);
	
	public List<Cargo> viewAllCargo();
	
	public Cargo getCargoId(int id);

	public boolean updateCargo(Cargo st);

	public boolean deleteCargoId(int id);	
}