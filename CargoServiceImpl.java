package com.amdocs.CargoManagementSystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.CargoManagementSystem.entity.Cargo;
import com.amdocs.CargoManagementSystem.repo.CargoRepository;
import com.amdocs.CargoManagementSystem.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository cargoRepo;

	@Override
	public boolean saveCargoId(Cargo cargo) {

		Cargo cargosave = cargoRepo.save(cargo);
		boolean flag = false;

		if (cargosave != null)
			flag = true;

		return flag;
	}

	@Override
	public List<Cargo> viewAllCargo() {
		
		List<Cargo> cargoRecords = cargoRepo.findAll();
		return cargoRecords;
	}

	@Override
	public Cargo getCargoId(int id) {
		
		Optional<Cargo> cargoId = cargoRepo.findById(id);
		Cargo cargo = cargoId.get();
		return cargo;
	}

	@Override
	public boolean updateCargo(Cargo st) {
		
		return saveCargoId(st);
	}

	@Override
	public boolean deleteCargoId(int id) {
		
		Cargo cargo = getCargoId(id);
		boolean flag=false;
		if(cargo!=null)
		{
			cargoRepo.delete(cargo);
		flag=true;	
		}
		return flag;
	}
}