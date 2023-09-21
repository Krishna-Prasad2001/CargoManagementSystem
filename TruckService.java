package com.amdocs.CargoManagementSystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.CargoManagementSystem.entity.TruckEntity;
import com.amdocs.CargoManagementSystem.repo.TruckRepository;

@Service
public class TruckService {

    private TruckRepository truckrepo;

    @Autowired
    public TruckService(TruckRepository truckrepo) {
        this.truckrepo = truckrepo;
    }

    public TruckEntity saveTruck(TruckEntity truck) {
        try {
            return truckrepo.save(truck);
        } catch (Exception e) {
            // Handle the exception here, you can log it or throw a custom exception
            e.printStackTrace();
            return null; // Or throw a custom exception if needed
        }
    }

    public List<TruckEntity> getAllTrucks() {
        try {
            return truckrepo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Or throw a custom exception if needed
        }
    }

    public TruckEntity getTruckById(Long truckid) {
        try {
            return truckrepo.findById(truckid).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Or throw a custom exception if needed
        }
    }

    public TruckEntity updateTruck(Long truckid, TruckEntity truck) {
        try {
            TruckEntity existingtruck = truckrepo.findById(truckid).orElse(null);

            if (existingtruck != null) {
                existingtruck.setModelname(truck.getModelname());
                existingtruck.setPurchaseDate(truck.getPurchaseDate());
                return truckrepo.save(existingtruck);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Or throw a custom exception if needed
        }
    }

    public void deleteTruck(Long truckid) {
        try {
            truckrepo.deleteById(truckid);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception here, you can log it or throw a custom exception
        }
    }
}
