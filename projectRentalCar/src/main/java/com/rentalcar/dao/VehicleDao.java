package com.rentalcar.dao;

import java.util.List;

import com.rentalcar.entity.Vehicle;

public interface VehicleDao {
	int saveVehicle(Vehicle vehicle);
	 
    void updateVehicle(Vehicle vehicle);
 
    void deleteVehicle(int id);
 
    Vehicle findVehicleById(int id);
    
    List<Vehicle> findVehicleByModello(String modello);
    
    List<Vehicle> findVehicleByCasa(String casa);
    
    List<Vehicle> findVehicleByAnno(String anno);
     
    List<Vehicle> findAllVehicles();
}
