package service.impl;

import domain.Vehicle;
import mapping.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import repository.VehicleRepository;
import service.VehicleService;


import java.util.List;
import java.util.Optional;

/**
 * @author <a href="https://github.com/EliptikWu"
 */
@org.springframework.stereotype.Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * Retrieves a list of vehicles from the vehicle repository.
     *
     * @return a list of Vehicle objects.
     */
    @Override
    public List<Vehicle> getVehicle(){
        return vehicleRepository.listVehicle();
    }

    /**
     * Removes a vehicle from the vehicle repository based on the provided vehicle ID.
     *
     * @param id the ID of the vehicle to be removed.
     */
    @Override
    public void removeVehicle(Long id){
        vehicleRepository.removeVehicle(id);
    }
    /**
     * Retrieves a  vehicle from the  vehicle repository based on the provided  vehicle ID.
     * @param id the ID of the  vehicle to be retrieved.
     * @return an Optional containing the Vehicle object if found, or an empty Optional if not found.
     */
    @Override
    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleRepository.findById(id);
    }
    /**
     * Saves the provided vehicle to the vehicle repository.
     * If the vehicle already exists, it will be updated; otherwise, a new vehicle will be added.
     *
     * @param vehicle the Vehicle object to be saved.
     */
    @Override
    public void saveVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
    /**
     * Adds a new vehicle to the vehicle repository.
     *
     * @param vehicle the Vehicle object to be added.
     */
    @Override
    public void addVehicle(Vehicle vehicle){
        vehicleRepository.addVehicle(vehicle);
    }
}