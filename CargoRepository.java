package com.amdocs.CargoManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.CargoManagementSystem.entity.Cargo;
@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

	//findByxxx
	//Customized queries
}